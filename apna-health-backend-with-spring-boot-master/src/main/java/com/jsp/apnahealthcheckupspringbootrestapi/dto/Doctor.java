package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
    private int id;
	private String name;
	private String doctorSpecialist;
	
	@ManyToOne
	private Hospital hospital;
	
	@ManyToMany(mappedBy = "doctors",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Patient> patients;
}
       