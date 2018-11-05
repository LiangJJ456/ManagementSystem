package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LiangZhenJi.www.po.Student;
import com.LiangZhenJi.www.util.DatabaseConnect;

/**
 * 对学生信息进行增删改查操作
 * 
 * @author l
 *
 */
public class StudentCrud  {
	/**
	 * 查找某个学生信息，已经包括学生所在的学校，年级，班级
	 * 
	 * @return
	 */
	public static Student find(String msg)  {
		// msg可以为学号或者学生姓名
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT student.id,student.姓名,student.性别,student.邮箱,student.紧急联系人电话,"
				+ "student.年级,student.班级,student.学校  FROM student WHERE "
				+ "student.姓名=? or student.id=?";
		PreparedStatement prestmt=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, msg);
			prestmt.setString(2, msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs=null;
		Student student=null;
		try {
			rs = prestmt.executeQuery();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		try {
			while(rs.next()) {
				String stuId = rs.getString("id");
				String stuName = rs.getString("姓名");
				String stuSex = rs.getString("性别");
				String stuEmail = rs.getString("邮箱");
				String stuConNum = rs.getString("紧急联系人电话");
				String stuSchool = rs.getString("学校");
				String stuGrade = rs.getString("年级");
				int stuClass = rs.getInt("班级");
				student=new Student();
				student.setStuId(stuId);
				student.setStuName(stuName);
				student.setStuSex(stuSex);
				student.setStuEmail(stuEmail);
				student.setStuConNum(stuConNum);
				student.setStuSchool(stuSchool);
				student.setStuGrade(stuGrade);
				student.setStuClass(stuClass);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return student;

	}

	/**
	 * 利用学号或者字符串模糊查找
	 */
	public static List<Student> likeFind(String msg)  {
		// msg字符串可以是学号的一部分也可以是姓名的一部分
		List<Student> studentList = new ArrayList<Student>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT student.id,student.姓名,student.性别,student.邮箱,student.紧急联系人电话,"
				+ "student.年级,student.班级,student.学校 "
				+ "FROM student WHERE student.姓名 like ? or id like ?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		Student student=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,"%"+ msg+"%");
			prestmt.setString(2,"%"+ msg+"%");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = prestmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(rs==null) {studentList=null;}
			while (rs.next()) {
				String stuId = rs.getString("id");
				String stuName = rs.getString("姓名");
				String stuSex = rs.getString("性别");
				String stuEmail = rs.getString("邮箱");
				String stuConNum = rs.getString("紧急联系人电话");
				String stuSchool = rs.getString("学校");
				String stuGrade = rs.getString("年级");
				int stuClass = rs.getInt("班级");
				student=new Student();
				student.setStuId(stuId);
				student.setStuName(stuName);
				student.setStuSex(stuSex);
				student.setStuEmail(stuEmail);
				student.setStuConNum(stuConNum);
				student.setStuSchool(stuSchool);
				student.setStuGrade(stuGrade);
				student.setStuClass(stuClass);
				studentList.add(student);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * 查看所有学生信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Student> findAll() {
		List<Student> studentlist = new ArrayList<Student>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT student.id,student.姓名,student.性别,student.邮箱,student.紧急联系人电话,"
				+ "student.年级,student.班级,student.学校  FROM student";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			rs = prestmt.executeQuery();
			if(rs==null) {studentlist=null;}
			while (rs.next()) {
				String stuId = rs.getString("student.id");
				String stuName = rs.getString("姓名");
				String stuSex = rs.getString("性别");
				String stuEmail = rs.getString("邮箱");
				String stuConNum = rs.getString("紧急联系人电话");
				String stuSchool = rs.getString("学校");
				String stuGrade = rs.getString("年级");
				int stuClass = rs.getInt("班级");
				Student student = new Student(stuId, stuName, stuSex, stuEmail, 
						stuConNum, stuSchool, stuGrade, stuClass);
				studentlist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return studentlist;

	}

	/**
	 * 添加功能
	 * 
	 * @return
	 */
	public static int add(Student student) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into student values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, student.getStuId());
			prestmt.setString(2, student.getStuName());
			prestmt.setString(3, student.getStuSex());
			prestmt.setString(4, student.getStuEmail());
			prestmt.setString(5, student.getStuConNum());
			prestmt.setString(6, student.getStuSchool());
			prestmt.setString(7, student.getStuGrade());
			prestmt.setInt(8, student.getStuClass());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 删除功能
	 * 
	 * @return
	 */
	public static int delete(String msg) {
		//msg可以是姓名或者学号
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from student where 姓名=? or id=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, msg);
			prestmt.setString(2, msg);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 删除学校对应的学生
	 * @param msg是学校
	 * @return
	 */
	public static int deleteSchool(String msg) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from student where 学校=?  ";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, msg);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 删除学校，年级对应的学生
	 * @param grade是年级,school 为学校
	 * @return
	 */
	public static int deleteSchGre(String grade,String school) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from student where 学校=? and 年级=? ";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,school);
			prestmt.setString(2,grade);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	
	/**
	 * 删除班级对应的学生
	 * @param msg可以是班级, grade可以是年级,school 可以为学校
	 * @return
	 */
	public static int deleteClass(int msg,String grade,String school) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from student where 学校=? and 年级=? and 班级=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,school);
			prestmt.setString(2,grade);
			prestmt.setInt(3, msg);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 修改功能
	 * 
	 * @return
	 */
	public static int update(Student student)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update student set id=?, 性别=?,邮箱=?,紧急联系人电话=?"
				+ ",学校=?,年级=?,班级=? where 姓名=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, student.getStuId());
			prestmt.setString(2, student.getStuSex());
			prestmt.setString(3, student.getStuEmail());
			prestmt.setString(4, student.getStuConNum());
			prestmt.setString(5, student.getStuSchool());
			prestmt.setString(6, student.getStuGrade());
			prestmt.setInt(7, student.getStuClass());
			prestmt.setString(8, student.getStuName());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

}