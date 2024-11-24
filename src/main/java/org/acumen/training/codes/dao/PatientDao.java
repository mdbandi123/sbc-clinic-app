package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.Queue;
import org.acumen.training.codes.model.dto.PatientQueueDTO;
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
public class PatientDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public List<Patient> getAllPatients(){
		List<Patient> records = new ArrayList<>();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery sql = builder.createQuery(Patient.class);
		Root<Patient> from = sql.from(Patient.class);
		
		sql.select(from);
		
		TypedQuery<Patient> query = em.createQuery(sql);
		records = query.getResultList();
		
		return records;
	}
	
	@Transactional
	public List<PatientQueueDTO> getJoinSample(){
		// 1. Get the CriteriaBuilder
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<PatientQueueDTO> query = cb.createQuery(PatientQueueDTO.class);

	    // 3. Define the roots (entities) of the query
	    Root<Queue> queueRoot = query.from(Queue.class);
	    Join<Queue, Patient> patientJoin = queueRoot.join("patient", JoinType.INNER);  // Join Queue to Patient

	    // 4. Select specific columns from both entities
	    query.multiselect(
	        patientJoin.get("name"),       // Patient.name
	        patientJoin.get("icNo"),       // Patient.icNo
	        queueRoot.get("startTime"),    // Queue.startTime
	        queueRoot.get("endTime"),      // Queue.endTime
	        queueRoot.get("type")          // Queue.type
	    );

	    // 5. Define the condition (WHERE clause)
//	    Predicate startTimeCondition = cb.greaterThan(queueRoot.get("startTime"), startTime);
//	    query.where(startTimeCondition);

	    // 6. Execute the query and return the result
	    TypedQuery<PatientQueueDTO> typedQuery = em.createQuery(query);
	    return typedQuery.getResultList();
	}
	
	
}
