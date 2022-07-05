package com.admin.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.admin.dao.StudentDao;
import com.admin.model.Student;
import com.admin.util.DbUtil;
import com.admin.util.StringUtil;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class StudentAddInterFrm extends JInternalFrame {
	private JTextField studentNameTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private StudentDao studentDao=new StudentDao();
	private JTextField deptTxt;
	private JTextField gradeTxt;
	private JRadioButton maleJrb;
	private JRadioButton femaleJrb;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAddInterFrm frame = new StudentAddInterFrm();
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
	public StudentAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u6DFB\u52A0");
		setBounds(100, 100, 444, 419);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		studentNameTxt = new JTextField();
		studentNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentAddActionPerfromed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\u7CFB\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u7EA7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		deptTxt = new JTextField();
		deptTxt.setColumns(10);
		
		gradeTxt = new JTextField();
		gradeTxt.setColumns(10);
		
		maleJrb = new JRadioButton("\u7537");
		buttonGroup.add(maleJrb);
		maleJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		femaleJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(btnNewButton)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(gradeTxt, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(btnNewButton_1))
								.addComponent(deptTxt, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(maleJrb)
									.addGap(18)
									.addComponent(femaleJrb)))))
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(maleJrb)
						.addComponent(femaleJrb))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(deptTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(gradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
	
	/**
	 * 学生添加事件处理
	 * @param e
	 */
	private void studentAddActionPerfromed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String studentName=this.studentNameTxt.getText();
		String dept=this.deptTxt.getText();
		String grade=this.gradeTxt.getText();
		String sex;
		if(this.maleJrb.isSelected()) {
			sex="男";
		}else if(this.femaleJrb.isSelected()) {
			sex="女";
		}else {
			sex="";
		}
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(null, "学生名称不能为空");
			return;
		}
		
		Student student=new Student(studentName,sex,dept,grade);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=studentDao.add(con, student);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "学生添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "学生添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "学生添加失败！");
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
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void  resetValue() {
		this.studentNameTxt.setText("");
		this.deptTxt.setText("");
		this.gradeTxt.setText("");
		this.maleJrb.setSelected(false);
		this.femaleJrb.setSelected(false);
	}
}
