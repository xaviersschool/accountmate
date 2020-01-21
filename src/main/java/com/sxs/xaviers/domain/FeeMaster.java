package com.sxs.xaviers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fee_master")
public class FeeMaster {
	
	@Id
	@Column(name = "FEEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long feeId;
	
	private String month;
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
	
	public long getFeeId() {
		return feeId;
	}
	public void setFeeId(long feeId) {
		this.feeId = feeId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
	
}
