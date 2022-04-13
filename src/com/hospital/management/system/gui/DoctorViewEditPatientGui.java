package com.hospital.management.system.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hospital.management.system.dao.PatientDao;
import com.hospital.management.system.dao.ServiceDao;
import com.hospital.management.system.dao.UserDao;
import com.hospital.management.system.entity.PatientEntity;


/*
 * This class is used for view/edit patient gui.
 */

public class DoctorViewEditPatientGui implements ActionListener {
	private PatientDao patientDao = new PatientDao();
	private UserDao userDao = new UserDao();
	private ServiceDao serviceDao = new ServiceDao();
	
	JLabel lblError,lblGeneral, lblFirstName, lblLastName, lblDob, lblPhone, lblInsurance, lblEContactName, lblEContactNumber,
			lblSymptom, lblMedicationTaken, lblMedicationAllergy, lblPatientId,lblPatientVitals,lblBodyTemperature,lblRespirationRate,lblBloodPressure,lblPulse,lblAdmitance,lblNoOfDays,lblDoctorAssigned,lblDoctorAssignment,lblDiagnosis,lblBloodWork,lblXray,lblOtherLab,lblPInjection,lblPOral,lblInstructionNurse,lblInstructionDischarge;
	JButton btnSave, btnBack;
	JTextField tfFirstName, tfLastName, tfDob, tfPhone, tfInsurance, tfEContactName, tfEContactNumber, tfSymptom,
			tfMedicationTaken, tfMedicationAllergy, tfPatientId,tfBodyTemperature,tfRespirationRate,tfBloodPressure,tfPulse,tfNoOfDays;
	JFrame f;
	JComboBox cbDoctor;
	JCheckBox tfAdmitance;
	JTextArea tfInstructionNurse,tfInstructionDischarge;
	JPanel pnlDiagnosis,pnlBloodWork,pnlXray,pnlOtherLabTest,pnlPrescriptionOral,pnlPrescriptionInjection;
	JCheckBox[] cbDiagnosis,cbBloodWork,cbXray,cbOtherLabTest,cbPrescriptionOral,cbPrescriptionInjection;;
	

	/*
	 * This constructor is used to create the gui with all the label, textfield and
	 * buttons
	 */
	public DoctorViewEditPatientGui(String patientId, String action) {
		boolean isEnabled = true;
		if (action.equals("View")) {
			isEnabled = false;
		}	
		String[] doctors = userDao.getAllDoctors();
		String[] diagnosis = serviceDao.getServicesByType("diagnosis");
		String[] bloodWork = serviceDao.getServicesByType("bloodwork");
		String[] xray = serviceDao.getServicesByType("xray");
		String[] otherLabTest = serviceDao.getServicesByType("other-lab");
		String[] prescriptionOral = serviceDao.getServicesByType("prescription_oral");
		String[] prescriptionInjection = serviceDao.getServicesByType("prescription_injection");
		PatientEntity patientEntity = patientDao.getPatient(patientId);
		List<String> selectedDiagnosis = Arrays.asList(patientEntity.getDiagnosis().split(","));
		List<String> selectedBloodWork = Arrays.asList(patientEntity.getBloodWork().split(","));
		List<String> selectedXray = Arrays.asList(patientEntity.getxRay().split(","));
		List<String> selectedOtherLabTest = Arrays.asList(patientEntity.getOtherLabTest().split(","));
		List<String> selectedPrescriptionOral = Arrays.asList(patientEntity.getPrescriptionOral().split(","));
		List<String> selectedPrescriptionInjection = Arrays.asList(patientEntity.getPrescriptionInjection().split(","));
		
		f = new JFrame(action + " Patient");

		lblError = new JLabel("");
		lblError.setBounds(50, 0, 300, 20);
		lblError.setForeground(Color.RED);
		
		lblGeneral = new JLabel("General");
		lblGeneral.setBounds(350, 20, 100, 20);

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
		lblPhone.setBounds(50, 75, 100, 20);

		tfPhone = new JTextField();
		tfPhone.setBounds(150, 75, 100, 20);
		tfPhone.setText(patientEntity.getPhone());
		tfPhone.setEnabled(false);

		lblInsurance = new JLabel("Insurance Prvdr");
		lblInsurance.setBounds(280, 75, 100, 20);

		tfInsurance = new JTextField();
		tfInsurance.setBounds(380, 75, 100, 20);
		tfInsurance.setText(patientEntity.getInsuranceProvider());
		tfInsurance.setEnabled(false);

		lblPatientId = new JLabel("PHN/Id");
		lblPatientId.setBounds(510, 75, 100, 20);

		tfPatientId = new JTextField();
		tfPatientId.setBounds(610, 75, 100, 20);
		tfPatientId.setText(patientEntity.getPatientId());
		tfPatientId.setEnabled(false);
		
		
		lblEContactName = new JLabel("Emergency Contact Name");
		lblEContactName.setBounds(50, 100, 200, 20);

		tfEContactName = new JTextField();
		tfEContactName.setBounds(250, 100, 460, 20);
		tfEContactName.setText(patientEntity.getEmergencyContactName());
		tfEContactName.setEnabled(false);

		lblEContactNumber = new JLabel("Emergency Contact Number");
		lblEContactNumber.setBounds(50, 125, 200, 20);

		tfEContactNumber = new JTextField();
		tfEContactNumber.setBounds(250, 125, 460, 20);
		tfEContactNumber.setText(patientEntity.getEmergencyContactNumber());
		tfEContactNumber.setEnabled(false);

		lblSymptom = new JLabel("Symptoms");
		lblSymptom.setBounds(50, 150, 200, 20);

		tfSymptom = new JTextField();
		tfSymptom.setBounds(250, 150, 460, 20);
		tfSymptom.setText(patientEntity.getSymptom());
		tfSymptom.setEnabled(false);

		lblMedicationTaken = new JLabel("Medication Taken");
		lblMedicationTaken.setBounds(50, 175, 200, 20);

		tfMedicationTaken = new JTextField();
		tfMedicationTaken.setBounds(250, 175, 460, 20);
		tfMedicationTaken.setText(patientEntity.getMedicationTaken());
		tfMedicationTaken.setEnabled(false);

		lblMedicationAllergy = new JLabel("Medication Allergies");
		lblMedicationAllergy.setBounds(50, 200, 200, 20);

		tfMedicationAllergy = new JTextField();
		tfMedicationAllergy.setBounds(250, 200, 460, 20);
		tfMedicationAllergy.setText(patientEntity.getMedicationAllergy());
		tfMedicationAllergy.setEnabled(false);

		JSeparator seperator1 = new JSeparator();
		seperator1.setOrientation(SwingConstants.HORIZONTAL);
		seperator1.setBounds(0, 225, 1000, 10);
         
		lblPatientVitals = new JLabel("Patient Vitals");
		lblPatientVitals.setBounds(350, 240, 200, 20);

		lblBodyTemperature = new JLabel("Body Teperature");
		lblBodyTemperature.setBounds(50, 275, 100, 20);
		
		tfBodyTemperature = new JTextField();
		tfBodyTemperature.setBounds(150, 275, 200, 20);
		tfBodyTemperature.setText(patientEntity.getBodyTemperature());
		tfBodyTemperature.setEnabled(false);
		
		lblAdmitance = new JLabel("Admitance");
		lblAdmitance.setBounds(375, 275, 100, 20);
		
		tfAdmitance = new JCheckBox("Admitance", true);  
		tfAdmitance.setBounds(475, 275, 20, 20);
		tfAdmitance.setText(patientEntity.getAdmitance());
		tfAdmitance.setSelected(Boolean.valueOf(patientEntity.getAdmitance()));
		tfAdmitance.setEnabled(false);
		
		lblNoOfDays = new JLabel("No of Days");
		lblNoOfDays.setBounds(550, 275, 100, 20);
		
		tfNoOfDays = new JTextField();
		tfNoOfDays.setBounds(650, 275, 50, 20);
		tfNoOfDays.setText(patientEntity.getNoOfDays());
		tfNoOfDays.setEnabled(false);
		
		lblRespirationRate = new JLabel("Respiration Rate");
		lblRespirationRate.setBounds(50, 300, 100, 20);
		
		tfRespirationRate = new JTextField();
		tfRespirationRate.setBounds(150, 300, 200, 20);
		tfRespirationRate.setText(patientEntity.getRespirationRate());
		tfRespirationRate.setEnabled(false);
		
		lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(375, 300, 100, 20);
		
		tfBloodPressure = new JTextField();
		tfBloodPressure.setBounds(500, 300, 200, 20);
		tfBloodPressure.setText(patientEntity.getBloodPressure());
		tfBloodPressure.setEnabled(false);
		
		lblDoctorAssigned = new JLabel("Doctor Assigned");
		lblDoctorAssigned.setBounds(50, 325, 100, 20);
		
		cbDoctor = new JComboBox(doctors);
		cbDoctor.setBounds(150, 325, 200, 20);
		cbDoctor.setEnabled(false);
		cbDoctor.setSelectedItem(patientEntity.getDoctorAssigned());
		
		lblPulse = new JLabel("Pulse");
		lblPulse.setBounds(375, 325, 100, 20);
		
		tfPulse = new JTextField();
		tfPulse.setBounds(500, 325, 200, 20);
		tfPulse.setText(patientEntity.getPulse());
		tfPulse.setEnabled(false);
		
		JSeparator seperator2 = new JSeparator();
		seperator2.setOrientation(SwingConstants.HORIZONTAL);
		seperator2.setBounds(0, 350, 1000, 10);
		
		lblDoctorAssignment = new JLabel("Doctor Assignments");
		lblDoctorAssignment.setBounds(350, 375, 200, 20);
		
		lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setBounds(50, 425, 150, 20);
		
		pnlDiagnosis = new JPanel();
		pnlDiagnosis.setBounds(200, 425, 500, 60);
		pnlDiagnosis.setEnabled(isEnabled);
		cbDiagnosis = new JCheckBox[diagnosis.length];
		for(int i=0;i<diagnosis.length;i++) {
			JCheckBox temp = new JCheckBox(diagnosis[i]);
			temp.setSelected(selectedDiagnosis.contains(diagnosis[i]));
			temp.setEnabled(isEnabled);
			cbDiagnosis[i] = temp;
			pnlDiagnosis.add(temp);
		}
		
		lblBloodWork = new JLabel("Bloodwork");
		lblBloodWork.setBounds(50, 500, 150, 20);
		
		pnlBloodWork = new JPanel();
		pnlBloodWork.setBounds(200, 500, 500, 60);
		pnlBloodWork.setEnabled(isEnabled);
		cbBloodWork = new JCheckBox[bloodWork.length];
		for(int i=0;i<bloodWork.length;i++) {
			JCheckBox temp = new JCheckBox(bloodWork[i]);
			temp.setSelected(selectedBloodWork.contains(bloodWork[i]));
			temp.setEnabled(isEnabled);
			cbBloodWork[i] = temp;
			pnlBloodWork.add(temp);
		}
		
		lblXray = new JLabel("X-Rays");
		lblXray.setBounds(50, 575, 150, 20);
		
		pnlXray = new JPanel();
		pnlXray.setBounds(200, 575, 500, 30);
		pnlXray.setEnabled(isEnabled);
		cbXray = new JCheckBox[xray.length];
		for(int i=0;i<xray.length;i++) {
			JCheckBox temp = new JCheckBox(xray[i]);
			temp.setSelected(selectedXray.contains(xray[i]));
			temp.setEnabled(isEnabled);
			cbXray[i] = temp;
			pnlXray.add(temp);
		}
		
		lblOtherLab = new JLabel("Other Lab Tests");
		lblOtherLab.setBounds(50, 625, 150, 20);
		
		pnlOtherLabTest = new JPanel();
		pnlOtherLabTest.setBounds(200, 625, 500, 30);
		pnlOtherLabTest.setEnabled(isEnabled);
		cbOtherLabTest = new JCheckBox[otherLabTest.length];
		for(int i=0;i<otherLabTest.length;i++) {
			JCheckBox temp = new JCheckBox(otherLabTest[i]);
			temp.setSelected(selectedOtherLabTest.contains(otherLabTest[i]));
			temp.setEnabled(isEnabled);
			cbOtherLabTest[i] = temp;
			pnlOtherLabTest.add(temp);
		}
		
		lblPInjection = new JLabel("Prescriptions(Injection)");
		lblPInjection.setBounds(50, 675, 150, 20);
		
		pnlPrescriptionInjection = new JPanel();
		pnlPrescriptionInjection.setBounds(200, 675, 500, 30);
		pnlPrescriptionInjection.setEnabled(isEnabled);
		cbPrescriptionInjection = new JCheckBox[prescriptionInjection.length];
		for(int i=0;i<prescriptionInjection.length;i++) {
			JCheckBox temp = new JCheckBox(prescriptionInjection[i]);
			temp.setSelected(selectedPrescriptionInjection.contains(prescriptionInjection[i]));
			temp.setEnabled(isEnabled);
			cbPrescriptionInjection[i] = temp;
			pnlPrescriptionInjection.add(temp);
		}
		
		lblPOral = new JLabel("Prescription(Oral)");
		lblPOral.setBounds(50, 725, 150, 20);
		
		pnlPrescriptionOral = new JPanel();
		pnlPrescriptionOral.setBounds(200, 725, 500, 60);
		pnlPrescriptionOral.setEnabled(isEnabled);
		cbPrescriptionOral = new JCheckBox[prescriptionOral.length];
		for(int i=0;i<prescriptionOral.length;i++) {
			JCheckBox temp = new JCheckBox(prescriptionOral[i]);
			temp.setSelected(selectedPrescriptionOral.contains(prescriptionOral[i]));
			temp.setEnabled(isEnabled);
			cbPrescriptionOral[i] = temp;
			pnlPrescriptionOral.add(temp);
		}
		
		lblInstructionNurse = new JLabel("Instructions to NUrse");
		lblInstructionNurse.setBounds(50, 800, 150, 20);
		
		tfInstructionNurse = new JTextArea();
		tfInstructionNurse.setBounds(200, 800, 500, 30);
		tfInstructionNurse.setText(patientEntity.getInstructionNurse());
		tfInstructionNurse.setEnabled(isEnabled);	
		
		lblInstructionDischarge = new JLabel("Instructions at Discharge");
		lblInstructionDischarge.setBounds(50, 840, 150, 20);
		
		tfInstructionDischarge = new JTextArea();
		tfInstructionDischarge.setBounds(200, 840, 500, 30);
		tfInstructionDischarge.setText(patientEntity.getInstructionDischarge());
		tfInstructionDischarge.setEnabled(isEnabled);	
		
		
		btnSave = new JButton("Save");
		btnSave.setBounds(200, 875, 130, 50);
		btnSave.addActionListener(this);
		btnSave.setVisible(isEnabled);

		btnBack = new JButton("Back");	
		if(isEnabled) {
			btnBack.setBounds(500, 875, 130, 50);
		}else {
			btnBack.setBounds(350, 875, 130, 50);
		}
		btnBack.addActionListener(this);

		f.add(lblError);
		f.add(lblGeneral);
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
		f.add(seperator1);
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
		f.add(seperator2);
		f.add(lblDoctorAssignment);	
		f.add(lblDiagnosis);	
		f.add(pnlDiagnosis);
		f.add(lblBloodWork);
		f.add(pnlBloodWork);
		f.add(lblXray);	
		f.add(pnlXray);
		f.add(lblOtherLab);
		f.add(pnlOtherLabTest);
		f.add(lblPInjection);
		f.add(pnlPrescriptionInjection);
		f.add(lblPOral);	
		f.add(pnlPrescriptionOral);
		f.add(lblInstructionNurse);	
		f.add(pnlDiagnosis);
		f.add(tfInstructionNurse);	
		f.add(lblInstructionDischarge);	
		f.add(tfInstructionDischarge);	
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
			
			StringBuilder diagnosis= new StringBuilder();
			for(int i=0;i<cbDiagnosis.length;i++) {
				if(cbDiagnosis[i].isSelected()) {
					diagnosis.append(cbDiagnosis[i].getText());
					if(i<cbDiagnosis.length-1) {
						diagnosis.append(",");
					}
				}
			}
			
			StringBuilder bloodwork= new StringBuilder();
			for(int i=0;i<cbBloodWork.length;i++) {
				if(cbBloodWork[i].isSelected()) {
					bloodwork.append(cbBloodWork[i].getText());
					if(i<cbBloodWork.length-1) {
						bloodwork.append(",");
					}
				}
			}
			
			StringBuilder xray= new StringBuilder();
			for(int i=0;i<cbXray.length;i++) {
				if(cbXray[i].isSelected()) {
					xray.append(cbXray[i].getText());
					if(i<cbXray.length-1) {
						xray.append(",");
					}
				}
			}
			
			StringBuilder otherLabTest= new StringBuilder();
			for(int i=0;i<cbOtherLabTest.length;i++) {
				if(cbOtherLabTest[i].isSelected()) {
					otherLabTest.append(cbOtherLabTest[i].getText());
					if(i<cbOtherLabTest.length-1) {
						otherLabTest.append(",");
					}
				}
			}
			
			StringBuilder prescriptionInjection= new StringBuilder();
			for(int i=0;i<cbPrescriptionInjection.length;i++) {
				if(cbPrescriptionInjection[i].isSelected()) {
					prescriptionInjection.append(cbPrescriptionInjection[i].getText());
					if(i<cbPrescriptionInjection.length-1) {
						prescriptionInjection.append(",");
					}
				}
			}
			
			StringBuilder prescriptionOral= new StringBuilder();
			for(int i=0;i<cbPrescriptionOral.length;i++) {
				if(cbPrescriptionOral[i].isSelected()) {
					prescriptionOral.append(cbPrescriptionOral[i].getText());
					if(i<cbPrescriptionOral.length-1) {
						prescriptionOral.append(",");
					}
				}
			}
			
			patientEntity.setDiagnosis(diagnosis.toString());
			patientEntity.setBloodWork(bloodwork.toString());
			patientEntity.setxRay(xray.toString());
			patientEntity.setOtherLabTest(otherLabTest.toString());
			patientEntity.setPrescriptionInjection(prescriptionInjection.toString());
			patientEntity.setPrescriptionOral(prescriptionOral.toString());
			patientEntity.setInstructionNurse(tfInstructionNurse.getText());
			patientEntity.setInstructionDischarge(tfInstructionDischarge.getText());
			patientDao.updatePatientByDoctor(patientEntity);
			lblError.setText("");
			JOptionPane.showMessageDialog(f, "Patient Updated Successfully !");
			f.dispose();
			new UserHomeGui("Doctor");
		}
		if (e.getSource() == btnBack) {
			f.dispose();
			new UserHomeGui("Doctor");
		}
	}
}
