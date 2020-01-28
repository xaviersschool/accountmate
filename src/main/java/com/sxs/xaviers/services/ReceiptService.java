package com.sxs.xaviers.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxs.xaviers.domain.Receipt;
import com.sxs.xaviers.domain.StudentLedger;
import com.sxs.xaviers.repository.ReceiptRepo;
import com.sxs.xaviers.repository.StudentLedgerRepo;

@Service
public class ReceiptService {

	@Autowired
	ReceiptRepo receiptRepo;
	
	@Autowired
	StudentLedgerRepo stdLedgerRepo;
	
	@Transactional(readOnly = true)
	public Page<Receipt> findAll(Pageable pageable) {
		return receiptRepo.findAll(pageable);
	}
	
	public Receipt save(Receipt receipt) {
		StudentLedger stdLedger = new StudentLedger();
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		List<StudentLedger> listOfStdLedger = stdLedgerRepo.fetchStudentAll();
		
		// need to replace with single get entity
		Map<Long, Long> stdLedgerMap = listOfStdLedger.stream()
				.collect(Collectors.toMap(StudentLedger::getStudentId, StudentLedger::getDue));
		
		long totalFee = receipt.getAddmissionKit()+ receipt.getAdmissionFee()+receipt.getExam()+receipt.getFestival()+receipt.getGenerator()
		+receipt.getLateFee()+receipt.getMiscelllaneous()+receipt.getOthers()+stdLedgerMap.get(receipt.getStudent_id())+receipt.getProspectus()+receipt.getTutionFee();
						
		stdLedger.setAddmissionKit(receipt.getAddmissionKit());
		stdLedger.setDate(now.format(formatter));
		stdLedger.setDue(totalFee - receipt.getReceivedAmount());//to be calculated
		stdLedger.setExam(receipt.getExam());
		stdLedger.setFestival(receipt.getFestival());
		stdLedger.setGenerator(receipt.getGenerator());
		stdLedger.setLateFee(receipt.getLateFee());
		stdLedger.setMiscelllaneous(receipt.getMiscelllaneous());
		stdLedger.setMonth(now.getMonth().toString().toLowerCase());
		stdLedger.setOthers(receipt.getOthers());
		stdLedger.setPaid(receipt.getReceivedAmount());
		stdLedger.setProspectus(receipt.getProspectus());
		stdLedger.setStudentId(receipt.getStudent_id());
		stdLedger.setTutionFee(receipt.getTutionFee());		
		stdLedgerRepo.save(stdLedger);		
		return receiptRepo.save(receipt);
	}
	
	public List<Receipt> findByMonth(String month) {		
		return receiptRepo.findByMonth(month);
	}
	
	public List<Receipt> findByDate(String date) {		
		return receiptRepo.findByDate(date);
	}
}
