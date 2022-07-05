package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.admin.model.Borrow;
import com.admin.model.Student;
import com.admin.util.StringUtil;

public class BorrowDao {
	/**
	 * 借书表添加
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Borrow borrow)throws Exception{
		String sql="insert into t_borrow values(?,?,?,?,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, borrow.getSid());
		pstmt.setInt(2, borrow.getBid());
		pstmt.setString(3, borrow.getBorrowTime());
		pstmt.setString(4, borrow.getDueTime());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询借书表结合
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Borrow borrow)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_borrow br,t_book b,t_student s where br.sid=s.id and br.bid=b.id");
		if(borrow.getSid() != null) {
			sb.append(" and sid="+borrow.getSid());
		}
		if(borrow.getBid() != null) {
			sb.append(" and bid="+borrow.getBid());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除借书表
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String sid,String bid)throws Exception{
		String sql="delete from t_borrow where sid=? and bid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, sid);
		pstmt.setString(2, bid);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新借书表
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
//	public int update(Connection con,Borrow borrow)throws Exception{
//		String sql="update t_student set studentName=?,sex=?,dept=?,grade=? where id=?";
//		PreparedStatement pstmt=con.prepareStatement(sql);
//		pstmt.setString(1, student.getStudentName());
//		pstmt.setString(2, student.getSex());
//		pstmt.setString(3, student.getDept());
//		pstmt.setString(4, student.getGrade());
//		pstmt.setInt(5, student.getId());
//		return pstmt.executeUpdate();
//	}
}
