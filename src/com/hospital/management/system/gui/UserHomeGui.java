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
import com.hospital.management.system.dao.UserDao;

/*
 * This class is used for user home gui.
 */

public class UserHomeGui implements ActionListener{
	private PatientDao patientDao = new PatientDao();
	JLabel  lblError,lblPatientId;
	JTextField tfPatientId;
	JButton btnView,btnEdit,btnPrint,btnAdd;
	JFrame f ;
	String role;
	/* This constructor is used to create the gui with all the label, textfield and buttons*/
	public UserHomeGui(String role) {
		this.role = role;
		f = new JFrame(role);
		
		lblError = new JLabel("");
		lblError.setBounds(50, 0, 300, 20);
		lblError.setForeground(Color.RED);

		lblPatientId = new JLabel("Patient Id");
		lblPatientId.setBounds(50, 50, 100, 20);
		
		tfPatientId = new JTextField();
		tfPatientId.setBounds(150, 50, 180, 20);	
		
		btnView = new JButton("View File");
		btnView.setBounds(50, 100, 100, 40);
		btnView.addActionListener(this);
		
		btnEdit = new JButton("Edit File");
		btnEdit.setBounds(230, 100, 100, 40);
		btnEdit.addActionListener(this);	
		
		btnPrint = new JButton("Print Bill");
		btnPrint.setBounds(230, 100, 100, 40);
		btnPrint.addActionListener(this);
		btnPrint.setVisible(false);
		
		if(role.equals("Banker")) {
			btnEdit.setVisible(false);	
			btnPrint.setVisible(true);	
		}
		
		if(role.equals("Registration Staff")) {
			btnAdd = new JButton("Add Patient");
			btnAdd.setBounds(120, 200, 130, 50);
			btnAdd.addActionListener(this);
			f.add(btnAdd);
		}			
		
		f.add(lblError);
		f.add(lblPatientId);
		f.add(tfPatientId);
		f.add(btnView);
		f.add(btnEdit);
		f.add(btnPrint);
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	
	}
	
	/*This method is used to capture the button click event*/
	 public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == btnAdd) {
	        	f.dispose();
	        	new AddPatientGui();
	        }
	        if(e.getSource() == btnView || e.getSource() == btnEdit || e.getSource() == btnPrint) {
	        	String action = "";
	        	if(e.getSource() == btnView) {
	        		action = "View";
	        	}
	        	if(e.getSource() == btnEdit) {
	        		action = "Edit";
	        	}
	        	if(e.getSource() == btnPrint) {
	        		action = "Print";
	        	}
	        	if(!patientDao.isPatientExist(tfPatientId.getText())) {
	        		lblError.setText("Error: Patient does not exist with this patientId !");
	        	}else {
	        		f.dispose();
	        		if(role.equals("Registration Staff")) {
			        	new StaffViewEditPatientGui(tfPatientId.getText(),action);
	        		}else if(role.equals("Nurse")) {
			        	new NurseViewEditPatientGui(tfPatientId.getText(),action);
	        		}else if(role.equals("Doctor")) {
			        	new DoctorViewEditPatientGui(tfPatientId.getText(),action);
	        		}else if(role.equals("Banker")) {
			        	new BankerViewEditPatientGui(tfPatientId.getText(),action);
	        		}
	        	}
	        }
	 } 
	
}
