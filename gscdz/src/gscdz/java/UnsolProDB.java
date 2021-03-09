package gscdz.java;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UnsolProDB extends DB{

	@Override
	public String findpsw(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Problem> list(){
		//读取unsolved_problem中的所有Problem
		String sql="select * from unsolved_problem";
		ArrayList<Problem> usproblems=new ArrayList<Problem>();
		Problem problem =new Problem();
		try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				problem.setId(res.getInt("id"));
				problem.setSubject(res.getString("subject"));
				problem.setSolution(res.getString("solution"));
				problem.setKnowledgePoints(res.getString("knowledgePoints"));
				problem.setAnalysis(res.getString("analysis"));
				problem.setState(res.getInt("state"));
				problem.setCreateTime(res.getDate("createTime"));
				problem.setCreUserId(res.getInt("creUserId"));
				problem.setAnswUserId(res.getString("answUserId"));
				usproblems.add(problem);
				problem=new Problem();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return usproblems;
	}
	public Problem findById(int id) {
		//根据id找一题
		Problem problem =null;
		String sql="select* from unsolved_problem where id ="+id;
		try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				problem =new Problem(id,res.getString("subject"),res.getString("solution"),res.getString("knowledgePoints"),res.getString("analysis"),res.getInt("state"),res.getDate("createTime"),res.getInt("creUserId"),res.getString("answUserId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problem;	
	}
	public void addPro(Problem problem) {
		//创建并添加一道problem
		//subject,knowledgePoints,state,createTime,creUserId
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String sql="insert into unsolved_problem (subject,knowledgePoints,createTime,creUserId) values"
				+ "('"+problem.getSubject()+"','"+problem.getKnowledgePoints()+"','"+formatter.format(problem.getCreateTime())+"','"+problem.getCreUserId()+"')";
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void removePro(int id) {
		//根据id删除一道题
		String sql="delete from unsolved_problem where id="+id;
    	try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateSoluAndAnal(int id,String solution,String analysis,String answUserId) {
		//添加solution和analysis
		String sql="update unsolved_problem set solution='"+solution+"',analysis='"+analysis+"',answUserId='"+answUserId+"'where id="+id;
    	try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
