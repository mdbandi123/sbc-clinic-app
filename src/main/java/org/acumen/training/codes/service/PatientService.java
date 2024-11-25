package org.acumen.training.codes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.acumen.training.codes.dao.PatientDao;
import org.acumen.training.codes.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;
	
	public boolean insertPatient(Patient patient) {
		patient.setRegistrationTime(LocalDateTime.now());
		return patientDao.insertPatient(patient);
	}
	
	public List<Patient> getPatientById(Integer id) {
		return patientDao.getPatientById(id);
	}
	
	public List<Patient> getPatientByIcNo(String icNo) {
		return patientDao.getPatientByIcNo(icNo);
	}
	
	public List<Patient> getPatientByName(String name) {
		return patientDao.getPatientByName(name);
	}
	
	public boolean updatePatient(Integer id, Patient patient) {
		return patientDao.updatePatient(id, patient);
	}
}
