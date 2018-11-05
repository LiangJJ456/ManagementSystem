package com.LiangZhenJi.www.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.LiangZhenJi.www.util.DatabaseConnect;


public class Login {
	/**
	 * 检查用户名和密码是否正确
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
public static int check(String username,String password) {
	DatabaseConnect dbuntil = new DatabaseConnect();
	Connection con = dbuntil.getcon();// 获取数据连接
	String sql="SELECT 用户名,密码  FROM USER WHERE 用户名=? AND 密码=?";
	PreparedStatement prestmt = null;
	int result=0;
	ResultSet rs=null;
	try {
		prestmt = con.prepareStatement(sql);
		prestmt.setString(1, username);
		prestmt.setString(2, password);
		rs=prestmt.executeQuery();
		while(rs.next()) {
			result=1;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
	
	}
/**
 * 判断用户为老师还是学生
 * @param username
 * @param password
 * @return
 */
public static String select(String userName,String passWord) {
	DatabaseConnect dbuntil = new DatabaseConnect();
	Connection con = dbuntil.getcon();// 获取数据连接
	String str=null;
	String sql = "SELECT 用户类别  FROM user WHERE 用户名=? and 密码=? ";
	PreparedStatement prestmt=null;
	ResultSet rs=null;
	try {
		prestmt = con.prepareStatement(sql);
		prestmt.setString(1, userName);
		prestmt.setString(2, passWord);
		rs = prestmt.executeQuery();
		while(rs.next()) {
			str=rs.getString("用户类别");
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
	return str;
}

}

