User table
---------------------
CREATE TABLE `user` (
  `user_id` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `dob` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

Patient table
----------------------
CREATE TABLE `patient` (
  `patient_id` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `dob` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `insurance_provider` varchar(100) NOT NULL,
  `emergency_contact_name` varchar(100) NOT NULL,
  `emergency_contact_number` varchar(100) NOT NULL,
  `symptom` varchar(200) NOT NULL,
  `medication_taken` varchar(200) NOT NULL,
  `medication_allergy` varchar(200) NOT NULL,
  `body_temperature` varchar(100) NOT NULL DEFAULT 0,
  `admitance` varchar(100) NOT NULL DEFAULT 0,
  `respiration_rate` varchar(100) NOT NULL DEFAULT 0,
  `no_of_days` varchar(100) NOT NULL DEFAULT 0,
  `blood_pressure` varchar(100) NOT NULL DEFAULT 0,
  `pulse` varchar(100) NOT NULL DEFAULT 0,
  `doctor_assigned` varchar(100) NOT NULL DEFAULT 0,
  `comment` varchar(500) NOT NULL DEFAULT 0,
  `diagnosis` varchar(200) NOT NULL DEFAULT 0,
  `blood_work` varchar(200) NOT NULL DEFAULT 0,
  `xray` varchar(200) NOT NULL DEFAULT 0,
  `other_lab_test` varchar(200) NOT NULL DEFAULT 0,
  `prescription_oral` varchar(200) NOT NULL DEFAULT 0,
  `prescription_injection` varchar(200) NOT NULL DEFAULT 0,
  `instruction_nurse` varchar(200) NOT NULL DEFAULT 0,
  `instruction_discharge` varchar(200) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


Services table
---------------------------

CREATE TABLE `services` (
  `type` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

data for services table
---------------------------------

INSERT INTO `services` (`type`, `name`, `price`) VALUES
('diagnosis', 'Diagnosis1', 0),
('diagnosis', 'Diagnosis2', 0),
('diagnosis', 'Diagnosis3', 0),
('diagnosis', 'Diagnosis4', 0),
('diagnosis', 'Diagnosis5', 0),
('diagnosis', 'Diagnosis6', 0),
('diagnosis', 'Diagnosis7', 0),
('diagnosis', 'Diagnosis8', 0),
('bloodwork', 'Red Blood-Cell test', 100),
('bloodwork', 'Electrolyte Test', 100),
('bloodwork', 'White Blood-Cell Test', 100),
('bloodwork', 'Kidney Function Test', 100),
('bloodwork', 'Liver Function Test', 100),
('xray', 'X-Ray', 200),
('xray', 'XT-Scan', 200),
('xray', 'MRI', 500),
('other-lab', 'Urine Test', 50),
('other-lab', 'Stool Sample', 50),
('prescription_injection', 'Intravascular', 0),
('prescription_injection', 'Intramascular', 0),
('prescription_injection', 'Subcutaneous', 0),
('prescription_oral', 'Medication1', 0),
('prescription_oral', 'Medication2', 0),
('prescription_oral', 'Medication3', 0),
('prescription_oral', 'Medication4', 0),
('prescription_oral', 'Medication5', 0),
('prescription_oral', 'Medication6', 0),
('prescription_oral', 'Medication7', 0),
('prescription_oral', 'Medication8', 0),
('room_rent', 'Room Rent', 100);
COMMIT;