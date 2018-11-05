package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LiangZhenJi.www.po.Subject;
import com.LiangZhenJi.www.util.DatabaseConnect;

/**
 * 对科目进行增删查改操作
 * @author l
 *
 */
public class SubjectCrud {

	/**
	 * 查看所有科目
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Subject> findAll()  {
		List<Subject> studentlist = new ArrayList<Subject>();
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT * FROM subject ";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			rs = prestmt.executeQuery();
			if(rs==null) {studentlist=null;}
			while (rs.next()) {
				int subId = rs.getInt("id");
				String subName = rs.getString("科目");
				Subject subject = new Subject(subId, subName);
				studentlist.add(subject);
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
		return studentlist;

	}

	/**
	 * 添加科目功能
	 * 
	 * @return
	 */
	public static int add(String subject) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into subject values(null,?)";
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
	 * 删除科目功能
	 * 
	 * @return
	 */
	public static int delete(String subName) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from subject where 科目=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, subName);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

	/**
	 * 修改科目功能
	 * @param subject1原来的科目
	 * @param subject2后来的科目
	 * @return
	 */
	public static int update(String subject1,String subject2)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update subject set 科目=? WHERE subject.科目=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,subject2);
			prestmt.setString(1,subject1);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

}
