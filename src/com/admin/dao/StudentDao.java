package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.admin.model.Student;
import com.admin.util.StringUtil;

/**
 * 图书类别Dao类
 * @author Administrator
 *
 */
public class StudentDao {
	
	/**
	 * 图书类别添加
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Student student)throws Exception{
		String sql="insert into t_student values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStudentName());
		pstmt.setString(2, student.getSex());
		pstmt.setString(3, student.getDept());
		pstmt.setString(4, student.getGrade());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询图书类别结合
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Student student)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_student");
		if(student.getId() != null) {
			sb.append(" and id="+student.getId());
		}
		if(StringUtil.isNotEmpty(student.getStudentName())) {
			sb.append(" and studentName like '%"+student.getStudentName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())) {
			sb.append(" and sex like '%"+student.getSex()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getDept())) {
			sb.append(" and dept like '%"+student.getDept()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getGrade())) {
			sb.append(" and grade like '%"+student.getGrade()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_student where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新图书类别
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Student student)throws Exception{
		String sql="update t_student set studentName=?,sex=?,dept=?,grade=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStudentName());
		pstmt.setString(2, student.getSex());
		pstmt.setString(3, student.getDept());
		pstmt.setString(4, student.getGrade());
		pstmt.setInt(5, student.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 借阅表存在学生
	 * @param con
	 * @param StudentId
	 * @return
	 * @throws Exception
	 */
	public boolean existStudentByStudentId(Connection con,String StudentId) throws Exception{
		String sql="select * from t_borrow where sid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,StudentId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
}
