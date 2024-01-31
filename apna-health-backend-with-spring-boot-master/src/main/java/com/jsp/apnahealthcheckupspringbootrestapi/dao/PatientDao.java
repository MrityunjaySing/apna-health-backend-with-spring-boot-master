package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Nurse;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.DoctorRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.HospitalRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.NurseRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.PatientRepository;

@Repository
public class PatientDao {
   
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Patient savePatientDao(int hospitalId, int nurseId, int doctorId, Patient patient) {
		
		Hospital hospital = hospitalRepository.findByHospitalId(hospitalId);
		
		Nurse nurse = nurseRepository.findById(nurseId);
		
		Doctor doctor = doctorRepository.findById(doctorId);
		
		List<Doctor> doctors = new ArrayList<Doctor>(Arrays.asList(doctor));
		
		if(hospital !=null && nurse != null && doctor!= null) {
			
			patient.setHospital(hospital);
			patient.setNurse(nurse);
			patient.setDoctors(doctors);
			
			return patientRepository.save(patient);
		}
		else {
			return null;
		}
		
	}
}
