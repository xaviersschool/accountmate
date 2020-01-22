package com.sxs.xaviers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxs.xaviers.domain.Receipt;

public interface ReceiptRepo extends JpaRepository<Receipt, Long>{

	List<Receipt> findByMonth(String month);
	
	List<Receipt> findByDate(String date);
	
}
