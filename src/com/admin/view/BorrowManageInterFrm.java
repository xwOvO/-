package com.admin.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BorrowManageInterFrm extends JInternalFrame {
	private JTable borrowTable;
	private DbUtil dbUtil=new DbUtil();
	private StudentDao studentDao=new StudentDao();
	private BookDao bookDao = new BookDao();
	private BorrowDao borrowDao=new BorrowDao();
	private JTextField idTxt;
	private JTextField studentNameTxt;
	private JTextField sexTxt;
	private JTextField deptTxt;
	private JTextField gradeTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowManageInterFrm frame = new BorrowManageInterFrm();
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
	public BorrowManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u501F\u9605\u7BA1\u7406");
		setBounds(100, 100, 858, 374);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u7B5B\u9009\u8D85\u671F\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverDueTimeActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("\u5168\u90E8\u501F\u9605\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectAllBorrowActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8BFB\u8005\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		borrowTable = new JTable();
		borrowTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mev) {
				OverDueTimeStudentMousePressed(mev);
			}
		});
		borrowTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751Fid", "\u5B66\u751F\u59D3\u540D", "\u501F\u4E66id", "\u501F\u4E66\u540D", "\u501F\u4E66\u65F6\u95F4", "\u5230\u671F\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		borrowTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		borrowTable.getColumnModel().getColumn(3).setPreferredWidth(107);
		borrowTable.getColumnModel().getColumn(4).setPreferredWidth(145);
		borrowTable.getColumnModel().getColumn(5).setPreferredWidth(176);
		scrollPane.setViewportView(borrowTable);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 822, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(10)
							.addComponent(btnNewButton_1))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 822, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751FID:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u7CFB\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u5E74\u7EA7\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		studentNameTxt = new JTextField();
		studentNameTxt.setEditable(false);
		studentNameTxt.setColumns(10);
		
		sexTxt = new JTextField();
		sexTxt.setEditable(false);
		sexTxt.setColumns(10);
		
		deptTxt = new JTextField();
		deptTxt.setEditable(false);
		deptTxt.setColumns(10);
		
		gradeTxt = new JTextField();
		gradeTxt.setEditable(false);
		gradeTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(5)
							.addComponent(sexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(24)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
									.addGap(50)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3))))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(deptTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(gradeTxt, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
					.addGap(236))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_3))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_4)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(8)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(16)
									.addComponent(sexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(deptTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(gradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		fillTable(new Borrow());
		
	}
	
	/**
	 * 点击表事件
	 * @param mev
	 */
	protected void OverDueTimeStudentMousePressed(MouseEvent mev) {
		// TODO Auto-generated method stub
		int row=this.borrowTable.getSelectedRow();
		this.idTxt.setText(borrowTable.getValueAt(row, 0).toString());
		this.studentNameTxt.setText((String)borrowTable.getValueAt(row,1));
		Student student = new Student(Integer.parseInt(this.idTxt.getText()),this.studentNameTxt.getText());
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=studentDao.list(con, student);
			while(rs.next()) {
				this.sexTxt.setText(rs.getString("sex"));
				this.deptTxt.setText(rs.getString("dept"));
				this.gradeTxt.setText(rs.getString("grade"));
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
	 * 选择全部借阅表
	 * @param e
	 */
	protected void SelectAllBorrowActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fillTable(new Borrow());
	}

	/**
	 * 点击筛选超期借书事件
	 * @param e
	 */
	protected void OverDueTimeActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		long nowTime = 1000*(new java.util.Date().getTime()/1000);
		Timestamp dueTime = null;
		DefaultTableModel dtm = (DefaultTableModel)borrowTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=borrowDao.list(con, new Borrow());
			while(rs.next()) {
				dueTime=rs.getTimestamp("dueTime");
				Vector v = new Vector();
				if(differentDaysByMillisecond(nowTime,dueTime.getTime())>0) {
					v.add(rs.getInt("sid"));
					v.add(rs.getString("studentName"));
					v.add(rs.getInt("bid"));
					v.add(rs.getString("bookName"));
					v.add(rs.getString("borrowTime"));
					v.add(rs.getString("dueTime"));
					dtm.addRow(v);
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
	 * 填充Table
	 * @param book
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
