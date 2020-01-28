package com.sxs.xaviers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sxs.xaviers.domain.StudentLedger;

@Repository
public interface StudentLedgerRepo extends JpaRepository<StudentLedger, Long> {

	List<StudentLedger> findByStudentId(long studentId);

	List<StudentLedger> findByStudentIdAndMonth(long studentId, String Month);

	@Query(value = "SELECT t1.*FROM student_ledger t1 WHERE t1.date = (SELECT MAX(t2.date) FROM student_ledger t2 WHERE t2.student_id = t1.student_id)", nativeQuery = true)
	List<StudentLedger> fetchStudentAll();
}
