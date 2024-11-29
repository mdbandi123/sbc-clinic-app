package org.acumen.training.codes.controller;

import org.acumen.training.codes.model.MedicalCertificate;
import org.acumen.training.codes.service.MedicalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<byte[]> insertMedicalCertificate(@RequestBody MedicalCertificate medicalCertificate) {
		byte[] pdfContent = medicalCertificateService.insertMedicalCertificate(medicalCertificate);
		 
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=MedicalCertificate.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
        
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContent);
	}
}
