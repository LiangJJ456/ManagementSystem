package com.LiangZhenJi.www.po;

public class Grade {
	private int graId;//id
	private String graSchool;//学校
	private String graorName;//级长姓名
	private String graName;//年级
	private int graclass;//班级
	private String telphone;//电话
	private String graEmail;//邮箱
	
	
	public Grade() {
		super();
	}

	public Grade(int graId, String graSchool, String graorName, String graName, int graclass, String telphone,
			String graEmail) {
		super();
		this.graId = graId;
		this.graSchool = graSchool;
		this.graorName = graorName;
		this.graName = graName;
		this.graclass = graclass;
		this.telphone = telphone;
		this.graEmail = graEmail;
	}
	
	public int getGraId() {
		return graId;
	}
	public void setGraId(int graId) {
		this.graId = graId;
	}
	public String getGraorName() {
		return graorName;
	}
	public void setGraorName(String graorName) {
		this.graorName = graorName;
	}
	public String getGraName() {
		return graName;
	}
	public void setGrade(String graName) {
		this.graName = graName;
	}
	public int getGraclass() {
		return graclass;
	}
	public void setGraclass(int graclass) {
		this.graclass = graclass;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getGraEmail() {
		return graEmail;
	}
	public void setGraEmail(String graEmail) {
		this.graEmail = graEmail;
	}
	public String getGraSchool() {
		return graSchool;
	}
	public void setGraSchool(String graSchool) {
		this.graSchool = graSchool;
	}
	

}
