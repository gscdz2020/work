package gscdz.java;

import java.sql.SQLException;

public class AdminDB extends DB{

	@Override
	public String findpsw(String username) {
		//在admin表中根据username找到password
        String sql="select * from admin where username='"+username+"'";
        String psw=null;
        try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				psw=res.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psw;
	}

}
