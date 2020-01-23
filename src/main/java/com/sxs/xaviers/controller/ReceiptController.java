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

import com.sxs.xaviers.domain.Receipt;
import com.sxs.xaviers.exception.ResourceNotFoundException;
import com.sxs.xaviers.services.ReceiptService;

@RestController
@RequestMapping(path = "/xaviers/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptController {

	@Autowired
	ReceiptService receiptService;

	@PostMapping(path = "/receipt", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Receipt> generateReceipt(@RequestBody Receipt receipt) throws ResourceNotFoundException {
		final Receipt newReceipt = receiptService.save(receipt);
		return new ResponseEntity<Receipt>(newReceipt, HttpStatus.CREATED);
	}

	@GetMapping("/receipt/{month}")
	public ResponseEntity<List<Receipt>> getReceiptByMonth(@PathVariable(value = "month") String month)
			throws ResourceNotFoundException {
		List<Receipt> listOfReceipt = receiptService.findByMonth(month);
		return ResponseEntity.ok().body(listOfReceipt);
	}

	@GetMapping("/receipt/{date}")
	public ResponseEntity<List<Receipt>> getReceiptByDate(@PathVariable(value = "date") String date)
			throws ResourceNotFoundException {
		List<Receipt> listOfReceipt = receiptService.findByDate(date);
		return ResponseEntity.ok().body(listOfReceipt);
	}

}
