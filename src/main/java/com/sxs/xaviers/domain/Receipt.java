package com.sxs.xaviers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receipt")
public class Receipt {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String studentName;
	private String month;
	private String date;
	private String fatherName;
	private int student_class;
	private long ladgerNo;
	private long admissionFee;
	private long prospectus;
	private long tutionFee;
	private long miscelllaneous;
	private long addmissionKit;
	private long festival;
	private long exam;
	private long generator;
	private long lateFee;
	private long others;
	private long previousDue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public int getStudent_class() {
		return student_class;
	}

	public void setStudent_class(int student_class) {
		this.student_class = student_class;
	}

	public long getLadgerNo() {
		return ladgerNo;
	}

	public void setLadgerNo(long ladgerNo) {
		this.ladgerNo = ladgerNo;
	}

	public long getAdmissionFee() {
		return admissionFee;
	}

	public void setAdmissionFee(long admissionFee) {
		this.admissionFee = admissionFee;
	}

	public long getProspectus() {
		return prospectus;
	}

	public void setProspectus(long prospectus) {
		this.prospectus = prospectus;
	}

	public long getTutionFee() {
		return tutionFee;
	}

	public void setTutionFee(long tutionFee) {
		this.tutionFee = tutionFee;
	}

	public long getMiscelllaneous() {
		return miscelllaneous;
	}

	public void setMiscelllaneous(long miscelllaneous) {
		this.miscelllaneous = miscelllaneous;
	}

	public long getAddmissionKit() {
		return addmissionKit;
	}

	public void setAddmissionKit(long addmissionKit) {
		this.addmissionKit = addmissionKit;
	}

	public long getFestival() {
		return festival;
	}

	public void setFestival(long festival) {
		this.festival = festival;
	}

	public long getExam() {
		return exam;
	}

	public void setExam(long exam) {
		this.exam = exam;
	}

	public long getGenerator() {
		return generator;
	}

	public void setGenerator(long generator) {
		this.generator = generator;
	}

	public long getLateFee() {
		return lateFee;
	}

	public void setLateFee(long lateFee) {
		this.lateFee = lateFee;
	}

	public long getOthers() {
		return others;
	}

	public void setOthers(long others) {
		this.others = others;
	}

	public long getPreviousDue() {
		return previousDue;
	}

	public void setPreviousDue(long previousDue) {
		this.previousDue = previousDue;
	}
}
