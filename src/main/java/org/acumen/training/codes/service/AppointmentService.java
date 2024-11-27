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
	
	@Autowired
	private QueueService queueService;
	
	public boolean insertAppointment(Appointment appointment) {
		appointment.setIsArrival(false);
		appointment.setIsConfirmed(false);
		return appointmentDao.insertAppointment(appointment);
	}
	
	public  List<AppointmentPatientDTO> getAppointmentById(Integer id) {
		return appointmentDao.getAppointmentsById(id);
	}
	
	public  List<AppointmentPatientDTO> getAppointmentByIcNo(String icno) {
		return appointmentDao.getAppointmentsByIcNo(icno);
	}
	
	public List<AppointmentPatientDTO> getAppointmentsByName(String name){
		return appointmentDao.getAppointmentsByName(name);
	}
	
	public List<AppointmentPatientDTO> getAllAppointments(){
		return appointmentDao.getAllAppointments();
	}
	
	public boolean updateAppointmentArrivalStatus(Integer id, Appointment appointment) {
		appointmentDao.updateAppointmentArrivalStatus(id, appointment);
		return queueService.insertToQueue(appointment);
	}
	
	public boolean updateAppointmentConfirmationStatus(Integer id, Appointment appointment) {
		return appointmentDao.updateAppointmentConfirmationStatus(id, appointment);
	}
}
