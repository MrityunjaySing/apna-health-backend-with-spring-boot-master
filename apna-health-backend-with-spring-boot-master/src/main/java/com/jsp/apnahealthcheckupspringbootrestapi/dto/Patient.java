package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	@Id
	private int id;
	private String name;
	private String diseasesType;
	private int age;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PatientDoctor",
			joinColumns = {@JoinColumn(name="patientId")},
			inverseJoinColumns = {@JoinColumn(name="doctorId")}
			)
	private List<Doctor> doctors;

	@ManyToOne
	@JoinColumn(name = "hospitalid")
	private Hospital hospital;

	@ManyToOne
	@JoinColumn(name = "nurseId")
	private Nurse nurse;
}
