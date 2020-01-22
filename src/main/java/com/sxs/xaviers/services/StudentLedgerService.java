package com.sxs.xaviers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxs.xaviers.domain.StudentLedger;
import com.sxs.xaviers.repository.StudentLedgerRepo;

@Service
@Transactional
public class StudentLedgerService {

	@Autowired
	StudentLedgerRepo studentLedgerRepo;
	
	@Transactional(readOnly = true)
	public Page<StudentLedger> findAll(Pageable pageable) {
		return studentLedgerRepo.findAll(pageable);
	}
	
	public StudentLedger save(StudentLedger stdLedger) {
		return studentLedgerRepo.saveAndFlush(stdLedger);
	}
}
