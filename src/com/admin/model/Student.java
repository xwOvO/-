package com.admin.model;

/**
 * ͼ�����ʵ��
 * @author Administrator
 *
 */
public class Student {
	
	private Integer id; //���
	private String studentName;//����
	private String sex;//�Ա�
	private String dept;//ϵ��
	private String grade;//�꼶
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String studentName, String sex, String dept, String grade) {
		super();
		this.studentName = studentName;
		this.sex = sex;
		this.dept = dept;
		this.grade = grade;
	}


	public Student(Integer id, String studentName, String dept, String grade) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.dept = dept;
		this.grade = grade;
	}


	public Student(Integer id, String studentName, String sex, String dept, String grade) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.sex = sex;
		this.dept = dept;
		this.grade = grade;
	}


	public Student(Integer id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
