package com.sxs.xaviers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxs.xaviers.domain.Receipt;
import com.sxs.xaviers.repository.ReceiptRepo;

@Service
public class ReceiptService {

	@Autowired
	ReceiptRepo receiptRepo;
	
	@Transactional(readOnly = true)
	public Page<Receipt> findAll(Pageable pageable) {
		return receiptRepo.findAll(pageable);
	}
	
	public Receipt save(Receipt receipt) {
		return receiptRepo.saveAndFlush(receipt);
	}
	
	public List<Receipt> findByMonth(String month) {		
		return receiptRepo.findByMonth(month);
	}
	
	public List<Receipt> findByDate(String date) {		
		return receiptRepo.findByDate(date);
	}
}
