DROP DATABASE IF EXISTS clinic;
CREATE DATABASE clinic;

\c clinic;

CREATE SEQUENCE patient_seq START 1;
CREATE SEQUENCE report_seq START 1;
CREATE SEQUENCE staff_seq START 1;
CREATE SEQUENCE apt_seq START 1;
CREATE SEQUENCE queue_seq START 1;
CREATE SEQUENCE med_cert_seq START 1;
CREATE SEQUENCE apt_notif_seq START 1;

CREATE TABLE patient(
	patient_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('patient_seq'),
	name VARCHAR(50) NOT NULL,
	ic_no VARCHAR(50) UNIQUE NOT NULL,
	gender VARCHAR(10) NOT NULL,
	address VARCHAR(70) NOT NULL,
	contact_no VARCHAR(11) UNIQUE NOT NULL,
	registration_time TIMESTAMP NOT NULL,
	email VARCHAR(100) NOT NULL
	
);

CREATE TABLE staff(
	staff_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('staff_seq'),
	name VARCHAR(50) NOT NULL,
	ic_no VARCHAR(50) UNIQUE NOT NULL,
	gender VARCHAR(10) NOT NULL,
	address VARCHAR(70) NOT NULL,
	contact_no VARCHAR(11) UNIQUE NOT NULL,
	position VARCHAR(10) NOT NULL,
	registration_time TIMESTAMP NOT NULL,
	email VARCHAR(100) NOT NULL
);

CREATE TABLE report(
	report_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('report_seq'),
	fk_staff_id INTEGER NOT NULL,
	details VARCHAR(100) NOT NULL,
	date TIMESTAMP NOT NULL,
	FOREIGN KEY (fk_staff_id) REFERENCES staff(staff_id)
);

CREATE TABLE appointment(
	appointment_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('apt_seq'),
	date TIMESTAMP NOT NULL,
	is_arrival BOOLEAN NOT NULL,
	fk_patient_id INTEGER NOT NULL,
	fk_report_id INTEGER UNIQUE,
	remark VARCHAR(100) NOT NULL,
	is_confirmed BOOLEAN NOT NULL,
	FOREIGN KEY (fk_patient_id) REFERENCES patient(patient_id) ON UPDATE CASCADE,
	FOREIGN KEY (fk_report_id) REFERENCES report(report_id) ON UPDATE CASCADE
);

CREATE TABLE queue(
	queue_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('queue_seq'),
	check_in BOOLEAN NOT NULL,
	type VARCHAR(15) NOT NULL,
	start_time TIMESTAMP NOT NULL,
	end_time TIMESTAMP,
	fk_patient_id INTEGER NOT NULL,
	fk_report_id INTEGER UNIQUE,
	FOREIGN KEY (fk_patient_id) REFERENCES patient(patient_id) ON UPDATE CASCADE,
	FOREIGN KEY (fk_report_id) REFERENCES report(report_id) ON UPDATE CASCADE
);

CREATE TABLE medical_certificate(
	medical_certificate_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('med_cert_seq'),
	start_date DATE NOT NULL,
	day INTEGER NOT NULL,
	reason VARCHAR(100) NOT NULL,
	fk_patient_id INTEGER NOT NULL,
	FOREIGN KEY (fk_patient_id) REFERENCES patient(patient_id) ON UPDATE CASCADE
);

CREATE TABLE appointment_notification(
	message_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('apt_notif_seq'),
	fk_patient_id INTEGER NOT NULL,
	send_date DATE NOT NULL,
	details VARCHAR(100) NOT NULL,
	message VARCHAR(100) NOT NULL,
	type VARCHAR(15) NOT NULL,
	has_send BOOLEAN NOT NULL,
	has_send_date DATE NOT NULL
);




