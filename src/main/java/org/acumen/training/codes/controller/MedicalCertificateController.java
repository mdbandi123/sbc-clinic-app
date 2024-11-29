package org.acumen.training.codes.controller;

import org.acumen.training.codes.model.MedicalCertificate;
import org.acumen.training.codes.service.MedicalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical-certificate")
@CrossOrigin
public class MedicalCertificateController {
	
	@Autowired
	private MedicalCertificateService medicalCertificateService;
	
	@PostMapping("/insert")
	public boolean insertMedicalCertificate(@RequestBody MedicalCertificate medicalCertificate) {
		return medicalCertificateService.insertMedicalCertificate(medicalCertificate);
	}
}
