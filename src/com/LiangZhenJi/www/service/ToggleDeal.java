package com.LiangZhenJi.www.service;

import com.LiangZhenJi.www.dao.ClassCrud;
import com.LiangZhenJi.www.dao.GradeCrud;
import com.LiangZhenJi.www.dao.ScoreCrud;
import com.LiangZhenJi.www.dao.StudentCrud;
import com.LiangZhenJi.www.dao.TeacherUpdate;
import com.LiangZhenJi.www.dao.UserDao;
import com.LiangZhenJi.www.view.ClassManageView;
import com.LiangZhenJi.www.view.GradeManageView;
import com.LiangZhenJi.www.view.ScoreManageView;
import com.LiangZhenJi.www.view.StudentManageView;

/**
 * 这个类是用来处理触发器事件的
 * @author l
 *
 */
public class ToggleDeal {
	/**
	 * 对增加学生的处理
	 */
	public static void studentAddDeal() {
		
	}
	/**
	 * 对删除学生的处理
	 * @param stuId学生的学号
	 */
	public static void studentDeleteDeal(String stuId) {
		//删除学生的成绩
		ScoreCrud.deleteAll(stuId);
		//删除该学生的用户信息
		UserDao.delete(stuId);
		
	}
	/**
	 * 对修改学生的处理
	 * @param stuId1原来的学号
	 * stuId2修改的学号
	 */
	public static void studentUpdateDeal(String stuId1,String stuId2) {
		//修改用户名
		UserDao.updateUserName(stuId1, stuId2);
		
	}
	/**
	 * 对增加科目的处理
	 * @param subject
	 */
	public static void addSubjectDeal(String subject) {
		//添加任课老师
		
		//弹出成绩管理窗口（添加成绩）
		 ScoreManageView smv=new ScoreManageView();
		 smv.setVisible(true);
	}
	/**
	 * 对删除科目的处理
	 * @param subject
	 */
	public static void deleteSubjectDeal(String subject) {
		//删除科目成绩
		ScoreCrud.deleteSubject(subject);
		//将任课老师的科目置为空
		TeacherUpdate.updateSubjest(subject);
		
	}
	/**
	 * 对修改科目的处理
	 * @param subject1原来科目名字
	 * @param subject2后来科目名字
	 */
	public static void updateSubjectDeal(String subject1,String subject2) {
		//修改分数表的科目名字
		ScoreCrud.updateSubject(subject1,subject2);
		//修改任课老师的科目名字
		TeacherUpdate.updateSubjestToNew(subject1, subject2);
	}
	/**
	 * 对增加班级的处理
	 */
	public static void addClassDeal() {
		//弹出学生管理窗口（添加学生）
		 StudentManageView smv=new StudentManageView();
		 smv.setVisible(true);
	}
	/**
	 * 对删除班级的处理
	 * @param cla班级
	 */
	public static void deleteClassDeal(int cla,String grade,String school) {
		//删除班级对应学生,先删除学生的成绩，再删除学生（为了消除该班学生的记录）
		for(int i=0;;i++) {
			if(ClassManage.classStudent(cla, grade, school)[i][1]!=null){
				studentDeleteDeal((String)StudentQuery.stuQuery((String)ClassManage.classStudent(cla, grade, school)[i][1])[0]);
			}
			else
				break;
			
		}
		//删除学生
		StudentCrud.deleteClass(cla,grade,school);
		//将对应老师的班级置为空
		TeacherUpdate.updateClass(cla, grade, school);
		
	}
	/**
	 * 对增加年级的处理
	 */
	public static void addGradeDeal() {
		//添加班级窗口弹出
		 ClassManageView cmv=new ClassManageView();
		 cmv.setVisible(true);
	}
	/**
	 * 对删除年级的处理
	 * @param grade
	 * @param school
	 */
	public static void deleteGrade(String grade,String school) {
		//删除年级对应班级,先删除对应学生的成绩，再删除学生,再删除班级
		
		//删除对应学生成绩
		for(int j=0;;j++) {
			if(ClassManage.gradeAllClass(grade, school)[j][1]!=null) {
				int cla=(int)ClassManage.gradeAllClass(grade,school)[j][1];
				for(int i=0;;i++) {
					if(ClassManage.classStudent(cla, grade, school)[i][1]!=null){
						studentDeleteDeal((String)StudentQuery.stuQuery((String)ClassManage.classStudent(cla, grade, school)[i][1])[0]);
					}
					else
						break;
					
				}
			}
			else
				break;
		}
		
		//删除该年级学生
		StudentCrud.deleteSchGre(grade,school);
		
		//删除该年级的班级
		for(int i=0;;i++) {
			if(ClassManage.gradeAllClass(grade, school)[i][1]!=null) {
				ClassCrud.delete((int)ClassManage.gradeAllClass(grade, school)[i][1], grade, school);
			}
			else 
				break;
		}
		//将对应老师的年级置为空
		TeacherUpdate.updateGrade(grade,school);
	}
	/**
	 * 添加学校的处理
	 */
	public static void addSchoolDeal() {
		//增加年级窗口弹出
		GradeManageView gmv=new GradeManageView();
		 gmv.setVisible(true);
		
	}
	
	public static void deleteSchoolDeal(String school) {
		//删除学校对应年级,先删除对应学生的成绩，再删除学生,再删除班级，再删除年级
		//删除对应学生的成绩
		for(int k=0;;k++) {
			if(GradeManage.schoolAllGrade(school)[k][2]!=null) {
				String grade=(String)GradeManage.schoolAllGrade(school)[k][2];
				for(int j=0;;j++) {
					if(ClassManage.gradeAllClass(grade, school)[j][1]!=null) {
						int cla=(int)ClassManage.gradeAllClass(grade,school)[j][1];
						for(int i=0;;i++) {
							if(ClassManage.classStudent(cla, grade, school)[i][1]!=null){
								studentDeleteDeal((String)StudentQuery.stuQuery((String)ClassManage.classStudent(cla, grade, school)[i][1])[0]);
							}
							else
								break;
							
						}
					}
					else
						break;
				}
				
			}
			else
				break;
		}
		//删除该学校的学生
		StudentCrud.deleteSchool(school);
		//删除班级
		for(int k=0;;k++) {
			if(GradeManage.schoolAllGrade(school)[k][2]!=null) {
				String grade=(String)GradeManage.schoolAllGrade(school)[k][2];
				for(int j=0;;j++) {
					if(ClassManage.gradeAllClass(grade, school)[j][1]!=null) {
						int cla=(int)ClassManage.gradeAllClass(grade,school)[j][1];
						ClassCrud.delete(cla, grade, school);
					}
					else
						break;
				}
				
			}
			else
				break;
		}
		//删除年级
		for(int k=0;;k++) {
			if(GradeManage.schoolAllGrade(school)[k][2]!=null) {
				String grade=(String)GradeManage.schoolAllGrade(school)[k][2];
				GradeCrud.delete(grade, school);	
			}
			else
				break;
		}
		//将对应老师的学校置为空
		TeacherUpdate.updateSchool(school);
		
		}
}
