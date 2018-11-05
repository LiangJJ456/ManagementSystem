package com.LiangZhenJi.www.po;

public class User {
	private int userId;//id
	private String userName;//用户名
	private String userPassword;//密码
	private String userKind;//用户类别
	
	public User(int userId, String userName, String userPassword, String userKind) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.setUserKind(userKind);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserKind() {
		return userKind;
	}
	public void setUserKind(String userKind) {
		this.userKind = userKind;
	}
	

}
