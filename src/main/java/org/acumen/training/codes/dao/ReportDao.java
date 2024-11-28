package org.acumen.training.codes.dao;

import java.util.List;

import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.Report;
import org.acumen.training.codes.model.dto.PatientReportDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class ReportDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Integer insertReport(Report report) {
		try { 
			em.persist(report);
			return report.getReportId();
		} catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Transactional
	public List<PatientReportDTO> getPatientQueueReportData() {
	    // Get the CriteriaBuilder
	    CriteriaBuilder cb = em.getCriteriaBuilder();

	    // Create CriteriaQuery
	    CriteriaQuery<PatientReportDTO> sql = cb.createQuery(PatientReportDTO.class);

	    // Define Root entities
	    Root<Report> reportRoot = sql.from(Report.class);
	    Join<Report, Appointment> appointmentJoin = reportRoot.join("appointment", JoinType.INNER);
	    Join<Appointment, Patient> patientJoin = appointmentJoin.join("patient", JoinType.INNER);

	    // Select the required fields
	    sql.multiselect(
	        reportRoot.get("reportId"),              // Report ID
	        appointmentJoin.get("appointmentId"),         // Appointment ID
	        patientJoin.get("name"),           // Patient Name
	        patientJoin.get("icNo"),           // IC Number
	        appointmentJoin.get("date"),        // Appointment Date
	        reportRoot.get("details")
	    );

	    // Optionally add filters (e.g., filtering by date or staff ID)
	    // query.where(cb.equal(...), cb.between(...), etc.);

	    // Execute the query
	    
		TypedQuery<PatientReportDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
}
