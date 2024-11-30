package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Report;
import org.acumen.training.codes.model.dto.PatientReportDTO;
import org.acumen.training.codes.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@CrossOrigin(
	    origins = "http://localhost:5173",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE},
	    allowCredentials = "true"
	)
public class ReportController {

	@Autowired
	private ReportService reportService;

	@PostMapping("/insert/{appointmentId}")
	public boolean insertReport(@PathVariable Integer appointmentId, @RequestBody Report report) {
		return reportService.insertReport(appointmentId, report);
	}

	@GetMapping("/details/list/all")
	public List<PatientReportDTO> getPatientReportData() {
		return reportService.getPatientReportData();
	}

	@GetMapping("/details/name/{name}")
	public List<PatientReportDTO> getPatientReportDataByName(@PathVariable String name) {
		return reportService.getPatientReportDataByName(name);
	}

	@GetMapping("/details/id/{id}")
	public List<PatientReportDTO> getPatientReportDataById(@PathVariable Integer id) {
		return reportService.getPatientReportDataById(id);
	}

	@GetMapping("/details/icno/{icno}")
	public List<PatientReportDTO> getPatientReportDataByIcNo(@PathVariable String icno) {
		return reportService.getPatientReportDataByIcNo(icno);
	}
}
