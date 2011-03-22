package test.jcrontab;

import java.io.File;

import org.jcrontab.Crontab;
import org.jcrontab.NativeExec;
import org.jcrontab.SendMail;
import org.jcrontab.data.CrontabEntryBean;
import org.jcrontab.data.CrontabEntryDAO;
import org.jcrontab.data.CrontabParser;

public class JCrontabApp {

	private static Crontab cron = null;
	private String JcrontabFile = null;

	public String getJcrontabFile() {
		return JcrontabFile;
	}

	public void setJcrontabFile(String jcrontabFile) {
		JcrontabFile = jcrontabFile;
	}

    /**
     * ��ʼ��Jcrontab��ͨ��ָ����jcrontab.properties��ִ�о���Ĳ���
     * ����Jcrontab
     */
    protected void init() {
        cron = Crontab.getInstance();
        try {
            ShutdownHook();
            cron.setDaemon(false);
            if (null == JcrontabFile)
                cron.init();
            cron.init(JcrontabFile);
            System.out.println("Start Jcrontab...");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �ر�Jcrontab��ִ��
     * @throws Exception
     */
    protected void ShutdownHook() throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutting down...");
                cron.uninit(200);
                System.out.println("Stoped Jcrontab!");
            }
        });
    }

    /**
     * �ж��Ƿ���Holiday
     * @return
     * @throws Exception
     */
    public boolean isHoliday()throws Exception{
        return cron.isHoliday();
    }

    /**
     * ���ݲ�ͬ�Ĳ���ִ�в�ͬ�Ķ�ʱ���򣬿�ѡ�����ɴ�main�����в鿴
     * @param args
     * @throws Exception
     */
    public void exectue(String[] args) throws Exception {
        if (args.length < 2) {
            return;
        }
        this.setJcrontabFile(args[0]);
        init();
        if ("database".equals(args[1]))
            executeDatabase();
        else if ("appliction".equals(args[1])) {
            String[] parameters = new String[args.length-2];
            System.arraycopy(args,2,parameters,0,args.length-2);
            cron.newTask("org.jcrontab.NativeExec","main",parameters);
        } else if ("javamail".equals(args[1]))
            executeJavaMail(args[2]);
    }

    /**
     * ִ�����ݿ�Ĳ���
     * @throws Exception
     */
    protected void executeDatabase() throws Exception {
        CrontabParser cp = new CrontabParser();
        CrontabEntryBean[] ceb = new CrontabEntryBean[2];
        ceb[0] = cp.marshall("* * * * * com.aweb.test.NumTest 123");
        ceb[0].setYears("*");
        ceb[0].setSeconds("0");
        ceb[0].setBusinessDays(true);
        ceb[0].setId(0);

        ceb[1] = cp.marshall("* * * * * com.aweb.test.LetterTest 234");
        ceb[1].setYears("*");
        ceb[1].setSeconds("0");
        ceb[1].setBusinessDays(true);
        ceb[1].setId(1);
        CrontabEntryDAO.getInstance().store(ceb);
    }

    /**
     * ִ�б��ص�Ӧ�ó���Ĳ���
     * @param parameters
     */
    protected void executeAppliction(String[] parameters) {
        NativeExec.main(parameters);
    }

    /**
     * ��ִ�е��ļ�����Ϊemail
     * @param sendFilename
     * @throws Exception
     */
    protected void executeJavaMail(String sendFilename) throws Exception {
        File sendFile = new File(sendFilename);
        SendMail sm = new SendMail();
        sm.send(sendFile);
    }

    /**
     * ��Ҫͨ��main������ʵ��Jcrontab��ʵ��
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage:The values of args: <-type> []");
            System.out.println("********************************************************");
            System.out.println("Optional Parameters of type:");
            System.out.println("-filedata:doing file operating.");
            System.out.println("-database:doing database operating.");
            System.out.println("-appliction :doing native application execute.");
            System.out.println("-javamail :doing javamail operating.");
            System.out.println("********************************************************");
            System.exit(1);
        }
        JCrontabApp jp = new JCrontabApp();
        jp.exectue(args);
        System.out.println(jp.isHoliday());
    }
}
