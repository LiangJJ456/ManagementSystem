package com.LiangZhenJi.www.service;

import java.util.Iterator;
import java.util.List;

import com.LiangZhenJi.www.dao.ScoreCrud;
import com.LiangZhenJi.www.dao.StudentCrud;
import com.LiangZhenJi.www.dao.SubjectCrud;
import com.LiangZhenJi.www.po.Student;

public class StudentQuery {
	/**
	 * 获取数据库的学生个人信息
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public static Object[] stuQuery(String msg){
		Object[] obj=new Object[8];
		Student student=StudentCrud.find(msg);
			obj[0]=student.getStuId();
			obj[1]=student.getStuName();
			obj[2]=student.getStuSex();
			obj[3]=student.getStuEmail();
			obj[4]=student.getStuConNum();
			obj[5]=student.getStuSchool();
			obj[6]=student.getStuGrade();
			obj[7]=student.getStuClass();
		return obj;
		
	}
	/**
	 * 获取数据库模糊查找的学生信息
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public static Object[][] likeStuQuery(String msg) {
		Object[][] obj=new Object[150][8];
		List<Student> list=StudentCrud.likeFind(msg);
		if(list!=null) {
			for(int j=0;j<list.size();j++) {
				obj[j][0]=list.get(j).getStuId();
				obj[j][1]=list.get(j).getStuName();
				obj[j][2]=list.get(j).getStuSex();
				obj[j][3]=list.get(j).getStuEmail();
				obj[j][4]=list.get(j).getStuConNum();
				obj[j][5]=list.get(j).getStuSchool();
				obj[j][6]=list.get(j).getStuGrade();
				obj[j][7]=list.get(j).getStuClass();
			}
		}
		return obj;
		
		
	}
	
	/**
	 * 查询所有学生的成绩
	 * @return
	 */
	public static Object[][] allScoQuery(){
		Object[][] obj=new Object[150][4];
		Iterator<Object[]> it=ScoreCrud.findAll().iterator();
		int j=0;
		while(it.hasNext()) {
			Object[] object=it.next();
			for(int i=0;i<4;i++) {
				obj[j][i]=object[i];
			}
			j++;
		}
	return obj;
	}
	/**
	 * 获取学生各科目的成绩
	 * @param msg
	 * @return
	 */
	public static Object[][] scoreQuery(String msg){
		Object[][] obj=new Object[15][4];
		Iterator<Object[]> it=ScoreCrud.findself(msg).iterator();
		int j=0;
		while(it.hasNext()) {
			Object[] object=it.next();
			for(int i=0;i<4;i++) {
				obj[j][i]=object[i];
			}
			j++;
		}
		return obj;
	}
	
	/**
	 * 获取某科目各学生的成绩
	 * @param subject
	 * @return
	 */
	public static Object[][] subScoQuery(String subject) {
		Object[][] obj=new Object[150][3];
		Iterator<Object[]> it=ScoreCrud.subFind(subject).iterator();
		int j=0;
		while(it.hasNext()) {
			Object[] object=it.next();
			for(int i=0;i<3;i++) {
				obj[j][i]=object[i];
			}
			j++;
		}
		return obj;
	}
	/**
	 * 获取某学生某科目的成绩
	 * @return
	 */
	public static Object[] selfScoQuery(String msg,String subject) {
		Object[] obj=new Object[4];
		Iterator<Object[]> it=ScoreCrud.find(msg,subject).iterator();
		while(it.hasNext()) {
			Object[] object=it.next();
			for(int i=0;i<4;i++) {
				obj[i]=object[i];
			}	
		}
		return obj;
	}
	/**
	 * 获取课程
	 */
	public static Object[] selfSubject() {
		Object[] obj=new Object[15];
		Iterator<com.LiangZhenJi.www.po.Subject> it=SubjectCrud.findAll().iterator();
		while(it.hasNext()) {
			    int i=0;
				obj[i]=it.next().getSubName();
				i++;
		}
		return obj;	
	}
}


