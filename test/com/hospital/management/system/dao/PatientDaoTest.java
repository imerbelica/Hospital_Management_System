package com.hospital.management.system.dao;

import com.hospital.management.system.config.DbConfig;
import com.hospital.management.system.entity.PatientEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PatientDaoTest {

    private static final PatientDao DAO = new PatientDao();

    private static final String TEST_PATIENT_ID = "peterparker";
    private static final String TEST_FIRST_NAME = "Peter";
    private static final String TEST_LAST_NAME = "Parker";

    @Test
    public void testGetPatient(){
        PatientEntity patientEntity = DAO.getPatient(TEST_PATIENT_ID);
        assertNotNull(patientEntity);
        assertEquals(TEST_PATIENT_ID, patientEntity.getPatientId());
        assertEquals(TEST_FIRST_NAME, patientEntity.getFirstName());
        assertEquals(TEST_LAST_NAME, patientEntity.getLastName());
    }

    @Test
    public void testAddPatient(){
        DAO.addPatient(stubNewPatientEntity());
        PatientEntity patientEntity = DAO.getPatient("harrypotter");
        assertNotNull(patientEntity);
        assertEquals("harrypotter", patientEntity.getPatientId());
        assertEquals("Harry", patientEntity.getFirstName());
        assertEquals("Potter", patientEntity.getLastName());
    }

    @Test
    public void testUpdatePatient(){
        DAO.updatePatient(stubPatientEntity());
        PatientEntity patientEntity = DAO.getPatient("peterparker");
        assertNotNull(patientEntity);
        assertEquals("peterparker", patientEntity.getPatientId());
        assertEquals("Peter", patientEntity.getFirstName());
        assertEquals("Parker", patientEntity.getLastName());
        assertEquals("123456789", patientEntity.getPhone());
    }

    @Test
    public void testUpdatePatientByNurse(){
        DAO.updatePatientByNurse(stubPatientEntity());
        PatientEntity patientEntity = DAO.getPatient("peterparker");
        assertNotNull(patientEntity);
        assertEquals("peterparker", patientEntity.getPatientId());
        assertEquals("97", patientEntity.getBodyTemperature());
        assertEquals("120", patientEntity.getBloodPressure());
    }

    @Test
    public void testUpdatePatientByDoctor(){
        DAO.updatePatientByDoctor(stubPatientEntity());
        PatientEntity patientEntity = DAO.getPatient("peterparker");
        assertNotNull(patientEntity);
        assertEquals("peterparker", patientEntity.getPatientId());
        assertEquals("fever", patientEntity.getDiagnosis());
    }

    @Test
    public void testIsPatientExist(){
        boolean patientExists = DAO.isPatientExist("peterparker");
        assertTrue(patientExists);
    }

    @Test
    public void testIsPatientNotExist(){
        boolean patientExists = DAO.isPatientExist("bob");
        assertFalse(patientExists);
    }

    private PatientEntity stubPatientEntity(){
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientId("peterparker");
        patientEntity.setFirstName("Peter");
        patientEntity.setLastName("Parker");
        patientEntity.setDob("12/4/1993");
        patientEntity.setPhone("123456789");
        patientEntity.setBodyTemperature("97");
        patientEntity.setBloodPressure("120");
        patientEntity.setDiagnosis("fever");
        return patientEntity;
    }

    private PatientEntity stubNewPatientEntity(){
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientId("harrypotter");
        patientEntity.setFirstName("Harry");
        patientEntity.setLastName("Potter");
        patientEntity.setDob("12/4/1993");
        patientEntity.setPhone("123456789");
        return patientEntity;
    }

}