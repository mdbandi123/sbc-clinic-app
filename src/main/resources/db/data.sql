INSERT INTO patient (name, ic_no, gender, address, contact_no, registration_time) 
VALUES 
('John Doe', 'S1234567A', 'Male', '123 Main St, City A', '09123456789', NOW()),
('Jane Smith', 'S9876543B', 'Female', '456 Oak Rd, City B', '09987654321', NOW()),
('Alice Johnson', 'S2345678C', 'Female', '789 Pine Ln, City C', '09234567890', NOW()),
('Bob Brown', 'S3456789D', 'Male', '101 Maple Dr, City D', '09345678901', NOW());

INSERT INTO staff (name, ic_no, gender, address, contact_no, position, registration_time) 
VALUES 
('Dr. William Black', 'S1111111E', 'Male', '1 Clinic St, City A', '09112312345', 'Doctor', NOW()),
('Nurse Sarah White', 'S2222222F', 'Female', '2 Clinic Ave, City B', '09223423456', 'Nurse', NOW()),
('Dr. Emily Green', 'S3333333G', 'Female', '3 Hospital Rd, City C', '09334534567', 'Doctor', NOW()),
('Dr. James Blue', 'S4444444H', 'Male', '4 Health St, City D', '09445645678', 'Doctor', NOW());

INSERT INTO report (fk_staff_id, details) 
VALUES 
(1, 'Patient John Doe check-up report'),
(2, 'Patient Jane Smith blood test report'),
(3, 'Patient Alice Johnson X-ray report'),
(4, 'Patient Bob Brown surgery follow-up report');

INSERT INTO queue (check_in, type, start_time, end_time, fk_patient_id, fk_report_id) 
VALUES 
(NOW(), 'Queue', NOW(), NOW() + INTERVAL '30 MINUTE', 1, 1),
(NOW(), 'Queue', NOW(), NOW() + INTERVAL '45 MINUTE', 2, 2),
(NOW(), 'Queue', NOW(), NOW() + INTERVAL '60 MINUTE', 3, 3),
(NOW(), 'Queue', NOW(), NOW() + INTERVAL '15 MINUTE', 4, 4);

INSERT INTO medical_certificate (start_date, day, reason, fk_patient_id) 
VALUES 
('2024-11-20', '2024-11-21', 'Flu', 1),
('2024-11-20', '2024-11-22', 'Back Pain', 2),
('2024-11-20', '2024-11-23', 'Migraine', 3),
('2024-11-20', '2024-11-24', 'Surgery Recovery', 4);

INSERT INTO appointment_notification (fk_patient_id, send_date, details, message, type, has_send, has_send_date) 
VALUES 
(1, '2024-11-15', 'Reminder: Appointment scheduled', 'Your appointment is confirmed on 2024-11-20.', 'Appointment', TRUE, '2024-11-15'),
(2, '2024-11-16', 'Blood test appointment notification', 'Your blood test is on 2024-11-21.', 'Appointment', TRUE, '2024-11-16'),
(3, '2024-11-17', 'X-ray appointment notification', 'Your X-ray appointment is on 2024-11-22.', 'Appointment', FALSE, '2024-11-17'),
(4, '2024-11-18', 'Follow-up appointment reminder', 'Your follow-up is on 2024-11-23.', 'Appointment', FALSE, '2024-11-18');

INSERT INTO appointment (date, is_arrival, fk_patient_id, remark) 
VALUES 
('2024-11-20', TRUE, 1, 'Arrived on time for appointment'),
('2024-11-21', FALSE, 2, 'Missed blood test appointment'),
('2024-11-22', TRUE, 3, 'Arrived for X-ray appointment'),
('2024-11-23', TRUE, 4, 'Arrived for surgery follow-up');
