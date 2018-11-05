package com.LiangZhenJi.www.po;

public class Score {
	private int number;//主键
	private String scoreId;//学号
	private float score;//分数
	private String scoSubject;//科目
	public Score(int number, String scoreId, float score, String scoSubject) {
		super();
		this.number = number;
		this.scoreId = scoreId;
		this.score = score;
		this.scoSubject = scoSubject;
	}
	
	public Score() {
		super();
	}

	public String getScoreId() {
		return scoreId;
	}
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getScoSubject() {
		return scoSubject;
	}
	public void setScoSubject(String scoSubject) {
		this.scoSubject = scoSubject;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	

}
