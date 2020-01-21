package com.sxs.xaviers.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "student_master")

public class Student {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	
	private long admission_no;
	private long ladgerNo;
	private String dateOfAdmission;
	private String sex;
	private int student_class;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
	private Student_AddInfo stdAddInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAdmission_no() {
		return admission_no;
	}

	public void setAdmission_no(long admission_no) {
		this.admission_no = admission_no;
	}

	public long getLadgerNo() {
		return ladgerNo;
	}

	public void setLadgerNo(long ladgerNo) {
		this.ladgerNo = ladgerNo;
	}

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getStudent_class() {
		return student_class;
	}

	public void setStudent_class(int student_class) {
		this.student_class = student_class;
	}

	public Student_AddInfo getStdAddInfo() {
		return stdAddInfo;
	}

	public void setStdAddInfo(Student_AddInfo stdAddInfo) {
		this.stdAddInfo = stdAddInfo;
	}	
}
