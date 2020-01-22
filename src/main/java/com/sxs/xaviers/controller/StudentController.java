package com.sxs.xaviers.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxs.xaviers.domain.Student;
import com.sxs.xaviers.exception.ResourceNotFoundException;
import com.sxs.xaviers.services.StudentService;

@RestController
@RequestMapping(path = "/xaviers/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping(path = "/student", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Student> createStudent(@RequestBody Student stdDetails) throws ResourceNotFoundException {		
		final Student updateStudent = studentService.save(stdDetails);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.CREATED);
	}

	
	@PutMapping(path = "/student", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Student> updateStudent(@RequestBody Student stdDetails) throws ResourceNotFoundException {		
		final Student updateStudent = studentService.save(stdDetails);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		Optional<Student> student = studentService.findOne(studentId);
		return ResponseEntity.ok().body(student.get());
	}

}
