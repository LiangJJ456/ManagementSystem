package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LiangZhenJi.www.po.Grade;
import com.LiangZhenJi.www.util.DatabaseConnect;

public class GradeCrud {
	/**
	 * 模糊查找某个年级的信息，相同的年级可能学校不同
	 * @param graName
	 * @return
	 * @throws Exception
	 */
	public static List<Grade> likefind(String graName) {
		List<Grade> gradeList = new ArrayList<Grade>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM grade WHERE 年级=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, graName);
			rs = prestmt.executeQuery();
			if(rs==null) {gradeList=null;}
			while(rs.next()) {
				int graId = rs.getInt("id");
				String graSchool=rs.getString("学校");
				int graclass = rs.getInt("班级");
				String  graName1=rs.getString("年级");
				String  graorName=rs.getString("级长姓名");
				String telphone=rs.getString("电话");
				String  graEmail=rs.getString("邮箱");
				Grade grade=new Grade(graId,graSchool,graorName,graName1,graclass,telphone,graEmail);
				gradeList.add(grade);
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
		return gradeList;
	}
	
	/**
	 * 查找某学校所有的年级
	 * @param school
	 * @return
	 */
	public static List<Grade> schoolAllGrade(String school) {
		List<Grade> gradeList = new ArrayList<Grade>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM grade WHERE 学校=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, school);
			rs = prestmt.executeQuery();
			if(rs==null) {gradeList=null;}
			while(rs.next()) {
				int graId = rs.getInt("id");
				String graSchool=rs.getString("学校");
				int graclass = rs.getInt("班级");
				String  graName1=rs.getString("年级");
				String  graorName=rs.getString("级长姓名");
				String telphone=rs.getString("电话");
				String  graEmail=rs.getString("邮箱");
				Grade grade=new Grade(graId,graSchool,graorName,graName1,graclass,telphone,graEmail);
				gradeList.add(grade);
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
		return gradeList;
	}
	/**
	 * 具体查找某个年级的信息
	 * @param graName
	 * @param school
	 * @return
	 * @throws Exception
	 */
	public static Grade find(String graName,String school){
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM grade WHERE 年级=? and 学校 =?";
		PreparedStatement prestmt=null;
		ResultSet rs =null;
		Grade grade=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, graName);
			prestmt.setString(2, school);
			rs = prestmt.executeQuery();
			if(rs==null) {grade=null;}
			while(rs.next()) {
				int graId = rs.getInt("id");
				String graSchool=rs.getString("学校");
				int graclass = rs.getInt("班级");
				String  graName1=rs.getString("年级");
				String  graorName=rs.getString("级长姓名");
				String telphone=rs.getString("电话");
				String  graEmail=rs.getString("邮箱");
				grade=new Grade(graId,graSchool,graorName,graName1,graclass,telphone,graEmail);
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
		return grade;
	}
	
	/**
	 * 查看所有年级信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Grade> findAll()  {
		List<Grade> gradeList = new ArrayList<Grade>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM grade ";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			rs = prestmt.executeQuery();
			if(rs==null) {gradeList=null;}
			while (rs.next()) {
				int graId = rs.getInt("id");
				String graSchool=rs.getString("学校");
				int graclass = rs.getInt("班级");
				String  graName1=rs.getString("年级");
				String  graorName=rs.getString("级长姓名");
				String telphone=rs.getString("电话");
				String  graEmail=rs.getString("邮箱");
				Grade grade=new Grade(graId,graSchool,graorName,graName1,graclass,telphone,graEmail);
				gradeList.add(grade);
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
		return gradeList;

	}

	/**
	 * 添加年级功能
	 * @param class1
	 * @return
	 * @throws Exception
	 */
	public static int add(Grade grade) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into grade values(null,?,?,?,?,?,?)";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, grade.getGraSchool());
			prestmt.setString(2, grade.getGraName());
			prestmt.setString(3, grade.getGraorName());
			prestmt.setInt(4, grade.getGraclass());
			prestmt.setString(5, grade.getTelphone());
			prestmt.setString(6, grade.getGraEmail());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 删除年级功能
	 * 
	 * @return
	 */
	public static int delete(String grade,String school)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from grade where 年级=? and school=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, grade);
			prestmt.setString(2, school);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 修改年级功能
	 * 
	 * @return
	 */
	public static int update(Grade grade) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update grade set 级长姓名=?,班级=?,电话=?,邮箱=? WHERE 学校=? and 年级 =?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, grade.getGraorName());
			prestmt.setInt(2, grade.getGraclass());
			prestmt.setString(3, grade.getTelphone());
			prestmt.setString(4, grade.getGraEmail());
			prestmt.setString(5, grade.getGraSchool());
			prestmt.setString(6, grade.getGraName());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}


}
