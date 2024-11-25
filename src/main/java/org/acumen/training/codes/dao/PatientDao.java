package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class PatientDao {

	@PersistenceContext
	EntityManager em;
		
	@Transactional
	public boolean insertPatient(Patient patient) {
		try {
			em.persist(patient);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public List<Patient> getPatientById(Integer id) {
		List<Patient> records = new ArrayList<>();
		Patient patient = em.find(Patient.class, id);
		records.add(patient);
		return records;
	}
	
	@Transactional
	public List<Patient> getPatientByIcNo(String icNo) {
		List<Patient> records = new ArrayList<>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> sql = cb.createQuery(Patient.class);
		Root<Patient> root = sql.from(Patient.class);
		
		sql.select(root).where(cb.equal(root.get("icNo"), icNo));
		
		TypedQuery<Patient> query = em.createQuery(sql);
		records = query.getResultList();
		
		return records;
	}
	
	@Transactional
	public List<Patient> getPatientByName(String name) {
		List<Patient> records = new ArrayList<>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> sql = cb.createQuery(Patient.class);
		Root<Patient> root = sql.from(Patient.class);
		
		sql.select(root).where(cb.equal(root.get("name"), name));
		
		TypedQuery<Patient> query = em.createQuery(sql);
		records = query.getResultList();
		
		return records;
	}
	
	@Transactional
	public boolean updatePatient(Integer id, Patient newPatientDetails) {
		try {
			Patient patient = em.find(Patient.class, id);
			
			patient.setName(newPatientDetails.getName());
			patient.setIcNo(newPatientDetails.getIcNo());
			patient.setGender(newPatientDetails.getGender());
			patient.setAddress(newPatientDetails.getAddress());
			patient.setContactNo(newPatientDetails.getContactNo());
			patient.setProfileImage(newPatientDetails.getProfileImage());
			
			em.merge(patient);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
