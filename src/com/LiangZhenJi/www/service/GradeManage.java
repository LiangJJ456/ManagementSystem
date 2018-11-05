package com.LiangZhenJi.www.service;

import java.util.Iterator;

import com.LiangZhenJi.www.dao.GradeCrud;
import com.LiangZhenJi.www.po.Grade;


public class GradeManage {
	/**
	 * 返回模糊查找年级信息
	 * @param graName
	 * @return
	 */
	public static Object[][] likeGrade(String graName){
		Object[][] obj=new Object[10][7];
		Iterator<Grade> it=GradeCrud.likefind(graName).iterator();
		int j=0;
		while(it.hasNext()) {
			    Grade grade=it.next();
				obj[j][0]=grade.getGraId();
				obj[j][1]=grade.getGraSchool();
				obj[j][2]=grade.getGraName();
				obj[j][3]=grade.getGraorName();
				obj[j][4]=grade.getGraclass();
				obj[j][5]=grade.getTelphone();
				obj[j][6]=grade.getGraEmail();
				j++;
			}
		return obj;
	}
	
	/**
	 * 返回某学校所有年级的信息
	 * @param school
	 * @return
	 */
	public static Object[][] schoolAllGrade(String school){
		Object[][] obj=new Object[10][7];
		Iterator<Grade> it=GradeCrud.schoolAllGrade(school).iterator();
		int j=0;
		while(it.hasNext()) {
			    Grade grade=it.next();
				obj[j][0]=grade.getGraId();
				obj[j][1]=grade.getGraSchool();
				obj[j][2]=grade.getGraName();
				obj[j][3]=grade.getGraorName();
				obj[j][4]=grade.getGraclass();
				obj[j][5]=grade.getTelphone();
				obj[j][6]=grade.getGraEmail();
				j++;
			}
		return obj;
	}
	
	/**
	 * 返回具体查找年级信息
	 * @param graName
	 * @param school
	 * @return
	 */
	public static Object[] selfGrade(String graName,String school){
		Object[] obj=new Object[7];
		obj[0]=GradeCrud.find(graName,school).getGraId();
		obj[1]=GradeCrud.find(graName,school).getGraSchool();
		obj[2]=GradeCrud.find(graName,school).getGraName();
		obj[3]=GradeCrud.find(graName,school).getGraorName();
		obj[4]=GradeCrud.find(graName,school).getGraclass();
		obj[5]=GradeCrud.find(graName,school).getTelphone();
		obj[6]=GradeCrud.find(graName,school).getGraEmail();
		return obj;
	}
	
	/**
	 * 返回所有年级信息
	 * @return
	 */
	public static Object[][] graAll(){
		Object[][] obj=new Object[10][7];
		Iterator<Grade> it=GradeCrud.findAll().iterator();
		int j=0;
		while(it.hasNext()) {
			Grade grade=it.next();
			obj[j][0]=grade.getGraId();
			obj[j][1]=grade.getGraSchool();
			obj[j][2]=grade.getGraName();
			obj[j][3]=grade.getGraorName();
			obj[j][4]=grade.getGraclass();
			obj[j][5]=grade.getTelphone();
			obj[j][6]=grade.getGraEmail();
			j++;
			}
		return obj;
	}
	
}
