package org.acumen.training.codes.service;

import java.net.MalformedURLException;

import org.acumen.training.codes.dao.MedicalCertificateDao;
import org.acumen.training.codes.model.MedicalCertificate;
import org.acumen.training.codes.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class MedicalCertificateService {
	
	@Autowired
	private MedicalCertificateDao medicalCertificateDao;
	
	@Autowired
	private PdfService pdfService;
	
	@Autowired
	private PatientService patientService;
	
	public byte[] insertMedicalCertificate(MedicalCertificate medicalCertificate) {
		Patient patient = (Patient) patientService.getPatientById(medicalCertificate.getFkPatientId()).toArray()[0];
		medicalCertificateDao.insertMedicalCerticate(medicalCertificate);
		try {
			return pdfService.generatePdf(medicalCertificate, patient);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
