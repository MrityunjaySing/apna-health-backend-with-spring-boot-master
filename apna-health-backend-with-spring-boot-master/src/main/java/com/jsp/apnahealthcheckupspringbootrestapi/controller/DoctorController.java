package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.DoctorService;

@RestController
public class DoctorController {
   
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping(value = "/saveDoctor/{hospitalId}")
	public ResponseStructure<Doctor> saveDoctorController(@PathVariable int hospitalId,@RequestBody Doctor doctor){
		return doctorService.saveDoctorService(hospitalId, doctor);
	}
}
