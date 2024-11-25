package org.acumen.training.codes.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.Queue;
import org.acumen.training.codes.model.dto.QueuePatientDTO;
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
public class QueueDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public List<QueuePatientDTO> getQueueOfPatients() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<QueuePatientDTO> sql = cb.createQuery(QueuePatientDTO.class);

		Root<Queue> queueRoot = sql.from(Queue.class);
		Join<Queue, Patient> patientJoin = queueRoot.join("patient", JoinType.INNER);

		sql.multiselect(patientJoin.get("name"),
				patientJoin.get("icNo"), 
				queueRoot.get("startTime"), 
				queueRoot.get("endTime"),
				queueRoot.get("type")
		);

		TypedQuery<QueuePatientDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
	
	@Transactional
	public boolean insertToQueue(Queue queue) {
		try {
			em.persist(queue); 
			return true;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean updateQueueType(Integer id, String type) {
		try {
			Queue queue = em.find(Queue.class, id);
			queue.setType(type);
			em.merge(queue);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean updateCheckIn(Integer id, Boolean isCheckedIn, LocalDateTime endTime) {
		try {
			Queue queue = em.find(Queue.class, id);
			queue.setCheckIn(isCheckedIn);
			queue.setEndTime(endTime);
			em.merge(queue);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
