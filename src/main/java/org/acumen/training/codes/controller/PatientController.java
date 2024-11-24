package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.dao.PatientDao;
import org.acumen.training.codes.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
	@GetMapping(path = "/test")
	public String testGet() {
		return "patient get working";
	}
	
	@GetMapping(path = "/list/all")
	public List<Patient> getAllPatients(){
		return patientDao.getAllPatients();
	}
}
