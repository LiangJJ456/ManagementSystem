package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LiangZhenJi.www.po.Class;
import com.LiangZhenJi.www.util.DatabaseConnect;
/**
 * 对班级的增删查改操作
 * @author l
 *
 */

public class ClassCrud {
	/**
	 * 模糊查询查看班级信息，相同的班级可能学校或者年级不同
	 * @param claName
	 * @return
	 * @throws Exception
	 */
	public static List<Class> likefind(int claName) {
		List<Class> classList=new ArrayList<Class>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM class WHERE 班级=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(1, claName);
			rs = prestmt.executeQuery();
			if(rs==null) {classList=null;}
			while(rs.next()) {
				int claId = rs.getInt("id");
				String claSchool=rs.getString("学校");
				String claGrade=rs.getString("年级");
				int claName1 = rs.getInt("班级");
				String  headteaName=rs.getString("班主任姓名");
				String  headteaNumber=rs.getString("班主任电话");
				String  headteaEmail=rs.getString("邮箱");
				Class class1 = new Class(claId,claSchool, claGrade,claName1,headteaName,headteaNumber,headteaEmail);
				classList.add(class1);
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
		return classList;
	}
	/**
	 * 查找某学校某年级的所有班级
	 * @param claName
	 * @param grade
	 * @return
	 */
	public static List<Class> gradeAllClass(String grade,String school) {
		List<Class> classList=new ArrayList<Class>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM class WHERE 年级=? and 学校=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, grade);
			prestmt.setString(2, school);
			rs = prestmt.executeQuery();
			if(rs==null) {classList=null;}
			while(rs.next()) {
				int claId = rs.getInt("id");
				String claSchool=rs.getString("学校");
				String claGrade=rs.getString("年级");
				int claName1 = rs.getInt("班级");
				String  headteaName=rs.getString("班主任姓名");
				String  headteaNumber=rs.getString("班主任电话");
				String  headteaEmail=rs.getString("邮箱");
				Class class1 = new Class(claId,claSchool, claGrade,claName1,headteaName,headteaNumber,headteaEmail);
				classList.add(class1);
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
		return classList;
	}
	/**
	 * 具体查询某个班级的信息
	 * @param claName
	 * @param grade
	 * @param school
	 * @return
	 * @throws Exception
	 */
	public static Class find(int claName,String grade,String school) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM class WHERE 班级=? and 年级=? and 学校 =?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		Class class1=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(1, claName);
			prestmt.setString(2, grade);
			prestmt.setString(3, school);
			rs = prestmt.executeQuery();
			if(rs==null) {class1=null;}
			while(rs.next()){
				int claId = rs.getInt("id");
				String claSchool=rs.getString("学校");
				String claGrade=rs.getString("年级");
				int claName1 = rs.getInt("班级");
				String  headteaName=rs.getString("班主任姓名");
				String  headteaNumber=rs.getString("班主任电话");
				String  headteaEmail=rs.getString("邮箱");
				class1 = new Class(claId,claSchool, claGrade,claName1,headteaName,headteaNumber,headteaEmail);
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
		return class1;
	}
	/**查询某个班对应学生
	 * @param claName
	 * @return
	 * @throws Exception
	 */
	public static List<Object[]> claFindStu(int claName,String grade,String school) {
		List<Object[]> studentList=new ArrayList<Object[]>();
		Object[] obj=new Object[50];
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT student.姓名  FROM student WHERE student.班级=? and student.年级=? and student.学校=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(1, claName);
			prestmt.setString(2, grade);
			prestmt.setString(3, school);
			rs = prestmt.executeQuery();
			if(rs==null) {studentList=null;}
			int i=0;
			while(rs.next()) {
				obj[i] = rs.getString("student.姓名");
				i++;
			}
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
	 * 查看所有班级信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Class> findAll() {
		List<Class> classList = new ArrayList<Class>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM class ";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			rs = prestmt.executeQuery();
			if(rs==null) {classList=null;}
			while (rs.next()) {
				int claId = rs.getInt("id");
				String claSchool=rs.getString("学校");
				String claGrade=rs.getString("年级");
				int claName1 = rs.getInt("班级");
				String  headteaName=rs.getString("班主任姓名");
				String  headteaNumber=rs.getString("班主任电话");
				String  headteaEmail=rs.getString("邮箱");
				Class class1 = new Class(claId,claSchool, claGrade,claName1,headteaName,headteaNumber,headteaEmail);
				classList.add(class1);
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
		return classList;

	}

	/**
	 * 添加班级功能
	 * @param class1
	 * @return
	 * @throws Exception
	 */
	public static int add(Class class1)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into class values(null,?,?,?,?,?,?)";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, class1.getClaSchool());
			prestmt.setString(2, class1.getClagade());
			prestmt.setInt(3, class1.getClaName());
			prestmt.setString(4, class1.getHeadteaName());
			prestmt.setString(5, class1.getHeadteaNumber());
			prestmt.setString(6, class1.getClaEmail());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 删除具体班级功能
	 * 
	 * @return
	 */
	public static int delete(int class1,String grade,String school) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from class where 班级=? and 年级=? and 学校=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(1, class1);
			prestmt.setString(2, grade);
			prestmt.setString(3, school);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 修改班级功能
	 * 
	 * @return
	 */
	public static int update(Class class1) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update class set 班主任姓名=?,班主任电话=?,邮箱=? WHERE 班级=? and 年级=? and 学校=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, class1.getHeadteaName());
			prestmt.setString(2, class1.getHeadteaNumber());
			prestmt.setString(3, class1.getClaEmail());
			prestmt.setInt(4, class1.getClaName());
			prestmt.setString(5, class1.getClagade());
			prestmt.setString(6, class1.getClaSchool());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}


}
