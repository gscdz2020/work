package gscdz.java;

import java.util.Date;

public class SolProblem {

	private int id;
	private String subject;
	private String solution;
	private String knowledgePoints;
	private String analysis;
	private Date solvedTime;
	private Date createTime;
	private String tips;
	private int creUserId;
	
	public SolProblem(int id, String subject, String solution, String knowledgePoints, String analysis, Date solvedTime,
			String tips,Date createTime,int creUserId) {
		super();
		this.id = id;
		this.subject = subject;
		this.solution = solution;
		this.knowledgePoints = knowledgePoints;
		this.analysis = analysis;
		this.solvedTime = solvedTime;
		this.tips = tips;
		this.createTime=createTime;
		this.creUserId=creUserId;
	}


	public SolProblem() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getSolution() {
		return solution;
	}


	public void setSolution(String solution) {
		this.solution = solution;
	}


	public String getKnowledgePoints() {
		return knowledgePoints;
	}


	public void setKnowledgePoints(String knowledgePoints) {
		this.knowledgePoints = knowledgePoints;
	}


	public String getAnalysis() {
		return analysis;
	}


	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}


	public Date getSolvedTime() {
		return solvedTime;
	}


	public void setSolvedTime(Date solvedTime) {
		this.solvedTime = solvedTime;
	}


	public String getTips() {
		return tips;
	}


	public void setTips(String tips) {
		this.tips = tips;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public int getCreUserId() {
		return creUserId;
	}


	public void setCreUserId(int creUserId) {
		this.creUserId = creUserId;
	}
	

   
}
