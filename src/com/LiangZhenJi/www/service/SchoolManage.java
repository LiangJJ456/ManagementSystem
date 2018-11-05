package com.LiangZhenJi.www.service;

import java.util.Iterator;

import com.LiangZhenJi.www.dao.SchoolCrud;
import com.LiangZhenJi.www.po.School;

public class SchoolManage {
	/**
	 * 返回学校所有学生
	 * @param schName
	 * @return
	 */
	public static Object[] schStudent(String schName){
		Object[] obj=new Object[100];
		Iterator<Object[]> it=SchoolCrud.find(schName).iterator();
		int j=0;
		while(it.hasNext()) {
				obj[j]=it.next();
				j++;
			}
		return obj;
	}
	
	/**
	 * 返回模糊查找学校
	 * @param schName
	 * @return
	 */
	public static Object[][] likeSchool(String schName){
		Object[][] obj=new Object[10][2];
		Iterator<School> it=SchoolCrud.likeFind(schName).iterator();
		int j=0;
		while(it.hasNext()) {
				School school=it.next();
				obj[j][0]=school.getSchId();
				obj[j][1]=school.getSchName();
				j++;
			}
		return obj;
	}
	
	/**
	 * 返回所有学校
	 * @return
	 */
	public static Object[][] allSchool(){
		Object[][] obj=new Object[10][2];
		Iterator<School> it=SchoolCrud.findAll().iterator();
		int j=0;
		while(it.hasNext()) {
				School school=it.next();
				obj[j][0]=school.getSchId();
				obj[j][1]=school.getSchName();
				j++;
			}
		return obj;
	}
}
