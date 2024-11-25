package org.acumen.training.codes.service;

import java.util.List;

import org.acumen.training.codes.dao.ReportDao;
import org.acumen.training.codes.model.Report;
import org.acumen.training.codes.model.dto.PatientQueueReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	
	@Autowired 
	private ReportDao reportDao;
	
	public boolean insertReport(Report report) {
		return reportDao.insertReport(report);
	}
	
	public List<PatientQueueReportDTO> getPatientQueueReportData(String name){
		return reportDao.getPatientQueueReportData(name);
	}
}
