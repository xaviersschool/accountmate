package com.sxs.xaviers.services;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxs.xaviers.domain.Student;
import com.sxs.xaviers.domain.Student_AddInfo;
import com.sxs.xaviers.repository.StudentRepo;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Transactional(readOnly = true)
	public Page<Student> findAll(Pageable pageable) {
		return studentRepo.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Optional<Student> findOne(Long id) {
		return studentRepo.findById(id);
	}

	public Student save(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	public Student createOrUpdateEmployee(Student entity) {

		Optional<Student> student = studentRepo.findById(entity.getId());

		if (student.isPresent()) {
			Student newEntity = student.get();

			Student_AddInfo stdAddInfo = new Student_AddInfo();
			try {
				BeanUtils.copyProperties(stdAddInfo, entity.getStdAddInfo());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newEntity = studentRepo.save(newEntity);
			return newEntity;
		} else {
			
			
			
			Student temp = new Student();
			temp.setSex("MALE");
			temp.setDateOfAdmission("25/06/2018");
			temp.setLadgerNo(123);
			temp.setAdmission_no(4646);
			temp.setStudent_class(1);
			Student_AddInfo stdAddInfo = new Student_AddInfo();
			
			stdAddInfo.setAadharNo("XXXXXXXXX");
			stdAddInfo.setCaste("test");
			stdAddInfo.setCatagory("test");
			stdAddInfo.setContNo("87098009809");
			stdAddInfo.setFatherName("father name");
			stdAddInfo.setMotherName("mother name");
			stdAddInfo.setVillage("village");
			temp.setStdAddInfo(stdAddInfo);
			entity = temp;
			
			entity = studentRepo.save(entity);
			return entity;
		}
	}

}
