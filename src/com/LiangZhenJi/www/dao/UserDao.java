package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.LiangZhenJi.www.po.User;
import com.LiangZhenJi.www.util.DatabaseConnect;

public class UserDao {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public static int add(User user)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into user values(null,?,?,?)";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, user.getUserName());
			prestmt.setString(2, user.getUserPassword());
			prestmt.setString(3, user.getUserKind());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 删除用户
	 * @param userName
	 * @return
	 */
	public static int delete(String userName) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from user where 用户名=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, userName);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 修改密码
	 * @param userPassword1
	 * @param userPassword2
	 * @return
	 */
	public static int update(String userPassword1,String userPassword2) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update class set 密码=? WHERE 密码=? ";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, userPassword2);
			prestmt.setString(2, userPassword1);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 修改用户名
	 * @param userName1
	 * @param userName2
	 * @return
	 */
	public static int updateUserName(String userName1,String userName2) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update class set 用户名=? WHERE 用户名=? ";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, userName2);
			prestmt.setString(2, userName1);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

}
