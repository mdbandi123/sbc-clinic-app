package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/insert")
	public boolean insertPatient(@RequestBody Patient patient) {
		return patientService.insertPatient(patient);
	}
	
	@GetMapping("/details/id/{id}")
	public List<Patient> getPatientById(@PathVariable Integer id) {
		return patientService.getPatientById(id);
	}
	
	@GetMapping("/details/icno/{icno}")
	public List<Patient> getPatientByIcNo(@PathVariable String icno) {
		return patientService.getPatientByIcNo(icno);
	}
	
	@GetMapping("/details/name/{name}")
	public List<Patient> getPatientByName(@PathVariable String name) {
		return patientService.getPatientByName(name);
	}
	
	@PatchMapping("/update/{id}")
	public boolean updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}
}
