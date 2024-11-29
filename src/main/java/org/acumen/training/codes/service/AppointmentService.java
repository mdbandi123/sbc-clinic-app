package org.acumen.training.codes.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.acumen.training.codes.dao.AppointmentDao;
import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.dto.AppointmentPatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private QueueService queueService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private PatientService patientService;

	public boolean insertAppointment(Appointment appointment) {
		appointment.setIsArrival(false);
		appointment.setIsConfirmed(false);
		return appointmentDao.insertAppointment(appointment);
	}

	public List<AppointmentPatientDTO> getAppointmentById(Integer id) {
		return appointmentDao.getAppointmentsById(id);
	}

	public List<AppointmentPatientDTO> getAppointmentByIcNo(String icno) {
		return appointmentDao.getAppointmentsByIcNo(icno);
	}

	public List<AppointmentPatientDTO> getAppointmentsByName(String name) {
		return appointmentDao.getAppointmentsByName(name);
	}

	public List<AppointmentPatientDTO> getAllAppointments() {
		return appointmentDao.getAllAppointments();
	}

	public boolean updateAppointmentArrivalStatus(Integer id, Appointment appointment) {
		appointmentDao.updateAppointmentArrivalStatus(id, appointment);
		return queueService.insertToQueue(appointment);
	}

	public boolean updateAppointmentConfirmationStatus(Integer id, Appointment appointment) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' h:mm a");
		String formattedDate = appointment.getDate().format(formatter);
		String emailBody = "Greeting! This is to inform you that your appointment on %s for %s has been confirmed with appointment ID: %d"
				.formatted(formattedDate, appointment.getRemark(), appointment.getAppointmentId());
		try {
			Patient patient = (Patient) patientService.getPatientById(appointment.getFkPatientId()).toArray()[0];
			emailService.sendEmail(patient.getEmail(), "SB Clinic Appointment Confirmation", emailBody);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return appointmentDao.updateAppointmentConfirmationStatus(id, appointment);
	}

	public boolean updateAppointmentReportId(Integer id, Appointment appointment) {
		return appointmentDao.updateAppointmentReportId(id, appointment);
	}
}
