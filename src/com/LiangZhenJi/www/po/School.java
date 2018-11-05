package com.LiangZhenJi.www.po;

public class School {
	private int schId;//id
	private String schName;//学校
	public School(int schId, String schName) {
		super();
		this.schId = schId;
		this.schName = schName;
	}
	public int getSchId() {
		return schId;
	}
	public void setSchId(int schId) {
		this.schId = schId;
	}
	public String getSchName() {
		return schName;
	}
	public void setSchName(String schName) {
		this.schName = schName;
	}
	

}
