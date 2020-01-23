package com.sxs.xaviers.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sxs.xaviers.domain.Student;
import com.sxs.xaviers.domain.Student_AddInfo;

public class DataUploader {

	static Student tempStd = null;
	static Student_AddInfo tempStdAdd = null;

	public static List<Student> excelToList(String fileName) {

		List<Student> listOfStudent = new ArrayList<Student>();

		// fileName = "C:\\Users\\deepak.k\\Downloads\\test.csv";
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());

			values.forEach(value -> {

				tempStd = new Student();
				tempStdAdd = new Student_AddInfo();

				tempStd.setId(0);
				tempStd.setAdmission_no(Long.parseLong(value.get(1)));
				tempStd.setDateOfAdmission(value.get(2));
				tempStd.setLadgerNo(Long.parseLong(value.get(3)));
				tempStd.setStudent_name(value.get(4));
				tempStdAdd.setFatherName(value.get(5));
				tempStdAdd.setMotherName(value.get(6));
				tempStd.setSex(value.get(7));
				tempStdAdd.setVillage(value.get(8));
				tempStd.setDate_of_birth(value.get(9));
				tempStd.setStudent_class(Integer.parseInt(value.get(10)));
				tempStdAdd.setCatagory(value.get(11));
				tempStdAdd.setCaste(value.get(12));
				tempStdAdd.setAadharNo(value.get(13));
				tempStdAdd.setContNo(value.get(14));

				tempStd.setStdAddInfo(tempStdAdd);
				listOfStudent.add(tempStd);

			});

			//System.out.println(listOfStudent.size() + ">>>>>>>>>>" + listOfStudent.get(0).getDateOfAdmission());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOfStudent;
	}

}
