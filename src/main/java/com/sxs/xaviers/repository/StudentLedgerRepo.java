package com.sxs.xaviers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxs.xaviers.domain.StudentLedger;

public interface StudentLedgerRepo extends JpaRepository<StudentLedger, Long> {	
	
	StudentLedger findByStudentId(long studentId);
}
