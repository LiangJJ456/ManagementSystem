package com.LiangZhenJi.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LiangZhenJi.www.po.Score;
import com.LiangZhenJi.www.util.DatabaseConnect;


/**
 * 对成绩的增删改查
 * 增加了评价功能
 * @author l
 *
 */

public class ScoreCrud {
	/**
	 * 查看某学生各科目成绩
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public static List<Object[]> findself(String student)  {
		//msg可以代表学生的姓名或者学号
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		List<Object[]> scoreList = new ArrayList<Object[]>();
		Object[] obj = new Object[4];
		String sql = "SELECT score.id,score.科目,score.成绩,student.姓名  FROM score,student WHERE score.id=? or student.姓名=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,student);
			prestmt.setString(2,student);
			rs = prestmt.executeQuery();
			if(rs==null) scoreList=null; 
			while(rs.next()) {
				String scoId = rs.getString("score.id");
				String scoName = rs.getString("score.科目");
				float score = rs.getFloat("score.成绩");
				String stuName = rs.getString("student.姓名");
				obj[0]=scoId;
				obj[1]=stuName;
				obj[2]=scoName;
				obj[3]=score;
				scoreList.add(obj);
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
		return scoreList;	
	}
	/**
	 * 查看某个学生某科目的成绩,可以通过学号或者姓名加科目名称查询
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public static List<Object[]> find(String msg,String subject)  {
		//msg可以代表学生的姓名或者学号
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		List<Object[]> scoreList = new ArrayList<Object[]>();
		Object[] obj = new Object[4];
		String sql = "SELECT score.id,score.科目,score.成绩,student.姓名  FROM score,student WHERE score.科目=? and score.id="
				+"(SELECT student.id FROM student WHERE student.姓名=? or student.id=?)";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, subject);
			prestmt.setString(2, msg);
			prestmt.setString(3, msg);
			rs = prestmt.executeQuery();
			if(rs==null) {scoreList=null;}
			while(rs.next()) {
				String scoId = rs.getString("score.id");
				String scoName = rs.getString("score.科目");
				float score = rs.getFloat("score.成绩");
				String stuName = rs.getString("student.姓名");
				obj[0]=scoId;
				obj[1]=stuName;
				obj[2]=scoName;
				obj[3]=score;
				scoreList.add(obj);
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
		return scoreList;	
	}
	
	/**
	 * 查看某个科目学生的成绩
	 */
	public static List<Object[]> subFind(String subject) {
		List<Object[]> scoreList = new ArrayList<Object[]>();
		Object[] obj=new Object[3];
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT score.科目,score.成绩,student.姓名  FROM score,student WHERE score.科目=?";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, subject);
			rs = prestmt.executeQuery();
			if(rs==null) {scoreList=null;}
			while(rs.next()) {
				String scoName = rs.getString("score.科目");
				float score = rs.getFloat("score.成绩");
				String stuName = rs.getString("student.姓名");
				obj[0]=scoName;
				obj[1]=stuName;
				obj[2]=score;
				scoreList.add(obj);
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
		return scoreList;
	}
	
	/**
	 * 查看所有学生的成绩
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Object[]> findAll()  {
		List<Object[]> allList = new ArrayList<Object[]>();
		Object[] obj=new Object[4];
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "SELECT score.id,score.科目,score.成绩,student.姓名  FROM score,student WHERE student.id=score.id ";
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		try {
			prestmt = con.prepareStatement(sql);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				String scoId = rs.getString("score.id");
				String scoName = rs.getString("score.科目");
				float score = rs.getFloat("score.成绩");
				String stuName = rs.getString("student.姓名");
				obj[0]=scoId;
				obj[1]=stuName;
				obj[2]=scoName;
				obj[3]=score;
				allList.add(obj);
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
		return allList;

	}

	/**
	 * 添加某个学生某科目的成绩
	 * 
	 * @return
	 */
	public static int add(Score score) {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "insert into score values(null,?,?,?)";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, score.getScoreId());
			prestmt.setString(2, score.getScoSubject());
			prestmt.setFloat(3, score.getScore());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

/**
 * 删除某个学生某科目的成绩
 * @param stuName
 * @param subject
 * @return
 * 
 */
	public static int delete(String stuName,String subject)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from score where score.科目=? and score.id="
				+ "(SELECT student.id Form student WHERE student.姓名=?)";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,subject);
			prestmt.setString(2,stuName);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
/**
 * 删除学生所有成绩	
 * @param stuName
 * @return
 */
	public static int deleteAll(String stuId)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from score where score.id=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,stuId);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	/**
	 * 删除科目成绩
	 * @param subject
	 * @return
	 */
	public static int deleteSubject(String subject)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "delete from score where score.科目=?";
		PreparedStatement prestmt=null;
		int result=0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,subject);
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}

/**
 * 修改某个学生某科目的成绩
 * @param score
 * @return
 * 
 */
	public static int update(Score score)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update score set score.成绩=? WHERE score.科目=? and score.id=?";
		PreparedStatement prestmt=null;
		int result= 0;
		try {
			prestmt = con.prepareStatement(sql);
			prestmt.setFloat(1, score.getScore());
			prestmt.setString(2, score.getScoSubject());
			prestmt.setString(3, score.getScoreId());
			result = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbuntil.close(con, prestmt);
		return result;
	}
	
	/**
	 * 修改分数表的科目的名字
	 * @param subject1原来的
	 * @param subject2后来的
	 * @return
	 */
	public static int updateSubject(String subject1,String subject2)  {
		DatabaseConnect dbuntil = new DatabaseConnect();
		Connection con = dbuntil.getcon();// 获取数据连接
		String sql = "update score set score.科目=? WHERE score.科目=?";
		PreparedStatement prestmt=null;
		int result= 0;
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
}
