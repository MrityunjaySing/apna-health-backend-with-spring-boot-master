package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.DoctorRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.HospitalRepository;

@Repository
public class DoctorDao {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public Doctor saveDoctorDao(int hospitalId, Doctor doctor) {
		Hospital hospital = hospitalRepository.findByHospitalId(hospitalId);
		
		if(hospital != null) {
			doctor.setHospital(hospital);
			return doctorRepository.save(doctor);
		}
		else {
			return null;
		}
	}
	
}
