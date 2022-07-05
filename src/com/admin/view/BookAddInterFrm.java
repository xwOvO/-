package com.admin.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.admin.dao.BookDao;
import com.admin.dao.StudentDao;
import com.admin.model.Book;
import com.admin.model.Student;
import com.admin.util.DbUtil;
import com.admin.util.StringUtil;
import java.awt.Font;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField publisherTxt;
	private JTextArea summaryTxt;
	private JTextField pubdateTxt;
	private JTextField nowNumTxt;
	
	private DbUtil dbUtil=new DbUtil();
	
	private BookDao bookDao=new BookDao();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 665, 581);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u51FA\u7248\u793E\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u5185\u5BB9\u6458\u8981\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		summaryTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("\u51FA\u7248\u65F6\u95F4\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("\u8F93\u5165\u683C\u5F0F\u4E3A\uFF1AYYYY-MM-DD");
		
		pubdateTxt = new JTextField();
		pubdateTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u672C\u6570\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		nowNumTxt = new JTextField();
		nowNumTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel))
									.addGap(33))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
											.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1)
											.addComponent(lblNewLabel_5))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
											.addComponent(pubdateTxt, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
									.addComponent(nowNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton)
										.addGap(18)
										.addComponent(btnNewButton_1))
									.addComponent(summaryTxt, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)))))
					.addGap(103))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(pubdateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_6)
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(nowNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addComponent(lblNewLabel_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(summaryTxt, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(80))
		);
		getContentPane().setLayout(groupLayout);
		
		summaryTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

		//this.fillBookType();
	}
	
	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		resetValue();
	}

	/**
	 * 图书添加事件处理
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String publisher=this.publisherTxt.getText();
		String summary=this.summaryTxt.getText();
		String pubdate=this.pubdateTxt.getText();
		String nowNum=this.nowNumTxt.getText();
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(publisher)) {
			JOptionPane.showMessageDialog(null, "图书出版社不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(pubdate)) {
			JOptionPane.showMessageDialog(null, "图书出版日期不能为空");
			return;
		}

		
		if(StringUtil.isEmpty(nowNum)) {
			JOptionPane.showMessageDialog(null, "图书数量不能为空");
			return;
		}	
		
		Book book = new Book(bookName, author, publisher, pubdate, summary, Integer.parseInt(nowNum));
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addNum=bookDao.add(con, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.publisherTxt.setText("");
		this.summaryTxt.setText("");
		this.pubdateTxt.setText("");
		this.nowNumTxt.setText("");
	}

	/**
	 * 初始化类别下拉框
	 */
//	private void fillBookType() {
//		Connection con=null;
//		BookType bookType=null;
//		try {
//			con=dbUtil.getCon();
//			ResultSet rs=bookTypeDao.list(con, new BookType());
//			while(rs.next()) {
//				bookType = new BookType();
//				bookType.setId(rs.getInt("id"));
//				bookType.setBookTypeName(rs.getString("bookTypeName"));
//				this.bookTypeJcb.addItem(bookType);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//		}
//	}
}
