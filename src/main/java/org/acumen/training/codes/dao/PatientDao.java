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
	public List<Patient> getAllPatients(){
		List<Patient> records = new ArrayList<>();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery sql = builder.createQuery(Patient.class);
		Root<Patient> from = sql.from(Patient.class);
		
		sql.select(from);
		
		TypedQuery<Patient> query = em.createQuery(sql);
		records = query.getResultList();
		
		return records;
	}
}
