package com.sxs.xaviers.endpoint;

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

	@GetMapping("/fee/{feeid}")
	public ResponseEntity<FeeMaster> getStudentById(@PathVariable(value = "feeid") Long feeId)
			throws ResourceNotFoundException {
		
		FeeMaster fee = feeRepo.findByFeeId(feeId);
		
		return ResponseEntity.ok().body(fee);
	}
}
