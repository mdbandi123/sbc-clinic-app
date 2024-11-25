package org.acumen.training.codes.dao;

import java.util.List;

import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.dto.AppointmentPatientDTO;
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
public class AppointmentDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public boolean insertAppointment(Appointment appointment) {
		try {
			em.persist(appointment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public Appointment getAppointmentById(Integer id) {
		return em.find(Appointment.class, id);
	}
	
	@Transactional
	public List<AppointmentPatientDTO> getAppointmentsByName(String name){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AppointmentPatientDTO> sql = cb.createQuery(AppointmentPatientDTO.class);

		Root<Appointment> appointmentRoot = sql.from(Appointment.class);
		Join<Appointment, Patient> patientJoin = appointmentRoot.join("patient", JoinType.INNER);

		sql.multiselect(patientJoin.get("name"),
				patientJoin.get("icNo"), 
				appointmentRoot.get("date"), 
				appointmentRoot.get("remark")
		).where(cb.equal(patientJoin.get("name"), name));

		TypedQuery<AppointmentPatientDTO> typedQuery = em.createQuery(sql);
		return typedQuery.getResultList();
	}
	
	@Transactional
	public boolean updateAppointmentArrivalStatus(Integer id, Appointment newAppointmentDetails) {
		try {
			Appointment appointment = em.find(Appointment.class, id);
			appointment.setIsArrival(newAppointmentDetails.getIsArrival());
			em.merge(appointment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean updateAppointmentConfirmationStatus(Integer id, Appointment newAppointmentDetails) {
		try {
			Appointment appointment = em.find(Appointment.class, id);
			appointment.setIsConfirmed(newAppointmentDetails.getIsConfirmed());
			em.merge(appointment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
