package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Report;
import org.acumen.training.codes.model.dto.PatientQueueReportDTO;
import org.acumen.training.codes.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@PostMapping("/insert/{appointmentId}")
	public boolean insertReport(@PathVariable Integer appointmentId, @RequestBody Report report) {
		return reportService.insertReport(appointmentId ,report);
	}
	
	@GetMapping("/details/name/{name}")
	public List<PatientQueueReportDTO> getPatientQueueReportData(@PathVariable String name){
		return reportService.getPatientQueueReportData(name);
	}
}
