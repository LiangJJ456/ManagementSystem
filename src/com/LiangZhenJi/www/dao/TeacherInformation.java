package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.LiangZhenJi.www.util.DatabaseConnect;

public class TeacherInformation {
	public static Object[] teaInformation(String userid)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql="SELECT teacher.id,teacher.姓名,teacher.学校,teacher.年级,teacher.班级,teacher.电话,teacher.邮箱,teacher.科目  FROM teacher WHERE id=?";
		PreparedStatement prestmt = null;
		Object[] obj=new Object[8];
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, userid);
			rs = prestmt.executeQuery();
			while(rs.next()) {
				obj[0] = rs.getString("teacher.id");
				obj[1] = rs.getString("teacher.姓名");
				obj[2] = rs.getString("teacher.学校");
				obj[3] = rs.getString("teacher.年级");
				obj[4] = rs.getString("teacher.班级");
				obj[5] = rs.getString("teacher.电话");
				obj[6] = rs.getString("teacher.邮箱");
				obj[7] = rs.getString("teacher.科目");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
		
		
	}

}

