package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
  
	   @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int hospitalId;
	   private String hospitalName;
	   private int numberOfbeds;
	   private int numberOfAmbulance;
	   
	   @OneToMany(mappedBy = "hospital")
	   @JsonIgnore
	   private  List<Doctor> doctors;
	   
	   @OneToMany(mappedBy = "hospital")
	   @JsonIgnore
	   private List<Nurse> nurses;
	   
	   @OneToMany(mappedBy = "hospital")
	   @JsonIgnore
	   private List<Patient> patients;
}
