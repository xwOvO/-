package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.admin.model.Book;
import com.admin.util.StringUtil;

/**
 * 图书Dao类
 * @author Administrator
 *
 */
public class BookDao {
	
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		
		String sql="insert into t_book values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getPubdate());
		pstmt.setString(5, book.getSummary());
		pstmt.setInt(6, book.getNowNum());
		pstmt.setInt(7, book.getNowNum());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Book book) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_book");
		if(book.getId()!=null) {
			sb.append(" and id="+book.getId());
		}
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and author like '%"+book.getAuthor()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getPublisher())) {
			sb.append(" and publisher like '%"+book.getPublisher()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception{
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书信息修改
	 */
	public int update(Connection con,Book book)throws Exception{
		String sql="update t_book set bookName=?,author=?,publisher=?,pubdate=?,summary=?,nowNum=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getBookName());
		pstmt.setString(2,book.getAuthor());
		pstmt.setString(3,book.getPublisher());
		pstmt.setString(4,book.getPubdate());
		pstmt.setString(5,book.getSummary());
		pstmt.setInt(6, book.getNowNum());
		pstmt.setInt(7,book.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 借阅表存在图书
	 * @param con
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookId(Connection con,String bookId) throws Exception{
		String sql="select * from t_borrow where bid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,bookId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
}
