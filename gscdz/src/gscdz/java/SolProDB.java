package gscdz.java;

import java.sql.SQLException;
import java.util.ArrayList;

public class SolProDB extends DB{

	@Override
	public String findpsw(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SolProblem> list(){
		//��ȡsolved_problem�е�����solProblem
		String sql="select * from solved_problem";
		ArrayList<SolProblem> usproblems=new ArrayList<SolProblem>();
		SolProblem problem =new SolProblem();
		try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				problem.setId(res.getInt("id"));
				problem.setSubject(res.getString("subject"));
				problem.setSolution(res.getString("solution"));
				problem.setKnowledgePoints(res.getString("knowledgePoints"));
				problem.setAnalysis(res.getString("analysis"));
				problem.setSolvedTime(res.getDate("solvedTime"));
				problem.setTips(res.getString("tips"));
				problem.setCreateTime(res.getDate("createTime"));
				problem.setCreUserId(res.getInt("creUserId"));
				usproblems.add(problem);
				problem=new SolProblem();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return usproblems;
	}
	public SolProblem findById(int id) {
		//����id��һ��solProblem
		SolProblem problem =null;
		String sql="select* from solved_problem where id ="+id;
		try {
			res=stmt.executeQuery(sql);
			while(res.next()) {
				problem =new SolProblem(id,res.getString("subject"),res.getString("solution"),res.getString("knowledgePoints"),
						res.getString("analysis"),res.getDate("solvedTime"),res.getString("tips"),res.getDate("createTime"),res.getInt("creUserId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problem;	
	}
	public void addSolProblem(SolProblem solvedProblem) {
		//���һ��SolProblem 
		String sql="insert into solved_problem (subject,solution,knowledgePoints,analysis,solvedTime,tips,createTime,creUserId) values"
				+ "('"+solvedProblem.getSubject()+"','"+solvedProblem.getSolution()+"','"+solvedProblem.getKnowledgePoints()+"','"+solvedProblem.getAnalysis()+"','"+solvedProblem.getSolvedTime()+"','"+solvedProblem.getTips()+"','"+solvedProblem.getCreateTime()+"','"+solvedProblem.getCreUserId()+"')";
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void removeSolPro(int id) {
    	//����idɾ��һ����
    	String sql="delete from solved_problem where id="+id;
    	try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
