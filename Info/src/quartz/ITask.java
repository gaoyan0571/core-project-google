package quartz;

/**
 *  ҵ��ϵͳ��Ҫʵ�ֵĽӿڷ����� 
 * @author harison
 *
 */

import java.util.HashMap;

/**
 *  ҵ��ϵͳ��Ҫʵ�ֵĽӿڷ�����
 * @author harison
 *
 */
public interface ITask{
  /**
   * ��������һ��execute�ӿڸ�ҵ��ϵͳʹ�ã�ҵ��ϵͳд�����ʱ��ֻ��Ҫ�̳�Task��Ϳ����ˡ�
   * 
   * @param map �����map���ܿ�ǿ�����ޣ���Ϊ�ܶ�����ִ�п�����Ҫ��������������������������JOB_TASK���PARMS�ֶ�����
   * �������� 
   * <item>
   * <key>sss</key>
   * <value>vvv</value>
   * </item>
   * <item>
   * <key>ss</key>
   * <value>vv</value>
   * </item>
   * �����ڳ��������У�����ҵ��ϵͳjob��ʱ�򣬻������ļ�¼��MAP����ʽ���ݹ�ȥ��
   * �����PARMS�ֶ����棬��ô��ҵ��ϵͳʵ�����������ʱ�򣬿���ͨ��
   * map.get("ss") ��� vv ֵ
   */
  public void execute( HashMap map );
}
