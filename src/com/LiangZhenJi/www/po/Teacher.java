package com.LiangZhenJi.www.po;

public class Teacher {
	private String Id;//主键
	private String teaId;//老师的工号
	private String teaName;//姓名
	private String teaGrade;//年级
	private String teaClass;//班级
	private String teaTelnumber;//电话
	private String teaEmail;//邮箱
	private String teaSubject;//科目
	
	
	public Teacher() {
		super();
	}
	public Teacher(String teaId, String teaName, String teaGrade,String teaClass, String teaTelnumber, String teaEmail, String teaSubject) {
		super();
		this.teaId = teaId;
		this.teaName = teaName;
		this.teaGrade = teaGrade;
		this.teaClass = teaClass;
		this.teaTelnumber = teaTelnumber;
		this.teaEmail = teaEmail;
		this.setTeaSubject(teaSubject);
	}
	public String getTeaId() {
		return teaId;
	}
	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaClass() {
		return teaClass;
	}
	public void setTeaClass(String teaClass) {
		this.teaClass = teaClass;
	}
	public String getTeaTelnumber() {
		return teaTelnumber;
	}
	public void setTeaTelnumber(String teaTelnumber) {
		this.teaTelnumber = teaTelnumber;
	}
	public String getTeaEmail() {
		return teaEmail;
	}
	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}
	public String getTeaSubject() {
		return teaSubject;
	}
	public void setTeaSubject(String teaSubject) {
		this.teaSubject = teaSubject;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTeaGrade() {
		return teaGrade;
	}
	public void setTeaGrade(String teaGrade) {
		this.teaGrade = teaGrade;
	}
	
	

}
