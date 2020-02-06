package com.sxs.xaviers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxs.xaviers.exception.ResourceNotFoundException;
import com.sxs.xaviers.services.DemandNoteService;
import com.sxs.xaviers.vo.DemandNote;

@RestController
@RequestMapping(path = "/xaviers/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class DemandNoteController {

	@Autowired
	DemandNoteService demandNoteService;

	@GetMapping("/demandnote/{studentId}/{month}")
	public ResponseEntity<DemandNote> getDemandNoteOne(@PathVariable(value = "studentId") Long studentId,
			@PathVariable(value = "month") String month) throws ResourceNotFoundException {
		DemandNote demandNote = demandNoteService.generateDemandNoteStudentOne(studentId, month);
		return ResponseEntity.ok().body(demandNote);
	}

	@GetMapping("/demandnote/{month}")
	public ResponseEntity<List<DemandNote>> getDemandNoteAll(@PathVariable(value = "month") String month)
			throws ResourceNotFoundException {
		List<DemandNote> listOfDemandNote = demandNoteService.generateDemandNoteStudentAll(month);
		return ResponseEntity.ok().body(listOfDemandNote);
	}
	

}
