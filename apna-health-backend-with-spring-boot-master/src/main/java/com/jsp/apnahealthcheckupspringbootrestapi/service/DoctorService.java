package com.jsp.apnahealthcheckupspringbootrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.DoctorDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao dao;
	
	@Autowired
	private ResponseStructure<Doctor> responseStructure;
	
	public ResponseStructure<Doctor> saveDoctorService(int hospitalId, Doctor doctor) {
		Doctor doctor2 = dao.saveDoctorDao(hospitalId, doctor);
		
		if(doctor2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Doctor register successfully.........!");
			responseStructure.setStatusData(doctor2);
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Please check hospital id properly.......!");
			responseStructure.setStatusData(doctor2);
		}
		
		return responseStructure;
	}
}
