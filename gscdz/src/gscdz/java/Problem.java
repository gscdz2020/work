package gscdz.java;

import java.util.Date;

public class Problem {

	private int id;
	private String subject;
	private String solution;
	private String knowledgePoints;
	private String analysis;
	private int state;
	private int creUserId;
	private Date createTime;
	private String answUserId;
	public Problem(int id, String subject, String solution, String knowledgePoints, String analysis, int state,Date createTime,int creUserId,String answUserId) {
		super();
		this.id = id;
		this.subject = subject;
		this.solution = solution;
		this.knowledgePoints = knowledgePoints;
		this.analysis = analysis;
		this.state = state;
		this.createTime=createTime;
		this.creUserId=creUserId;
		this.answUserId=answUserId;
	}
	public Problem(int id, String subject, String solution, String knowledgePoints, String analysis) {
		super();
		this.id = id;
		this.subject = subject;
		this.solution = solution;
		this.knowledgePoints = knowledgePoints;
		this.analysis = analysis;
	}
	
	public Problem() {
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public String getAnswUserId() {
		return answUserId;
	}
	public void setAnswUserId(String answUserId) {
		this.answUserId = answUserId;
	}
	
	
}
