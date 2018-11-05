package com.LiangZhenJi.www.po;

public class Student {

	private String Id;//主键
	private String stuId;//ID
	private String stuName;//姓名
	private String stuSex;//性别
	private String stuEmail;//邮箱
	private String stuConNum;//紧急联系人
	private String stuSchool;//学校
	private String stuGrade;//年级
	private int stuClass;//班级
	
	public Student() {
		super();
	}

	public Student(String stuId, String stuName, String stuSex, String stuEmail, String stuConNum, String stuSchool,
			String stuGrade, int stuClass) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuEmail = stuEmail;
		this.stuConNum = stuConNum;
		this.stuSchool = stuSchool;
		this.stuGrade = stuGrade;
		this.stuClass = stuClass;
	}
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuConNum() {
		return stuConNum;
	}
	public void setStuConNum(String stuConNum) {
		this.stuConNum = stuConNum;
	}

	public String getStuSchool() {
		return stuSchool;
	}

	public void setStuSchool(String stuSchool) {
		this.stuSchool = stuSchool;
	}

	public String getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}

	public int getStuClass() {
		return stuClass;
	}

	public void setStuClass(int stuClass) {
		this.stuClass = stuClass;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	

	
	
}
