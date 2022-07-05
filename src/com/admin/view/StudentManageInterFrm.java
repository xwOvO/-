package com.admin.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class StudentManageInterFrm extends JInternalFrame {
	private JTable studentTable;

	
	private DbUtil dbUtil=new DbUtil();
	private StudentDao studentDao=new StudentDao();
	private BookDao bookDao = new BookDao();
	private BorrowDao borrowDao=new BorrowDao();
	private JTextField s_studentNameTxt;
	private JTextField idTxt;
	private JTextField studentNameTxt;
	private JTextField s_idTxt;
	private JTextField s_deptTxt;
	private JTextField s_gradeTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField deptTxt;
	private JTextField gradeTxt;
	private JRadioButton maleJrb;
	private JRadioButton femaleJrb;
	private JTable borrowTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageInterFrm frame = new StudentManageInterFrm();
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
	public StudentManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u7BA1\u7406");
		setBounds(100, 100, 953, 602);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_studentNameTxt = new JTextField();
		s_studentNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751FID\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_idTxt = new JTextField();
		s_idTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u7CFB\u540D\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_deptTxt = new JTextField();
		s_deptTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5E74\u7EA7\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_gradeTxt = new JTextField();
		s_gradeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3, Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_deptTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_gradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
									.addComponent(btnNewButton)))
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel_4)
						.addComponent(s_idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(s_deptTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(s_gradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGap(48)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		
		borrowTable = new JTable();
		borrowTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751Fid", "\u5B66\u751F\u59D3\u540D", "\u501F\u4E66id", "\u501F\u4E66\u540D", "\u501F\u4E66\u65F6\u95F4", "\u5230\u671F\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(borrowTable);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		studentNameTxt = new JTextField();
		studentNameTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentUpdateActionEvent(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentDeleteActionEvent(e);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 15));
		
		maleJrb = new JRadioButton("\u7537");
		buttonGroup.add(maleJrb);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_8 = new JLabel("\u7CFB\u540D\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 15));
		
		deptTxt = new JTextField();
		deptTxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u5E74\u7EA7\uFF1A");
		
		gradeTxt = new JTextField();
		gradeTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maleJrb)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(femaleJrb)
							.addGap(13)
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deptTxt, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(75)
							.addComponent(btnNewButton_2)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_2)
									.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_7))
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_1)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(maleJrb)
								.addComponent(femaleJrb)
								.addComponent(lblNewLabel_8)
								.addComponent(deptTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9)
								.addComponent(gradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(264, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		studentTable = new JTable();
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentTableMousePressed(e);
			}
		});
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u59D3\u540D", "\u6027\u522B", "\u7CFB\u540D", "\u5E74\u7EA7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		studentTable.getColumnModel().getColumn(3).setPreferredWidth(127);
		scrollPane.setViewportView(studentTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Student());
	}
	
	/**
	 * 图书类别删除事件处理
	 * @param e
	 */
	private void studentDeleteActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				boolean flag=studentDao.existStudentByStudentId(con, id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "该读者有尚未归还的借书，不允许删除");
					return;
				}
				int deleteNum=studentDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Student());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
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
	}

	/**
	 * 图书类别修改事件处理
	 * @param evt
	 */
	private void studentUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		String studentName=studentNameTxt.getText();
		String dept=deptTxt.getText();
		String grade=gradeTxt.getText();
		String sex;
		if(maleJrb.isSelected()) {
			sex="男";
		}else if(femaleJrb.isSelected()) {
			sex="女";
		}else {
			sex="";
		}
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		Student student=new Student(Integer.parseInt(id),studentName,sex,dept,grade);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=studentDao.update(con, student);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new Student());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "修改失败");
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
	 * 表格行点击事件处理
	 * @param e
	 */
	protected void studentTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=studentTable.getSelectedRow();
		idTxt.setText(studentTable.getValueAt(row, 0).toString());
		studentNameTxt.setText((String)studentTable.getValueAt(row, 1));
		if("男".equals((String)studentTable.getValueAt(row, 2))) {
			maleJrb.setSelected(true);
		}else if("女".equals((String)studentTable.getValueAt(row, 2))){
			femaleJrb.setSelected(true);
		}
		deptTxt.setText((String)studentTable.getValueAt(row, 3));
		gradeTxt.setText((String)studentTable.getValueAt(row, 4));
		Borrow borrow=new Borrow((Integer)studentTable.getValueAt(row, 0));
		this.fillBorrowTable(borrow);
	}

	/**
	 * 学生搜索事件处理
	 * @param evt
	 */
	private void studentSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String studentName=this.s_studentNameTxt.getText();
		String id=this.s_idTxt.getText();
		String dept=this.s_deptTxt.getText();
		String grade=this.s_gradeTxt.getText();
		Student student = null;
		if(StringUtil.isNotEmpty(id)) {
			student = new Student(Integer.parseInt(id),studentName,dept,grade);
		}else {
			Integer t=null;
			student = new Student(t,studentName,dept,grade);
		}
		this.fillTable(student);
	}
	

	/**
	 * 初始化表格
	 * @param student
	 */
	private void fillTable(Student student) {
		DefaultTableModel dtm = (DefaultTableModel)studentTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=studentDao.list(con, student);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("studentName"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("dept"));
				v.add(rs.getString("grade"));
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
	
	/**
	 * 初始化借书表格
	 * @param student
	 */
	private void fillBorrowTable(Borrow borrow) {
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
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.studentNameTxt.setText("");
		this.deptTxt.setText("");
		this.gradeTxt.setText("");
		this.femaleJrb.setSelected(false);
	}
}
