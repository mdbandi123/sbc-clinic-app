package org.acumen.training.codes.service;

import org.acumen.training.codes.dao.MedicalCertificateDao;
import org.acumen.training.codes.model.MedicalCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class MedicalCertificateService {
	
	@Autowired
	private MedicalCertificateDao medicalCertificateDao;
	
	public boolean insertMedicalCertificate(MedicalCertificate medicalCertificate) {
		return medicalCertificateDao.insertMedicalCerticate(medicalCertificate);
	}
}
