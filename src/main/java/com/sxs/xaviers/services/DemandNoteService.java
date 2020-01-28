package com.sxs.xaviers.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxs.xaviers.domain.FeeMaster;
import com.sxs.xaviers.domain.Student;
import com.sxs.xaviers.domain.StudentLedger;
import com.sxs.xaviers.repository.FeeRepo;
import com.sxs.xaviers.repository.StudentLedgerRepo;
import com.sxs.xaviers.repository.StudentRepo;
import com.sxs.xaviers.vo.DemandNote;

@Service
public class DemandNoteService {
	
	@Autowired
	FeeRepo feeRepo;
	
	@Autowired
	StudentRepo stdRepo;
	
	@Autowired
	StudentLedgerRepo stdLedgerRepo;

	public DemandNote generateDemandNoteStudentOne(Long studentId, String month) {

		LocalDate currentdate = LocalDate.now();
		// if(currentdate.getMonth().)

		FeeMaster feeForMonth = feeRepo.findByMonth(month);

		Student stdInfo = stdRepo.getOne(studentId);
		
		List<StudentLedger> listOfStdLedger = stdLedgerRepo.fetchStudentAll();
		Map<Long, Long> stdLedgerMap = listOfStdLedger.stream()
				.collect(Collectors.toMap(StudentLedger::getStudentId, StudentLedger::getDue));

		
		System.out.println(listOfStdLedger);
		DemandNote demandNoteOne = new DemandNote();

		demandNoteOne.setAddmissionKit(feeForMonth.getAddmissionKit());
		demandNoteOne.setAdmissionFee(feeForMonth.getAdmissionFee());
		demandNoteOne.setExam(feeForMonth.getExam());
		demandNoteOne.setFatherName(stdInfo.getStdAddInfo().getFatherName());
		demandNoteOne.setFestival(feeForMonth.getFestival());
		demandNoteOne.setGenerator(feeForMonth.getGenerator());
		demandNoteOne.setLadgerNo(stdInfo.getLadgerNo());
		demandNoteOne.setLateFee(feeForMonth.getLateFee());
		demandNoteOne.setMiscelllaneous(feeForMonth.getMiscelllaneous());
		demandNoteOne.setMonth(month);
		demandNoteOne.setStudent_id(stdInfo.getId());
		demandNoteOne.setOthers(feeForMonth.getOthers());
		demandNoteOne.setPreviousDue(stdLedgerMap.get(stdInfo.getId()));// previous due will come from ledger
		demandNoteOne.setProspectus(feeForMonth.getProspectus());
		demandNoteOne.setStudent_class(stdInfo.getStudent_class());
		demandNoteOne.setStudentName(stdInfo.getStudent_name());
		demandNoteOne.setTutionFee(feeForMonth.getTutionFee());
		
		long totalDueFee = feeForMonth.getAddmissionKit() + feeForMonth.getAdmissionFee() + feeForMonth.getExam()
		+ feeForMonth.getFestival() + feeForMonth.getGenerator() + feeForMonth.getLateFee()
		+ feeForMonth.getMiscelllaneous() + feeForMonth.getOthers() + feeForMonth.getProspectus()
		+ feeForMonth.getProspectus() + feeForMonth.getTutionFee();

		demandNoteOne.setTotal(totalDueFee);
		demandNoteOne.setPaymentDueDate("20-"+month+"-"+currentdate.getYear());
		

		return demandNoteOne;
	}

	public List<DemandNote> generateDemandNoteStudentAll(String month) {

		//List<DemandNote> listOfDemandNotAll = new ArrayList<DemandNote>();
		LocalDate currentdate = LocalDate.now();
		FeeMaster feeForMonth = feeRepo.findByMonth(month);
		
		List<Student> listOfStd = stdRepo.findAll();
		
		List<StudentLedger> listOfStdLedger = stdLedgerRepo.fetchStudentAll();
		Map<Long, Long> stdLedgerMap = listOfStdLedger.stream()
				.collect(Collectors.toMap(StudentLedger::getStudentId, StudentLedger::getDue));

		
		List<DemandNote> listOfDemandNotAll = listOfStd.stream().map(temp -> {

			DemandNote dmfNote = new DemandNote();

			dmfNote.setAddmissionKit(feeForMonth.getAddmissionKit());
			dmfNote.setAdmissionFee(feeForMonth.getAdmissionFee());
			dmfNote.setExam(feeForMonth.getExam());
			dmfNote.setFatherName(temp.getStdAddInfo().getFatherName());
			dmfNote.setFestival(feeForMonth.getFestival());
			dmfNote.setGenerator(feeForMonth.getGenerator());
			dmfNote.setLadgerNo(temp.getLadgerNo());
			dmfNote.setLateFee(feeForMonth.getLateFee());
			dmfNote.setMiscelllaneous(feeForMonth.getMiscelllaneous());
			dmfNote.setMonth(month);
			dmfNote.setStudent_id(temp.getId());
			dmfNote.setOthers(feeForMonth.getOthers());
			//************* Fetch Due date from ledger - START 	
			
			dmfNote.setPreviousDue(stdLedgerMap.get(temp.getId()));// need to fetch from ledger
			//************* Fetch Due date from ledger - END			
			dmfNote.setProspectus(feeForMonth.getProspectus());
			dmfNote.setStudent_class(temp.getStudent_class());
			dmfNote.setStudentName(temp.getStudent_name());
			dmfNote.setTutionFee(feeForMonth.getTutionFee());
			
			long totalDueFee = feeForMonth.getAddmissionKit() + feeForMonth.getAdmissionFee() + feeForMonth.getExam()
					+ feeForMonth.getFestival() + feeForMonth.getGenerator() + feeForMonth.getLateFee()
					+ feeForMonth.getMiscelllaneous() + feeForMonth.getOthers() + feeForMonth.getProspectus()
					+ feeForMonth.getProspectus() + feeForMonth.getTutionFee();
			
			dmfNote.setTotal(totalDueFee);
			dmfNote.setPaymentDueDate("20-"+month+"-"+currentdate.getYear());

			return dmfNote;
		}).collect(Collectors.toList());
		
		return listOfDemandNotAll;
	}
	
	public List<DemandNote> generateDemandNoteStudentClass(int student_class) {

		return null;
	}

	public enum Month {
		JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),
		NOVEMBER(11), DECEMBER(12);
		private final int number;
		Month(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}
}
