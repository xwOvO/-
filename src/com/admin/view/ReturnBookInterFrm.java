package com.admin.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.admin.dao.BookDao;
import com.admin.dao.BorrowDao;
import com.admin.dao.StudentDao;
import com.admin.model.Book;
import com.admin.model.Borrow;
import com.admin.model.Student;
import com.admin.util.DbUtil;
import com.admin.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturnBookInterFrm extends JInternalFrame {
	private JTextField s_sidTxt;
	private JTable borrowTable;
	
	private DbUtil dbUtil=new DbUtil();
	private StudentDao studentDao=new StudentDao();
	private BookDao bookDao = new BookDao();
	private BorrowDao borrowDao=new BorrowDao();
	private JTextField s_studentNameTxt;
	private Integer sid;
	private Integer bid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookInterFrm frame = new ReturnBookInterFrm();
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
	public ReturnBookInterFrm() {
		setTitle("\u5F52\u8FD8\u4E66\u7C4D");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 997, 315);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751FID:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_sidTxt = new JTextField();
		s_sidTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("\u5F52\u8FD8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBookActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_studentNameTxt = new JTextField();
		s_studentNameTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(s_sidTxt, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(61)
							.addComponent(btnNewButton_1)
							.addGap(91))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel_1)
						.addComponent(s_sidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		
		borrowTable = new JTable();
		borrowTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mev) {
				borrowTableMousePressed(mev);
			}
		});
		borrowTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751Fid", "\u5B66\u751F\u59D3\u540D", "\u501F\u4E66id", "\u6240\u501F\u4E66\u540D", "\u501F\u4E66\u65F6\u95F4", "\u5230\u671F\u65F6\u95F4", "\u5F52\u8FD8\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		borrowTable.getColumnModel().getColumn(3).setPreferredWidth(117);
		borrowTable.getColumnModel().getColumn(4).setPreferredWidth(87);
		borrowTable.getColumnModel().getColumn(5).setPreferredWidth(89);
		borrowTable.getColumnModel().getColumn(6).setPreferredWidth(90);
		scrollPane.setViewportView(borrowTable);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 鼠标点击表格事件
	 * @param mev
	 */
	protected void borrowTableMousePressed(MouseEvent mev) {
		// TODO Auto-generated method stub
		int row=borrowTable.getSelectedRow();
		this.sid = (Integer)borrowTable.getValueAt(row, 0);
		this.bid = (Integer)borrowTable.getValueAt(row, 2);
	}

	/**
	 * 归还图书事件处理
	 * @param e
	 */
	protected void returnBookActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		long nowTime = 1000*(new java.util.Date().getTime()/1000);
		Timestamp dueTime = null;
		Borrow borrow = new Borrow(sid,bid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=borrowDao.list(con, borrow);
			while(rs.next()) {
				dueTime=rs.getTimestamp("dueTime");
			}
			int delete=borrowDao.delete(con, sid.toString(), bid.toString());
			if(delete!=1) {
				JOptionPane.showMessageDialog(null, "还书失败");
				return;
			}else {
				if(differentDaysByMillisecond(nowTime,dueTime.getTime())>0) {
					JOptionPane.showMessageDialog(null, "还书成功！你还书超期了"+differentDaysByMillisecond(nowTime,dueTime.getTime())+"天！请注意及时还书");
				}else {
					JOptionPane.showMessageDialog(null, "还书成功");
				}
				this.fillTable(new Borrow(sid));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
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
	 * 学生搜索借阅表事件
	 * @param e
	 */
	protected void borrowSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String studentName=this.s_studentNameTxt.getText();
		String sid=this.s_sidTxt.getText();
		Student student;
		if(StringUtil.isEmpty(sid)) {
			student = new Student(null,studentName);
		}else {
			student = new Student(Integer.parseInt(sid),studentName);
		}
		if(StringUtil.isEmpty(sid)) {
			JOptionPane.showMessageDialog(null, "学生id不能为空");
			return;
		}
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=studentDao.list(con, student);
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "没有此ID的学生");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Borrow borrow = new Borrow(Integer.parseInt(sid));
		this.fillTable(borrow);
	}

	/**
	 * 初始化表格
	 * @param student
	 */
	private void fillTable(Borrow borrow) {
		DefaultTableModel dtm = (DefaultTableModel)borrowTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=borrowDao.list(con, borrow);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("sid"));
				v.add(rs.getString("studentName"));
				v.add(rs.getInt("bid"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("borrowTime"));
				v.add(rs.getString("dueTime"));
				v.add(rs.getString("returnTime"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int differentDaysByMillisecond(long date1,long date2)
	{
		int days = (int) Math.ceil(((double)(date1 - date2) / (1000*3600*24)));
		//System.out.println((double)(date1 - date2) / (1000*3600*24));
		return days;
	}
}
