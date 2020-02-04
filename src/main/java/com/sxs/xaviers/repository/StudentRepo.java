package com.sxs.xaviers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxs.xaviers.domain.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	
	public Optional<Student> findById(Long id);
}
