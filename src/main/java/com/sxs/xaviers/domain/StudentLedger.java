package com.sxs.xaviers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_ledger")
public class StudentLedger {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	private long studentId;	
	private String month;
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

}
