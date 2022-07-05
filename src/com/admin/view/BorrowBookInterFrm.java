package com.admin.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.admin.dao.BookDao;
import com.admin.dao.BorrowDao;
import com.admin.dao.StudentDao;
import com.admin.model.Book;
import com.admin.model.Borrow;
import com.admin.model.Student;
import com.admin.util.DbUtil;
import com.admin.util.StringUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BorrowBookInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private JTextField s_publisherTxt;
	private JTextField studentIdTxt;
	private JTextField studentNameTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();
	private BorrowDao borrowDao=new BorrowDao();
	private StudentDao studentDao=new StudentDao();
	private JTextField borrowTimeTxt;
	private JTextField bidTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowBookInterFrm frame = new BorrowBookInterFrm();
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
	public BorrowBookInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u501F\u9605\u4E66\u7C4D");
		setBounds(100, 100, 748, 363);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mvt) {
				//bookTableMousePressed(mvt);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_publisherTxt = new JTextField();
		s_publisherTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("\u501F\u9605");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("\u501F\u9605\u4EBAID\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		studentIdTxt = new JTextField();
		studentIdTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u501F\u9605\u4EBA\u540D\u5B57\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		studentNameTxt = new JTextField();
		studentNameTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u501F\u9605\u65F6\u957F\uFF08\u79D2\uFF09\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		borrowTimeTxt = new JTextField();
		borrowTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u501F\u4E66ID:");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 15));
		
		bidTxt = new JTextField();
		bidTxt.setEditable(false);
		bidTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_publisherTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton)))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bidTxt)
								.addComponent(studentIdTxt, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(86)
									.addComponent(lblNewLabel_4)
									.addGap(2)
									.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
									.addComponent(btnNewButton_1)
									.addGap(72))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(76)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(284, Short.MAX_VALUE))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_3)
									.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_4))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(bidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mvt) {
				bookTableMousePressed(mvt);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u51FA\u7248\u65E5\u671F", "\u6458\u8981", "\u5F53\u524D\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(165);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Book());
	}
	
	/**
	 * 鼠标点击表单事件
	 * @param mvt
	 */
	protected void bookTableMousePressed(MouseEvent mvt) {
		// TODO Auto-generated method stub
		int row=this.bookTable.getSelectedRow();
		this.bidTxt.setText(bookTable.getValueAt(row, 0).toString());
	}

	/**
	 * 点击借阅事件
	 * @param e
	 */
	protected void borrowActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String sid=this.studentIdTxt.getText();
		String studentName=this.studentNameTxt.getText();
		Student student = new Student(Integer.parseInt(sid),studentName);
		String bTime=this.borrowTimeTxt.getText();
		String bid=this.bidTxt.getText();
		Borrow borrow = new Borrow(Integer.parseInt(sid),Integer.parseInt(bid));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nT = 1000*(new java.util.Date().getTime()/1000);
		Timestamp dT = null;
		
		if(StringUtil.isEmpty(sid)) {
			JOptionPane.showMessageDialog(null, "学生ID不能为空");
			return;
		}
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(null, "学生姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(bTime)) {
			JOptionPane.showMessageDialog(null, "借书时间不能为空");
			return;
		}
		
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=studentDao.list(con, student);
			ResultSet rs2=borrowDao.list(con, borrow);
			ResultSet rs3=borrowDao.list(con, new Borrow(Integer.parseInt(sid)));
			boolean HasOverDueFlag=false;
			while(rs3.next()) {
				dT=rs3.getTimestamp("dueTime");
				if(differentDaysByMillisecond(nT,dT.getTime())>0) {
					HasOverDueFlag=true;
				}
			}
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "没有此ID的学生");
			}else if(HasOverDueFlag){
				JOptionPane.showMessageDialog(null, "你有超期没还的书，请还书后再借！");
			}else if(rs2.next()){
				JOptionPane.showMessageDialog(null, "你已经借过这本书了");
			}else{
				long nowTime = new java.util.Date().getTime();
				String borrowTime = sdf.format(new java.sql.Timestamp(nowTime));
				String dueTime = sdf.format(TimeCal(nowTime,Integer.parseInt(bTime)));
				borrow = new Borrow(Integer.parseInt(sid),Integer.parseInt(bid),borrowTime,dueTime);
				int addNum=borrowDao.add(con, borrow);
				if(addNum==1) {
					JOptionPane.showMessageDialog(null, "借阅成功！");
					fillTable(new Book());
					this.borrowTimeTxt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "借阅失败！");
				}
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
	 * 点击搜索事件
	 * @param e
	 */
	protected void bookSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		String publisher=this.s_publisherTxt.getText();
		Book book = new Book(bookName,author,publisher);
		
		this.fillTable(book);
	}

	/**
	 * 填充Table
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel)bookTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con, book);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("publisher"));
				v.add(rs.getString("pubdate"));
				v.add(rs.getString("summary"));
				v.add(rs.getInt("nowNum"));
				rs.getInt("total");
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
	
	public long TimeCal(long sellTimeFrom,Integer x){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(sellTimeFrom));
        calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND) + x);
        return calendar.getTime().getTime();
	}
	
	public static int differentDaysByMillisecond(long date1,long date2)
	{
		int days = (int) Math.ceil(((double)(date1 - date2) / (1000*3600*24)));
		//System.out.println((double)(date1 - date2) / (1000*3600*24));
		return days;
	}

}
