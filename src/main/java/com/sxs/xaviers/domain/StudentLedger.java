package com.sxs.xaviers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student_ledger")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentLedger {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long studentId;
	private String month;
	private String date;
	private long prospectus;
	private long tutionFee;
	private long miscelllaneous;
	private long addmissionKit;
	private long festival;
	private long exam;
	private long generator;
	private long lateFee;
	private long others;
	private long due;
	private long paid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
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

	public long getDue() {
		return due;
	}

	public void setDue(long due) {
		this.due = due;
	}

	public long getPaid() {
		return paid;
	}

	public void setPaid(long paid) {
		this.paid = paid;
	}

}
