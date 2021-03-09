package gscdz.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DB {
	Connection con;
	//数据库的连接对象
	Statement  stmt;
	//执行sql语句的对象
	ResultSet res;
	//返回值
	
	String url="jdbc:mysql://localhost:3306/gscdz?serverTimezone=UTC";
	/*3306端口后面对应的数据库的名称
	 * ?serverTimezone=UTC是因为版本不对称,理论上可去（个人原因）
	 */
	String driver="com.mysql.cj.jdbc.Driver";
	//驱动
	String user="root";
	String password="123456";
	//密码是最开始自己设的
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
	//抽象方法登录时input中输入的psw和数据库中存储的psw比较用

}
