package gscdz.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DB {
	Connection con;
	//���ݿ�����Ӷ���
	Statement  stmt;
	//ִ��sql���Ķ���
	ResultSet res;
	//����ֵ
	
	String url="jdbc:mysql://localhost:3306/gscdz?serverTimezone=UTC";
	/*3306�˿ں����Ӧ�����ݿ������
	 * ?serverTimezone=UTC����Ϊ�汾���Գ�,�����Ͽ�ȥ������ԭ��
	 */
	String driver="com.mysql.cj.jdbc.Driver";
	//����
	String user="root";
	String password="123456";
	//�������ʼ�Լ����
	public DB() {
		//
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			stmt=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public abstract String findpsw(String username);
	//���󷽷���¼ʱinput�������psw�����ݿ��д洢��psw�Ƚ���

}
