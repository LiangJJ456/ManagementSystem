package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LiangZhenJi.www.po.School;
import com.LiangZhenJi.www.util.DatabaseConnect;
/**
 * 对学校进行进行增删改查操作
 * @author l
 *
 */
public class SchoolCrud {
	/**
	 * 查看学校的所有学生
	 * @param schName
	 * @return
	 * @throws Exception
	 */
	public static List<Object[]> find(String schName) {
		List<Object[]> studentList = new ArrayList<Object[]>();
		Object[] obj=new Object[100];
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT student.姓名  FROM student WHERE student.学校=(SELECT school.学校 FROM school WHERE school.学校=?)";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, schName);
			rs = prestmt.executeQuery();
			if(rs==null) {studentList=null;}
			while(rs.next()) {
				for(int i=0;i<obj.length;i++) {
					obj[i] = rs.getString("姓名");
			}}
			studentList.add(obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	/**
	 * 模糊查找学校
	 * @param schName
	 * @return
	 * @throws Exception
	 */
	public static List<School> likeFind(String schName)  {
		List<School> schoolList=new ArrayList<School>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT school.id,school.学校  FROM school WHERE school.学校 like ?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,"%"+schName+"%");
			rs = prestmt.executeQuery();
			if(rs==null) {schoolList=null;}
			while(rs.next()) {
				int schId = rs.getInt("id");
				String schName1 = rs.getString("学校");
				School school = new School(schId, schName1);
				schoolList.add(school);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schoolList;
	}
	

	/**
	 * 查看所有学校
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<School> findAll() {
		List<School> schoolList = new ArrayList<School>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM school ";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				int schId = rs.getInt("id");
				String schName = rs.getString("学校");
				School school = new School(schId, schName);
				schoolList.add(school);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schoolList;

	}

	/**
	 * 添加学校功能
	 * 
	 * @return
	 */
	public static int add(String school)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into school values(null,?)";
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

	/**
	 * 删除学校功能
	 * 
	 * @return
	 */
	public static int delete(String school) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from school where 学校=?";
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

	/**
	 * 修改学校功能
	 * @param school1原来学校名字
	 * @param school2后来学校名字
	 * @return
	 */
	public static int update(String school1,String school2) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update school set 学校=? WHERE school.学校=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,school2);
			prestmt.setString(2, school1);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}


}