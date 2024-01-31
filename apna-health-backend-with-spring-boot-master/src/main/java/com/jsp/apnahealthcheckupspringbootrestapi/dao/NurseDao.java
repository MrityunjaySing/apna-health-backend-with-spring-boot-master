package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Nurse;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.HospitalRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.NurseRepository;

@Repository
public class NurseDao {
     
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public Nurse saveNurseDao(int hospitalId , Nurse nurse) {
		
		Hospital hospital = hospitalRepository.findByHospitalId(hospitalId);
		if(hospital != null) {
			nurse.setHospital(hospital);
			
			return nurseRepository.save(nurse);
		}
		else {
			return null;
		}
	}
}
