package com.sxs.xaviers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxs.xaviers.domain.StudentLedger;
import com.sxs.xaviers.exception.ResourceNotFoundException;
import com.sxs.xaviers.services.StudentLedgerService;

@RestController
@RequestMapping(path = "/xaviers/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentLedgerController {

	@Autowired
	StudentLedgerService stdLedgerService;

	@GetMapping("/ledger/{id}")
	public ResponseEntity<StudentLedger> getDemandNoteOne(@PathVariable(value = "id") Long ledgerId)
			throws ResourceNotFoundException {
		StudentLedger studentLedger = stdLedgerService.fetchStudentLedgerById(ledgerId);
		return ResponseEntity.ok().body(studentLedger);
	}

	@PostMapping(path = "/ledger", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StudentLedger> saveLedger(@RequestBody StudentLedger stdLedger)
			throws ResourceNotFoundException {
		final StudentLedger record = stdLedgerService.save(stdLedger);
		return new ResponseEntity<StudentLedger>(record, HttpStatus.CREATED);
	}

	@GetMapping("/ledgerStudent/{studentId}")
	public ResponseEntity<List<StudentLedger>> getStdLedgerByStdId(@PathVariable(value = "studentId") Long studentId)
			throws ResourceNotFoundException {
		List<StudentLedger> listOfLedgerRecord = stdLedgerService.fetchStudentLedgerByStudentId(studentId);
		return ResponseEntity.ok().body(listOfLedgerRecord);
	}
	
	@GetMapping("/ledgerStudentAll")
	public ResponseEntity<List<StudentLedger>> getStdLedgerAll()
			throws ResourceNotFoundException {
		List<StudentLedger> listOfLedgerRecord = stdLedgerService.fetchStudentAll();
		return ResponseEntity.ok().body(listOfLedgerRecord);
	}
}
