INSERT INTO patient (name, ic_no, gender, address, contact_no, registration_time, email)
VALUES
  ('Juan dela Cruz', '123456789', 'Male', '123 Main St, Manila', '09171234567', NOW(), 'juan@example.com'),
  ('Maria Santos', '987654321', 'Female', '456 Oak St, Quezon City', '09181234567', NOW(), 'maria@example.com'),
  ('Pedro Gonzales', '112233445', 'Male', '789 Pine St, Makati', '09191234567', NOW(), 'pedro@example.com'),
  ('Ana Reyes', '667788990', 'Female', '101 Maple St, Pasig', '09201234567', NOW(), 'ana@example.com');

INSERT INTO staff (name, ic_no, gender, address, contact_no, position, registration_time, email)
VALUES
  ('Dr. John Smith', '998877665', 'Male', '123 Doctor Ave, Manila', '09172345678', 'Doctor', NOW(), 'john.smith@example.com'),
  ('Nurse Clara Jones', '556677889', 'Female', '456 Nurse St, Quezon City', '09183456789', 'Nurse', NOW(), 'clara.jones@example.com'),
  ('Dr. Michael Brown', '334455667', 'Male', '789 Medical Rd, Makati', '09202345678', 'Doctor', NOW(), 'michael.brown@example.com'),
  ('Nurse Emily White', '223344556', 'Female', '101 Care St, Pasig', '09213456789', 'Nurse', NOW(), 'emily.white@example.com');

INSERT INTO report (fk_staff_id, details, date)
VALUES
  (1, 'Patient check-up report', NOW()),
  (2, 'Routine health check', NOW()),
  (3, 'Consultation report for Pedro Gonzales', NOW()),
  (4, 'Blood test result for Ana Reyes', NOW());

INSERT INTO appointment (date, is_arrival, fk_patient_id, fk_report_id, remark, is_confirmed)
VALUES
  (NOW() + INTERVAL '1 hour', TRUE, 1, 1,'General checkup with Dr. John Smith', TRUE),
  (NOW() + INTERVAL '2 hour', FALSE, 2, 2,'Follow-up appointment with Dr. Michael Brown', TRUE),
  (NOW() + INTERVAL '3 hour', TRUE, 3, 3,'Routine health check-up with Nurse Clara', TRUE),
  (NOW() + INTERVAL '4 hour', FALSE, 4, 4,'Initial consultation with Nurse Emily', TRUE);

INSERT INTO queue (check_in, type, start_time, end_time, fk_patient_id, fk_report_id)
VALUES
  (TRUE, 'Queue', NOW(), NOW() + INTERVAL '15 minutes', 1, 1),
  (FALSE, 'Queue', NOW() + INTERVAL '1 hour', NOW() + INTERVAL '1 hour 15 minutes', 2, 2),
  (TRUE, 'Queue', NOW() + INTERVAL '2 hours', NOW() + INTERVAL '2 hours 15 minutes', 3, 3),
  (FALSE, 'Queue', NOW() + INTERVAL '3 hours', NOW() + INTERVAL '3 hours 15 minutes', 4, 4);

INSERT INTO medical_certificate (start_date, day, reason, fk_patient_id)
VALUES
  ('2024-11-25', 3, 'Medical leave for illness', 1),
  ('2024-11-26', 5, 'Rest period after surgery', 2),
  ('2024-11-27', 2, 'Consultation leave for check-up', 3),
  ('2024-11-28', 1, 'Medical leave for treatment', 4);

INSERT INTO appointment_notification (fk_patient_id, send_date, details, message, type, has_send, has_send_date)
VALUES
  (1, '2024-11-24', 'Reminder for general check-up', 'You have an appointment with Dr. John Smith at 10:00 AM tomorrow.', 'Appointment', TRUE, '2024-11-24'),
  (2, '2024-11-24', 'Follow-up appointment reminder', 'Your appointment with Dr. Michael Brown is at 12:00 PM tomorrow.', 'Appointment', TRUE, '2024-11-24'),
  (3, '2024-11-24', 'Routine check-up reminder', 'Your appointment with Nurse Clara is at 2:00 PM tomorrow.', 'Appointment', TRUE, '2024-11-24'),
  (4, '2024-11-24', 'Consultation appointment reminder', 'Your appointment with Nurse Emily is at 4:00 PM tomorrow.', 'Appointment', TRUE, '2024-11-24');
