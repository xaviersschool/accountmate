package com.sxs.xaviers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxs.xaviers.domain.FeeMaster;
import com.sxs.xaviers.exception.ResourceNotFoundException;
import com.sxs.xaviers.repository.FeeRepo;

@RestController
@RequestMapping(path = "/xaviers/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeeController {

	@Autowired
	FeeRepo feeRepo;

	@GetMapping("/fee/{month}")
	public ResponseEntity<FeeMaster> getStudentById(@PathVariable(value = "month") String month)
			throws ResourceNotFoundException {
		
		FeeMaster fee = feeRepo.findByMonth(month);
		
		return ResponseEntity.ok().body(fee);
	}
}
