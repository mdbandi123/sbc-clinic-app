package org.acumen.training.codes.dao;

import java.util.List;

import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.Queue;
import org.acumen.training.codes.model.Report;
import org.acumen.training.codes.model.dto.PatientQueueReportDTO;
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
	public boolean insertReport(Report report) {
		try { 
			em.persist(report);
			return true;
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Transactional
	public List<PatientQueueReportDTO> getPatientQueueReportData(String name) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<PatientQueueReportDTO> query = cb.createQuery(PatientQueueReportDTO.class);

	    // Root for Patient entity
	    Root<Patient> patientRoot = query.from(Patient.class);

	    // Join Patient -> Queue -> Report (Patient -> Queue -> Report)
	    Join<Patient, Queue> queueJoin = patientRoot.join("queues", JoinType.INNER);
	    Join<Queue, Report> reportJoin = queueJoin.join("report", JoinType.INNER);

	    // Define the select clause (projection)
	    query.select(cb.construct(
	        PatientQueueReportDTO.class,
	        patientRoot.get("name"),        // patientName
	        patientRoot.get("icNo"),        // patientIcNo
	        queueJoin.get("checkIn"),       // queueCheckIn
	        queueJoin.get("type"),          // queueType
	        queueJoin.get("startTime"),     // queueStartTime
	        queueJoin.get("endTime"),       // queueEndTime
	        reportJoin.get("details")       // reportDetails
	    )).where(cb.equal(patientRoot.get("name"), name));

	    // Execute the query
	    TypedQuery<PatientQueueReportDTO> typedQuery = em.createQuery(query);
	    return typedQuery.getResultList();
	}

}
