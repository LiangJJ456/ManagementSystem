package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.LiangZhenJi.www.util.DatabaseConnect;

/**
 * 对老师信息的修改
 * @author l
 *
 */

public class TeacherUpdate {
	/**
	 * 将老师的课程置为空
	 */
	public static int updateSubjest(String subject)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update teacher set 科目=null where 科目=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, subject);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 修改对应老师科目名字
	 * @param subject1
	 * @param subject2
	 * @return
	 */
	public static int updateSubjestToNew(String subject1,String subject2)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update teacher set 科目=? where 科目=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, subject2);
			prestmt.setString(2, subject1);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	
	/**
	 * 将老师对应的班级置为空
	 */
	public static int updateClass(int class1,String grade,String school)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update teacher set 班级=0 where 学校=? and 年级=? and 班级=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, school);
			prestmt.setString(2, grade);
			prestmt.setInt(3, class1);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	
	/**
	 * 将老师对应的年级置为空
	 */
	public static int updateGrade(String grade,String school)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update teacher set 年级=null,班级=0 where 学校=? and 年级=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, school);
			prestmt.setString(2, grade);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	
	/**
	 * 将老师对应的学校置为空
	 */
	public static int updateSchool(String school)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update teacher set 学校=null,年级=null,班级=0 where 学校=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, school);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

}
