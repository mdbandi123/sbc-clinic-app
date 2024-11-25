package org.acumen.training.codes.service;

import java.util.List;

import org.acumen.training.codes.dao.AppointmentDao;
import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.dto.AppointmentPatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	public boolean insertAppointment(Appointment appointment) {
		return appointmentDao.insertAppointment(appointment);
	}
	
	public Appointment getAppointmentById(Integer id) {
		return appointmentDao.getAppointmentById(id);
	}
	
	public List<AppointmentPatientDTO> getAppointmentsByName(String name){
		return appointmentDao.getAppointmentsByName(name);
	}
	
	public boolean updateAppointmentArrivalStatus(Integer id, Appointment appointment) {
		return appointmentDao.updateAppointmentArrivalStatus(id, appointment);
	}
	
	public boolean updateAppointmentConfirmationStatus(Integer id, Appointment appointment) {
		return appointmentDao.updateAppointmentConfirmationStatus(id, appointment);

	}
}
