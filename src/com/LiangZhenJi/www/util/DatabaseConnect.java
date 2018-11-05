package com.LiangZhenJi.www.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {

	// 数据库地址
	private static String dburl = "jdbc:mysql://localhost:3306/student_managementsystem";
	// 用户名
	private static String dbUserName = "root";
	// 密码
	private static String dbPassword = "234048";

	/**
	 * 连接数据库
	 * @return
	 */
	public Connection getcon() {
		Connection com = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			com = DriverManager.getConnection(dburl, dbUserName, dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return com;
	}

	

	/**
	 * 关闭数据库
	 * @param com
	 * @param stmt
	 * 
	 */
	public void close(Connection com, Statement stmt)  {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (com != null) {
			try {
				com.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}}