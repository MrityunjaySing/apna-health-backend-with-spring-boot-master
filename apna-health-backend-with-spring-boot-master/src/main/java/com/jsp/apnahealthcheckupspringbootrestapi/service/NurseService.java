package com.jsp.apnahealthcheckupspringbootrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.NurseDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Nurse;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;

@Service
public class NurseService {

	@Autowired
	private NurseDao dao;
	
	@Autowired
	private ResponseStructure<Nurse> responseStructure;
	
	public ResponseStructure<Nurse> saveNurseService(int hospitalId, Nurse nurse){
		
		Nurse nurse2 = dao.saveNurseDao(hospitalId, nurse);
		
		if(nurse2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Nurse register successfully.........!");
			responseStructure.setStatusData(nurse2);
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("please check hospital id.........!");
			responseStructure.setStatusData(nurse2);
		}
		return responseStructure;
	}
}
