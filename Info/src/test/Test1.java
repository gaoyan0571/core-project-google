package test;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Test1 {

	
	public void test1()
	{
		
	}
	// ����MySQL�����ݿ���������
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	// ����MySQL���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/test" ;
	// MySQL���ݿ�������û���
	public static final String DBUSER = "root" ;
	// MySQL���ݿ����������
	public static final String DBPASS = "123456789" ;
	public static void main(String args[]) throws Exception{	// �����쳣�׳�
		Connection conn = null ;		// ���ݿ�����
		PreparedStatement pstmt = null ;	// ���ݿ����
		String keyWord = "��" ;	 // ���ò�ѯ�ؼ���
		ResultSet rs = null ;	// ���ղ�ѯ���
		String sql = "select count(*) from admin_log";
		Class.forName(DBDRIVER) ;	// ������������
		conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
		pstmt = conn.prepareStatement(sql) ;	// ʵ����PreapredStatement����
		rs = pstmt.executeQuery() ;	// ִ�в�ѯ
		while(rs.next()){
			
			
			System.out.println(rs.getRow());
			System.out.println(rs.getInt(1));
		}
		
		while(rs.next()){
			
			
			System.out.println(rs.getRow());
			System.out.println(rs.getInt(1));
		}
		rs.close() ;
		pstmt.close() ;
		conn.close() ;			// ���ݿ�ر�
	}
}
