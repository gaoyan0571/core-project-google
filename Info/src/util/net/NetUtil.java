package util.net;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class NetUtil {

	
	public static void testGet()
	{
		
		HttpClient httpClient = new HttpClient();
		// ����GET������ʵ��
		GetMethod getMethod = new GetMethod("http://www.ibm.com");
		// ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			// ִ��getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			}
			// ��ȡ����
			byte[] responseBody = getMethod.getResponseBody();
			// ��������
			System.out.println(new String(responseBody));
		} catch (HttpException e) {
			// �����������쳣��������Э�鲻�Ի��߷��ص�����������
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			// ���������쳣
			e.printStackTrace();
		} finally {
			// �ͷ�����
			getMethod.releaseConnection();
		}

	}
	
	public static void testPost() throws HttpException, IOException {
		// TODO Auto-generated method stub
		HttpClient httpClient = new HttpClient();
		
		
		String url = "http://purgesys.tytech.tianya.cn/push/executive/";
		PostMethod postMethod = new PostMethod(url);
		// ������������ֵ
		NameValuePair[] data = { new NameValuePair("PushURLid", "http://static.tianya.cn/global/game/drqp/css/")};
		// ������ֵ����postMethod��
		postMethod.setRequestBody(data);
		// ִ��postMethod
		int statusCode = httpClient.executeMethod(postMethod);
		// HttpClient����Ҫ����ܺ�̷����������POST��PUT�Ȳ����Զ�����ת��
		// 301����302
		System.out.println(statusCode);
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || 
		statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
		    // ��ͷ��ȡ��ת��ĵ�ַ
		    Header locationHeader = postMethod.getResponseHeader("location");
		    String location = null;
		    if (locationHeader != null) {
		     location = locationHeader.getValue();
		     System.out.println("The page was redirected to:" + location);
		    } else {
		     System.err.println("Location field value is null.");
		    }
		    return;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		
		NetUtil.testPost();
	}
	

}
