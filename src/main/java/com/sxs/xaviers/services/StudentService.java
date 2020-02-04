package com.sxs.xaviers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxs.xaviers.domain.Student;
import com.sxs.xaviers.repository.StudentRepo;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Transactional(readOnly = true)
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	//@Transactional(readOnly = true)
	public Optional<Student> findOne(Long id) {
		return studentRepo.findById(id);
	}

	public Student save(Student student) {
		return studentRepo.saveAndFlush(student);
	}
	
	public void saveAll(List<Student> entities) {
		 studentRepo.saveAll(entities);
	}

	

}
