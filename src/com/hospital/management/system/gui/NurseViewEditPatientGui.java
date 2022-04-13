package com.hospital.management.system.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hospital.management.system.dao.PatientDao;
import com.hospital.management.system.dao.UserDao;
import com.hospital.management.system.entity.PatientEntity;

/*
 * This class is used for view/edit patient gui.
 */

public class NurseViewEditPatientGui implements ActionListener {
	private PatientDao patientDao = new PatientDao();
	private UserDao userDao = new UserDao();
	JLabel lblError, lblFirstName, lblLastName, lblDob, lblPhone, lblInsurance, lblEContactName, lblEContactNumber,
			lblSymptom, lblMedicationTaken, lblMedicationAllergy, lblPatientId,lblPatientVitals,lblBodyTemperature,lblRespirationRate,lblBloodPressure,lblPulse,lblAdmitance,lblNoOfDays,lblDoctorAssigned,lblComment;
	JButton btnSave, btnBack;
	JTextField tfFirstName, tfLastName, tfDob, tfPhone, tfInsurance, tfEContactName, tfEContactNumber, tfSymptom,
			tfMedicationTaken, tfMedicationAllergy, tfPatientId,tfBodyTemperature,tfRespirationRate,tfBloodPressure,tfPulse,tfNoOfDays;
	JFrame f;
	JComboBox cbDoctor;
	JCheckBox tfAdmitance;
	JTextArea tfComment;

	/*
	 * This constructor is used to create the gui with all the label, textfield and
	 * buttons
	 */
	public NurseViewEditPatientGui(String patientId, String action) {
		String[] doctors = userDao.getAllDoctors();
		boolean isEnabled = true;
		if (action.equals("View")) {
			isEnabled = false;
		}
		PatientEntity patientEntity = patientDao.getPatient(patientId);
		f = new JFrame(action + " Patient");

		lblError = new JLabel("");
		lblError.setBounds(50, 0, 300, 20);
		lblError.setForeground(Color.RED);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(50, 50, 100, 20);

		tfFirstName = new JTextField();
		tfFirstName.setBounds(150, 50, 100, 20);
		tfFirstName.setText(patientEntity.getFirstName());
		tfFirstName.setEnabled(false);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(280, 50, 100, 20);

		tfLastName = new JTextField();
		tfLastName.setBounds(380, 50, 100, 20);
		tfLastName.setText(patientEntity.getLastName());
		tfLastName.setEnabled(false);

		lblDob = new JLabel("Date of Birth");
		lblDob.setBounds(510, 50, 100, 20);

		tfDob = new JTextField();
		tfDob.setBounds(610, 50, 100, 20);
		tfDob.setText(patientEntity.getDob());
		tfDob.setEnabled(false);

		lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(50, 100, 100, 20);

		tfPhone = new JTextField();
		tfPhone.setBounds(150, 100, 100, 20);
		tfPhone.setText(patientEntity.getPhone());
		tfPhone.setEnabled(false);

		lblInsurance = new JLabel("Insurance Prvdr");
		lblInsurance.setBounds(280, 100, 100, 20);

		tfInsurance = new JTextField();
		tfInsurance.setBounds(380, 100, 100, 20);
		tfInsurance.setText(patientEntity.getInsuranceProvider());
		tfInsurance.setEnabled(false);

		lblPatientId = new JLabel("PHN/Id");
		lblPatientId.setBounds(510, 100, 100, 20);

		tfPatientId = new JTextField();
		tfPatientId.setBounds(610, 100, 100, 20);
		tfPatientId.setText(patientEntity.getPatientId());
		tfPatientId.setEnabled(false);
		
		
		lblEContactName = new JLabel("Emergency Contact Name");
		lblEContactName.setBounds(50, 150, 200, 20);

		tfEContactName = new JTextField();
		tfEContactName.setBounds(250, 150, 460, 20);
		tfEContactName.setText(patientEntity.getEmergencyContactName());
		tfEContactName.setEnabled(false);

		lblEContactNumber = new JLabel("Emergency Contact Number");
		lblEContactNumber.setBounds(50, 200, 200, 20);

		tfEContactNumber = new JTextField();
		tfEContactNumber.setBounds(250, 200, 460, 20);
		tfEContactNumber.setText(patientEntity.getEmergencyContactNumber());
		tfEContactNumber.setEnabled(false);

		lblSymptom = new JLabel("Symptoms");
		lblSymptom.setBounds(50, 250, 200, 20);

		tfSymptom = new JTextField();
		tfSymptom.setBounds(250, 250, 460, 20);
		tfSymptom.setText(patientEntity.getSymptom());
		tfSymptom.setEnabled(false);

		lblMedicationTaken = new JLabel("Medication Taken");
		lblMedicationTaken.setBounds(50, 300, 200, 20);

		tfMedicationTaken = new JTextField();
		tfMedicationTaken.setBounds(250, 300, 460, 20);
		tfMedicationTaken.setText(patientEntity.getMedicationTaken());
		tfMedicationTaken.setEnabled(false);

		lblMedicationAllergy = new JLabel("Medication Allergies");
		lblMedicationAllergy.setBounds(50, 350, 200, 20);

		tfMedicationAllergy = new JTextField();
		tfMedicationAllergy.setBounds(250, 350, 460, 20);
		tfMedicationAllergy.setText(patientEntity.getMedicationAllergy());
		tfMedicationAllergy.setEnabled(false);

		JSeparator seperator = new JSeparator();
		seperator.setOrientation(SwingConstants.HORIZONTAL);
		seperator.setBounds(0, 400, 1000, 10);
         
		lblPatientVitals = new JLabel("Patient Vitals");
		lblPatientVitals.setBounds(350, 420, 200, 20);

		lblBodyTemperature = new JLabel("Body Teperature");
		lblBodyTemperature.setBounds(50, 470, 100, 20);
		
		tfBodyTemperature = new JTextField();
		tfBodyTemperature.setBounds(150, 470, 200, 20);
		tfBodyTemperature.setText(patientEntity.getBodyTemperature());
		tfBodyTemperature.setEnabled(isEnabled);
		
		lblAdmitance = new JLabel("Admitance");
		lblAdmitance.setBounds(400, 470, 100, 20);
		
		tfAdmitance = new JCheckBox("Admitance", true);  
		tfAdmitance.setBounds(500, 470, 20, 20);
		tfAdmitance.setText(patientEntity.getAdmitance());
		tfAdmitance.setSelected(Boolean.valueOf(patientEntity.getAdmitance()));
		tfAdmitance.setEnabled(isEnabled);
		
		lblRespirationRate = new JLabel("Respiration Rate");
		lblRespirationRate.setBounds(50, 520, 100, 20);
		
		tfRespirationRate = new JTextField();
		tfRespirationRate.setBounds(150, 520, 200, 20);
		tfRespirationRate.setText(patientEntity.getRespirationRate());
		tfRespirationRate.setEnabled(isEnabled);
		
		lblNoOfDays = new JLabel("No of Days");
		lblNoOfDays.setBounds(400, 520, 100, 20);
		
		tfNoOfDays = new JTextField();
		tfNoOfDays.setBounds(500, 520, 50, 20);
		tfNoOfDays.setText(patientEntity.getNoOfDays());
		tfNoOfDays.setEnabled(isEnabled);
		
		lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(50, 570, 100, 20);
		
		tfBloodPressure = new JTextField();
		tfBloodPressure.setBounds(150, 570, 200, 20);
		tfBloodPressure.setText(patientEntity.getBloodPressure());
		tfBloodPressure.setEnabled(isEnabled);
		
		lblPulse = new JLabel("Pulse");
		lblPulse.setBounds(50, 620, 100, 20);
		
		tfPulse = new JTextField();
		tfPulse.setBounds(150, 620, 200, 20);
		tfPulse.setText(patientEntity.getPulse());
		tfPulse.setEnabled(isEnabled);
		
		lblDoctorAssigned = new JLabel("Doctor Assigned");
		lblDoctorAssigned.setBounds(50, 670, 100, 20);
		
		cbDoctor = new JComboBox(doctors);
		cbDoctor.setBounds(150, 670, 200, 20);
		cbDoctor.setEnabled(isEnabled);
		cbDoctor.setSelectedItem(patientEntity.getDoctorAssigned());
		
		lblComment = new JLabel("Comments");
		lblComment.setBounds(50, 720, 100, 20);
		
		tfComment = new JTextArea();
		tfComment.setBounds(150, 720, 550, 100);
		tfComment.setText(patientEntity.getComment());
		tfComment.setEnabled(isEnabled);	
		
		btnSave = new JButton("Save");
		btnSave.setBounds(200, 850, 130, 50);
		btnSave.addActionListener(this);
		btnSave.setVisible(isEnabled);

		btnBack = new JButton("Back");	
		if(isEnabled) {
			btnBack.setBounds(500, 850, 130, 50);
		}else {
			btnBack.setBounds(350, 850, 130, 50);
		}
		btnBack.addActionListener(this);

		f.add(lblError);
		f.add(lblFirstName);
		f.add(tfFirstName);
		f.add(lblLastName);
		f.add(tfLastName);
		f.add(lblDob);
		f.add(tfDob);
		f.add(lblPhone);
		f.add(tfPhone);
		f.add(lblInsurance);
		f.add(tfInsurance);
		f.add(lblEContactName);
		f.add(tfEContactName);
		f.add(lblEContactNumber);
		f.add(tfEContactNumber);
		f.add(lblSymptom);
		f.add(tfSymptom);
		f.add(lblMedicationTaken);
		f.add(tfMedicationTaken);
		f.add(lblMedicationAllergy);
		f.add(tfMedicationAllergy);
		f.add(lblPatientId);
		f.add(tfPatientId);
		f.add(seperator);
		f.add(lblPatientVitals);
		f.add(lblBodyTemperature);
		f.add(tfBodyTemperature);
		f.add(lblAdmitance);
		f.add(tfAdmitance);
		f.add(lblRespirationRate);
		f.add(tfRespirationRate);
		f.add(lblNoOfDays);
		f.add(tfNoOfDays);	
		f.add(lblBloodPressure);
		f.add(tfBloodPressure);
		f.add(lblPulse);
		f.add(tfPulse);	
		f.add(lblDoctorAssigned);	
		f.add(cbDoctor);	
		f.add(lblComment);	
		f.add(tfComment);	
		f.add(btnSave);
		f.add(btnBack);
		f.setSize(800, 1000);
		f.setLayout(null);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
	}

	/* This method is used to capture the button click event */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			PatientEntity patientEntity = new PatientEntity();
			patientEntity.setPatientId(tfPatientId.getText());
			patientEntity.setBodyTemperature(tfBodyTemperature.getText());
			patientEntity.setAdmitance(String.valueOf(tfAdmitance.isSelected()));
			patientEntity.setRespirationRate(tfRespirationRate.getText());
			patientEntity.setNoOfDays(tfNoOfDays.getText());
			patientEntity.setBloodPressure(tfBloodPressure.getText());
			patientEntity.setPulse(tfPulse.getText());
			patientEntity.setDoctorAssigned(cbDoctor.getSelectedItem().toString());
			patientEntity.setComment(tfComment.getText());
			patientDao.updatePatientByNurse(patientEntity);
			lblError.setText("");
			JOptionPane.showMessageDialog(f, "Patient Updated Successfully !");
			f.dispose();
			new UserHomeGui("Nurse");
		}
		if (e.getSource() == btnBack) {
			f.dispose();
			new UserHomeGui("Nurse");
		}
	}
}
