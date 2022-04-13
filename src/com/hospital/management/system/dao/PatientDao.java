package com.hospital.management.system.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hospital.management.system.config.DbConfig;
import com.hospital.management.system.entity.PatientEntity;
import com.hospital.management.system.entity.UserEntity;

/*
 * This class is used to communicate with mysql database.
 * This is used for patient related database operation.
 * 
 */
public class PatientDao {

	/* This method is used to get the patient from db by patient id*/
	public PatientEntity getPatient(String patientId) {
		PatientEntity patientEntity = new PatientEntity();
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from patient where patient_id='"+patientId+"'");  
			while(rs.next()) {
				patientEntity.setPatientId(rs.getString(1));
				patientEntity.setFirstName(rs.getString(2));
				patientEntity.setLastName(rs.getString(3));
				patientEntity.setDob(rs.getString(4));
				patientEntity.setPhone(rs.getString(5));
				patientEntity.setInsuranceProvider(rs.getString(6));
				patientEntity.setEmergencyContactName(rs.getString(7));
				patientEntity.setEmergencyContactNumber(rs.getString(8));
				patientEntity.setSymptom(rs.getString(9));
				patientEntity.setMedicationTaken(rs.getString(10));
				patientEntity.setMedicationAllergy(rs.getString(11));
				patientEntity.setBodyTemperature(rs.getString(12));
				patientEntity.setAdmitance(rs.getString(13));
				patientEntity.setRespirationRate(rs.getString(14));
				patientEntity.setNoOfDays(rs.getString(15));
				patientEntity.setBloodPressure(rs.getString(16));
				patientEntity.setPulse(rs.getString(17));
				patientEntity.setDoctorAssigned(rs.getString(18));
				patientEntity.setComment(rs.getString(19));
				patientEntity.setDiagnosis(rs.getString(20));
				patientEntity.setBloodWork(rs.getString(21));
				patientEntity.setxRay(rs.getString(22));
				patientEntity.setOtherLabTest(rs.getString(23));
				patientEntity.setPrescriptionOral(rs.getString(24));
				patientEntity.setPrescriptionInjection(rs.getString(25));
				patientEntity.setInstructionNurse(rs.getString(26));
				patientEntity.setInstructionDischarge(rs.getString(27));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientEntity;
	}
	
	/* This method is used to add the patient in db*/
	public void addPatient(PatientEntity patientEntity) {
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			String query = "insert into patient(patient_id,first_name,last_name,dob,phone,insurance_provider,emergency_contact_name,emergency_contact_number,symptom,medication_taken,medication_allergy) values('"+patientEntity.getPatientId()+"','"+patientEntity.getFirstName()+"','"+patientEntity.getLastName()+"','"+patientEntity.getDob()+"','"+patientEntity.getPhone()+"','"+patientEntity.getInsuranceProvider()+"','"+patientEntity.getEmergencyContactName()+"','"+patientEntity.getEmergencyContactNumber()+"','"+patientEntity.getSymptom()+"','"+patientEntity.getMedicationTaken()+"','"+patientEntity.getMedicationAllergy()+"')";
			stmt.executeUpdate(query);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method is used to update the patient in db*/
	public void updatePatient(PatientEntity patientEntity) {
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			String query = "update patient set first_name='"+patientEntity.getFirstName()+"',last_name='"+patientEntity.getLastName()+"',dob='"+patientEntity.getDob()+"',phone='"+patientEntity.getPhone()+"',insurance_provider='"+patientEntity.getInsuranceProvider()+"',emergency_contact_name='"+patientEntity.getEmergencyContactName()+"',emergency_contact_number='"+patientEntity.getEmergencyContactNumber()+"',symptom='"+patientEntity.getSymptom()+"',medication_taken='"+patientEntity.getMedicationTaken()+"',medication_allergy='"+patientEntity.getMedicationAllergy()+"' where patient_id='"+patientEntity.getPatientId()+"'";
			stmt.executeUpdate(query);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method is used to update the patient in db*/
	public void updatePatientByNurse(PatientEntity patientEntity) {
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			String query = "update patient set body_temperature='"+patientEntity.getBodyTemperature()+"',admitance='"+patientEntity.getAdmitance()+"',respiration_rate='"+patientEntity.getRespirationRate()+"',no_of_days='"+patientEntity.getNoOfDays()+"',blood_pressure='"+patientEntity.getBloodPressure()+"',pulse='"+patientEntity.getPulse()+"',doctor_assigned='"+patientEntity.getDoctorAssigned()+"',comment='"+patientEntity.getComment()+"' where patient_id='"+patientEntity.getPatientId()+"'";
			stmt.executeUpdate(query);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method is used to update the patient in db*/
	public void updatePatientByDoctor(PatientEntity patientEntity) {
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			String query = "update patient set diagnosis='"+patientEntity.getDiagnosis()+"',blood_work='"+patientEntity.getBloodWork()+"',xray='"+patientEntity.getxRay()+"',other_lab_test='"+patientEntity.getOtherLabTest()+"',prescription_oral='"+patientEntity.getPrescriptionOral()+"',prescription_injection='"+patientEntity.getPrescriptionInjection()+"',instruction_nurse='"+patientEntity.getInstructionNurse()+"',instruction_discharge='"+patientEntity.getInstructionDischarge()+"' where patient_id='"+patientEntity.getPatientId()+"'";
			stmt.executeUpdate(query);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* This method is used to verify the patient exist in db by patientId*/
	public boolean isPatientExist(String patientId) {
		boolean isPatientExist = false;
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from patient where patient_id='"+patientId+"'");  
			while(rs.next()) {
				isPatientExist = true;
				break;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPatientExist;
	}
}
