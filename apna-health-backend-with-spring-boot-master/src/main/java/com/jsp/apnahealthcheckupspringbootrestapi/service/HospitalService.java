package com.jsp.apnahealthcheckupspringbootrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.HospitalDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@Service
public class HospitalService {
   
	@Autowired
	private HospitalDao dao;
	
	@Autowired
	private ResponseStructure<Hospital> responseStructure;
	
	@Autowired
	private HttpSession httpSession;
	
	/***
	 * 
	 */
	 public ResponseStructure<Hospital> saveHospitalService(Hospital hospital) {
		 
		 if(httpSession.getAttribute("adminEmail") != null) {
			 dao.saveHospitalDao(hospital);
			 responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			 responseStructure.setStatusMessage("Hospital---is---added");
			 responseStructure.setStatusData(hospital);
		 }
		 else {
			 responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			 responseStructure.setStatusMessage("please---login---with---Admin");
			 responseStructure.setStatusData(hospital);
		 }
		 return responseStructure;
		 
	 }
}
