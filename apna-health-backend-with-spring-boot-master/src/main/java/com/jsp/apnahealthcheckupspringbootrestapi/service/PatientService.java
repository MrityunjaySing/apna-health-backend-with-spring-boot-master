package com.jsp.apnahealthcheckupspringbootrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.PatientDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private ResponseStructure<Patient> responseStructure;
	
	public ResponseStructure<Patient> savePatientService(int hospitalId, int nurseId,int doctorId, Patient patient){
		
		Patient patient2 = patientDao.savePatientDao(hospitalId, nurseId,doctorId, patient);
		
		if(patient2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Patient register successfully.........!");
			responseStructure.setStatusData(patient2);
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("please check hospital and nurse id.........!");
			responseStructure.setStatusData(patient2);
		}
		return responseStructure;
	}
	
}
