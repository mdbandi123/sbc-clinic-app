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
	public List<PatientReportDTO> getPatientReportData() {
	    CriteriaBuilder cb = em.getCriteriaBuilder();

	    CriteriaQuery<PatientReportDTO> sql = cb.createQuery(PatientReportDTO.class);

	    Root<Report> reportRoot = sql.from(Report.class);
	    Join<Report, Appointment> appointmentJoin = reportRoot.join("appointment", JoinType.INNER);
	    Join<Appointment, Patient> patientJoin = appointmentJoin.join("patient", JoinType.INNER);

	    sql.multiselect(
	        reportRoot.get("reportId"),             
	        appointmentJoin.get("appointmentId"),         
	        patientJoin.get("name"),           
	        patientJoin.get("icNo"),       
	        appointmentJoin.get("date"),        
	        reportRoot.get("details")
	    );

		TypedQuery<PatientReportDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
	
	@Transactional
	public List<PatientReportDTO> getPatientReportDataByName(String name) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();

	    CriteriaQuery<PatientReportDTO> sql = cb.createQuery(PatientReportDTO.class);

	    Root<Report> reportRoot = sql.from(Report.class);
	    Join<Report, Appointment> appointmentJoin = reportRoot.join("appointment", JoinType.INNER);
	    Join<Appointment, Patient> patientJoin = appointmentJoin.join("patient", JoinType.INNER);

	    sql.multiselect(
	        reportRoot.get("reportId"),             
	        appointmentJoin.get("appointmentId"),         
	        patientJoin.get("name"),           
	        patientJoin.get("icNo"),       
	        appointmentJoin.get("date"),        
	        reportRoot.get("details")
	    ).where(cb.equal(patientJoin.get("name"), name));

		TypedQuery<PatientReportDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
	
	@Transactional
	public List<PatientReportDTO> getPatientReportDataByIcNo(String icno) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();

	    CriteriaQuery<PatientReportDTO> sql = cb.createQuery(PatientReportDTO.class);

	    Root<Report> reportRoot = sql.from(Report.class);
	    Join<Report, Appointment> appointmentJoin = reportRoot.join("appointment", JoinType.INNER);
	    Join<Appointment, Patient> patientJoin = appointmentJoin.join("patient", JoinType.INNER);

	    sql.multiselect(
	        reportRoot.get("reportId"),             
	        appointmentJoin.get("appointmentId"),         
	        patientJoin.get("name"),           
	        patientJoin.get("icNo"),       
	        appointmentJoin.get("date"),        
	        reportRoot.get("details")
	    ).where(cb.equal(patientJoin.get("icNo"), icno));

		TypedQuery<PatientReportDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
	
	@Transactional
	public List<PatientReportDTO> getPatientReportDataById(Integer id) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();

	    CriteriaQuery<PatientReportDTO> sql = cb.createQuery(PatientReportDTO.class);

	    Root<Report> reportRoot = sql.from(Report.class);
	    Join<Report, Appointment> appointmentJoin = reportRoot.join("appointment", JoinType.INNER);
	    Join<Appointment, Patient> patientJoin = appointmentJoin.join("patient", JoinType.INNER);

	    sql.multiselect(
	        reportRoot.get("reportId"),             
	        appointmentJoin.get("appointmentId"),         
	        patientJoin.get("name"),           
	        patientJoin.get("icNo"),       
	        appointmentJoin.get("date"),        
	        reportRoot.get("details")
	    ).where(cb.equal(reportRoot.get("reportId"), id));

		TypedQuery<PatientReportDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
}
