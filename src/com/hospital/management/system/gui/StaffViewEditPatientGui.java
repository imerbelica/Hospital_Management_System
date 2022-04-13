package com.hospital.management.system.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hospital.management.system.dao.PatientDao;
import com.hospital.management.system.entity.PatientEntity;

/*
 * This class is used for view/edit patient gui.
 */

public class StaffViewEditPatientGui implements ActionListener {
	private PatientDao patientDao = new PatientDao();
	JLabel lblError, lblFirstName, lblLastName, lblDob, lblPhone, lblInsurance, lblEContactName, lblEContactNumber,
			lblSymptom, lblMedicationTaken, lblMedicationAllergy, lblPatientId;
	JButton btnSave, btnBack;
	JTextField tfFirstName, tfLastName, tfDob, tfPhone, tfInsurance, tfEContactName, tfEContactNumber, tfSymptom,
			tfMedicationTaken, tfMedicationAllergy, tfPatientId;
	JFrame f;

	/*
	 * This constructor is used to create the gui with all the label, textfield and
	 * buttons
	 */
	public StaffViewEditPatientGui(String patientId, String action) {
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
		lblFirstName.setBounds(50, 50, 150, 20);

		tfFirstName = new JTextField();
		tfFirstName.setBounds(200, 50, 300, 20);
		tfFirstName.setText(patientEntity.getFirstName());
		tfFirstName.setEnabled(isEnabled);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(50, 100, 150, 20);

		tfLastName = new JTextField();
		tfLastName.setBounds(200, 100, 300, 20);
		tfLastName.setText(patientEntity.getLastName());
		tfLastName.setEnabled(isEnabled);

		lblDob = new JLabel("Date of Birth");
		lblDob.setBounds(50, 150, 150, 20);

		tfDob = new JTextField();
		tfDob.setBounds(200, 150, 300, 20);
		tfDob.setText(patientEntity.getDob());
		tfDob.setEnabled(isEnabled);

		lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(50, 200, 150, 20);

		tfPhone = new JTextField();
		tfPhone.setBounds(200, 200, 300, 20);
		tfPhone.setText(patientEntity.getPhone());
		tfPhone.setEnabled(isEnabled);

		lblInsurance = new JLabel("Insurance Provider");
		lblInsurance.setBounds(50, 250, 150, 20);

		tfInsurance = new JTextField();
		tfInsurance.setBounds(200, 250, 300, 20);
		tfInsurance.setText(patientEntity.getInsuranceProvider());
		tfInsurance.setEnabled(isEnabled);

		lblEContactName = new JLabel("Emergency Contact Name");
		lblEContactName.setBounds(50, 300, 150, 20);

		tfEContactName = new JTextField();
		tfEContactName.setBounds(200, 300, 300, 20);
		tfEContactName.setText(patientEntity.getEmergencyContactName());
		tfEContactName.setEnabled(isEnabled);

		lblEContactNumber = new JLabel("Emergency Contact Number");
		lblEContactNumber.setBounds(50, 350, 150, 20);

		tfEContactNumber = new JTextField();
		tfEContactNumber.setBounds(200, 350, 300, 20);
		tfEContactNumber.setText(patientEntity.getEmergencyContactNumber());
		tfEContactNumber.setEnabled(isEnabled);

		lblSymptom = new JLabel("Symptoms");
		lblSymptom.setBounds(50, 400, 150, 20);

		tfSymptom = new JTextField();
		tfSymptom.setBounds(200, 400, 300, 20);
		tfSymptom.setText(patientEntity.getSymptom());
		tfSymptom.setEnabled(isEnabled);

		lblMedicationTaken = new JLabel("Medication Taken");
		lblMedicationTaken.setBounds(50, 450, 150, 20);

		tfMedicationTaken = new JTextField();
		tfMedicationTaken.setBounds(200, 450, 300, 20);
		tfMedicationTaken.setText(patientEntity.getMedicationTaken());
		tfMedicationTaken.setEnabled(isEnabled);

		lblMedicationAllergy = new JLabel("Medication Allergies");
		lblMedicationAllergy.setBounds(50, 500, 150, 20);

		tfMedicationAllergy = new JTextField();
		tfMedicationAllergy.setBounds(200, 500, 300, 20);
		tfMedicationAllergy.setText(patientEntity.getMedicationAllergy());
		tfMedicationAllergy.setEnabled(isEnabled);

		lblPatientId = new JLabel("PHN/Id");
		lblPatientId.setBounds(50, 550, 150, 20);

		tfPatientId = new JTextField();
		tfPatientId.setBounds(200, 550, 300, 20);
		tfPatientId.setText(patientEntity.getPatientId());
		tfPatientId.setEnabled(false);

		btnSave = new JButton("Save");
		btnSave.setBounds(100, 600, 130, 50);
		btnSave.addActionListener(this);
		btnSave.setVisible(isEnabled);

		btnBack = new JButton("Back");
		btnBack.setBounds(300, 600, 130, 50);
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
		f.add(btnSave);
		f.add(btnBack);
		f.setSize(600, 700);
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
			patientEntity.setFirstName(tfFirstName.getText());
			patientEntity.setLastName(tfLastName.getText());
			patientEntity.setDob(tfDob.getText());
			patientEntity.setPhone(tfPhone.getText());
			patientEntity.setInsuranceProvider(tfInsurance.getText());
			patientEntity.setEmergencyContactName(tfEContactName.getText());
			patientEntity.setEmergencyContactNumber(tfEContactNumber.getText());
			patientEntity.setSymptom(tfSymptom.getText());
			patientEntity.setMedicationTaken(tfMedicationTaken.getText());
			patientEntity.setMedicationAllergy(tfMedicationAllergy.getText());
			patientDao.updatePatient(patientEntity);
			lblError.setText("");
			JOptionPane.showMessageDialog(f, "Patient Updated Successfully !");
			f.dispose();
			new UserHomeGui("Registration Staff");
		}
		if (e.getSource() == btnBack) {
			f.dispose();
			new UserHomeGui("Registration Staff");
		}
	}
}
