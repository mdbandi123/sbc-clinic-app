package org.acumen.training.codes.dao;

import org.acumen.training.codes.model.MedicalCertificate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MedicalCertificateDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public boolean insertMedicalCerticate(MedicalCertificate medicalCertificate) {
		try {
			em.persist(medicalCertificate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
