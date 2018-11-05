package com.LiangZhenJi.www.service;

import java.util.Iterator;

import com.LiangZhenJi.www.dao.ClassCrud;
import com.LiangZhenJi.www.po.Class;

public class ClassManage {
	
	/**
	 * 查询所有的班级
	 * @return
	 */
	public static Object[][] allClass(){
		Object[][] obj=new Object[10][5];
		Iterator<Class> it=ClassCrud.findAll().iterator();
		int j=0;
		while(it.hasNext()) {
				Class class1=it.next();
				obj[j][0]=class1.getClaId();
				obj[j][1]=class1.getClaName();
				obj[j][2]=class1.getHeadteaName();
				obj[j][3]=class1.getHeadteaNumber();
				obj[j][4]=class1.getClaEmail();
				j++;
			}
		return obj;
	}
	
	/**
	 * 查询班级的学生
	 * @param claName
	 * @param grade
	 * @param school
	 * @return
	 */
	public static Object[][] classStudent(int claName,String grade,String school){
		Object[][] obj=new Object[50][1];
		Iterator<Object[]> it=ClassCrud.claFindStu(claName,grade,school).iterator();
		int j=0;
		while(it.hasNext()) {
				obj[j][0]=it.next()[j];
				j++;
			}
		return obj;
	}
	
	/**
	 * 具体查询某个班级信息
	 * @param claName
	 * @param grade
	 * @param school
	 * @return
	 */
	public static Object[] classQuery(int claName,String grade,String school){
		Object[] obj=new Object[5];
		if(ClassCrud.find(claName,grade,school)!=null) {
			obj[0]=ClassCrud.find(claName,grade,school).getClaId();
			obj[1]=ClassCrud.find(claName,grade,school).getClaName();
			obj[2]=ClassCrud.find(claName,grade,school).getHeadteaName();
			obj[3]=ClassCrud.find(claName,grade,school).getHeadteaNumber();
			obj[4]=ClassCrud.find(claName,grade,school).getClaEmail();
		}
		return obj;
	}
	
	/**
	 * 返回模糊查询的班级
	 * @param claName
	 * @return
	 */
	public static Object[][] likefind(int claName){
		Object[][] obj=new Object[10][5];
		Iterator<Class> it=ClassCrud.likefind(claName).iterator();
		int j=0;
		while(it.hasNext()) {
				Class class1=it.next();
				for(int i=0;i<5;i++) {
					obj[j][0]=class1.getClaId();
					obj[j][1]=class1.getClaName();
					obj[j][2]=class1.getHeadteaName();
					obj[j][3]=class1.getHeadteaNumber();
					obj[j][4]=class1.getClaEmail();
				}
				j++;
			}
		return obj;
	}
	/**
	 * 返回某学校某年级的所有班级
	 * @param grade
	 * @param school
	 * @return
	 */
	public static Object[][] gradeAllClass(String grade,String school){
		Object[][] obj=new Object[10][5];
		Iterator<Class> it=ClassCrud.gradeAllClass(grade,school).iterator();
		int j=0;
		while(it.hasNext()) {
			Class class1=it.next();
				for(int i=0;i<5;i++) {
					obj[j][0]=class1.getClaId();
					obj[j][1]=class1.getClaName();
					obj[j][2]=class1.getHeadteaName();
					obj[j][3]=class1.getHeadteaNumber();
					obj[j][4]=class1.getClaEmail();
				}
				j++;
			}
		return obj;
	}

}
