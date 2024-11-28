package org.acumen.training.codes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.acumen.training.codes.dao.ReportDao;
import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.Report;
import org.acumen.training.codes.model.dto.PatientReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	private ReportDao reportDao;

	@Autowired
	private AppointmentService appointmentService;

	public boolean insertReport(Integer appointmentId, Report report) {
		Appointment appointment = new Appointment();
		report.setDate(LocalDateTime.now());
		Integer reportId = reportDao.insertReport(report);
		appointment.setFkReportId(reportId);
		return appointmentService.updateAppointmentReportId(appointmentId, appointment);
	}

	public List<PatientReportDTO> getPatientQueueReportData() {
		return reportDao.getPatientQueueReportData();
	}
}
