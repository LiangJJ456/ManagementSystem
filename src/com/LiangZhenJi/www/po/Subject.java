package com.LiangZhenJi.www.po;

public class Subject {
	private int subId;//Id
	private String subName;//科目
	public Subject(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	

}
