package com.sxs.xaviers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<StudentLedger> findAll() {
		return studentLedgerRepo.findAll();
	}
	
	public StudentLedger save(StudentLedger stdLedger) {		
		return studentLedgerRepo.save(stdLedger);
	}
	
	public StudentLedger fetchStudentLedgerById(Long id) {
		return studentLedgerRepo.getOne(id);
	}
	
	public List<StudentLedger> fetchStudentLedgerByStudentId(Long StdId) {
		return studentLedgerRepo.findByStudentId(StdId);
	}
	
	public List<StudentLedger> fetchStdLedgerByStdIdAndMonth(Long stdId, String month) {
		return studentLedgerRepo.findByStudentIdAndMonth(stdId, month);
	}
	
	public List<StudentLedger> fetchStudentAll() {
		return studentLedgerRepo.fetchStudentAll();
	}
}
