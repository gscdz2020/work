package gscdz.java;


import java.sql.SQLException;

public class UserDB extends DB{

	@Override
	public String findpsw(String username) {
		//在user表中根据username找到password
		String sql="select * from user where username='"+username+"'";
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
	public User getUserInfor(String username) {
		//在user表中根据username找到对应的user对象的信息，包装成一个对象user并返回
		String sql="select * from user where username='"+username+"'";
		User user=null;
		try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				user=new User(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public User getUserByid(int id) {
		//在user表中根据id找到对应的user对象的信息，包装成一个对象user并返回
		String sql="select * from user where id="+id;
		User user=null;
		try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				user=new User(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public void updateCP(String username,int problemId) {
		//更新User中的concerningproblem
		User user=getUserInfor(username);
		String cps=user.getConcerningProblems();
		if(cps==null) {
			//为空时
			cps=Integer.toString(problemId);
		}else {
			//不为空时
			cps+="||";
			cps+=problemId;
		}
		
		String sql="update user set concerningproblems='"+cps+"'where id="+user.getId();
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

