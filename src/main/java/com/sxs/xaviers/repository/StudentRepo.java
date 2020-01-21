package com.sxs.xaviers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxs.xaviers.domain.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
