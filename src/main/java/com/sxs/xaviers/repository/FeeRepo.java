package com.sxs.xaviers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxs.xaviers.domain.FeeMaster;

public interface FeeRepo extends JpaRepository<FeeMaster, Long> {

	FeeMaster findByFeeId(Long feeId);
	
	FeeMaster findByMonth(String month);

}
