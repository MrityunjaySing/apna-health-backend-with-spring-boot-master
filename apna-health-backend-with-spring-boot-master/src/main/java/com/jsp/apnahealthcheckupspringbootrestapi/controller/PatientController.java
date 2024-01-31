package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.PatientService;

@RestController
public class PatientController {
  
	@Autowired
	private PatientService patientService;
	
	@PostMapping(value = "/savePatient/{hospitalId}/{nurseId}/{doctorId}")
	public ResponseStructure<Patient> savePatientController(@PathVariable int hospitalId, @PathVariable int nurseId,@PathVariable int doctorId,  @RequestBody Patient patient){
		return patientService.savePatientService(hospitalId, nurseId,doctorId, patient);
	}
}
