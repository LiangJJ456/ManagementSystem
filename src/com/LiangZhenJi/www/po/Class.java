package com.LiangZhenJi.www.po;

public class Class {
	
	private int claId;//Id
	private String claSchool;//学校
	private String clagade;//年级
	private int claName;//班级
	private String headteaName;//班主任姓名
	private String headteaNumber;//班主任电话
	private String claEmail;//邮箱
	
	
	public Class() {
		super();
	}

	public Class(int claId, String claSchool, String clagade, int claName, String headteaName, String headteaNumber,
			String claEmail) {
		super();
		this.claId = claId;
		this.claSchool = claSchool;
		this.clagade = clagade;
		this.claName = claName;
		this.headteaName = headteaName;
		this.headteaNumber = headteaNumber;
		this.claEmail = claEmail;
	}
	
	public int getClaId() {
		return claId;
	}
	public void setClaId(int claId) {
		this.claId = claId;
	}
	public int getClaName() {
		return claName;
	}
	public void setClaName(int claName) {
		this.claName = claName;
	}
	public String getHeadteaName() {
		return headteaName;
	}
	public void setHeadteaName(String headteaName) {
		this.headteaName = headteaName;
	}
	public String getHeadteaNumber() {
		return headteaNumber;
	}
	public void setHeadteaNumber(String headteaNumber) {
		this.headteaNumber = headteaNumber;
	}
	public String getClaEmail() {
		return claEmail;
	}
	public void setClaEmail(String claEmail) {
		this.claEmail = claEmail;
	}
	public String getClaSchool() {
		return claSchool;
	}
	public void setClaSchool(String claSchool) {
		this.claSchool = claSchool;
	}
	public String getClagade() {
		return clagade;
	}
	public void setClagade(String clagade) {
		this.clagade = clagade;
	}
	
	

}
