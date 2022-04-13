package com.hospital.management.system.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hospital.management.system.dao.UserDao;

/*
 * This class is used for create account gui.
 */
public class CreateAccountGui implements ActionListener{

	private UserDao userDao = new UserDao();
	JLabel  lblError,lblFirstName,lblLastName,lblDob,lblPhone,lblUsername,lblPassword,lblConfirmPassword,lblRole;
	JButton btnCreateAccount,btnOk;    
	JPasswordField tfPassword,tfConfirmPassword;
	JTextField  tfFirstName,tfLastName,tfDob,tfPhone,tfUsername;
	JComboBox cbRole;
	JFrame f;
	String roles[] = { "Registration Staff", "Nurse", "Doctor", "Banker"};
	
	/* This constructor is used to create the gui with all the label, textfield and buttons*/
	public CreateAccountGui() {
		f = new JFrame("Create Account");
		
		lblError = new JLabel("");
		lblError.setBounds(50, 0, 300, 20);
		lblError.setForeground(Color.RED);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(50, 50, 100, 20);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(150, 50, 300, 20);	
	
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(50, 100, 100, 20);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(150, 100, 300, 20);
		
		lblDob = new JLabel("Date of Birth");
		lblDob.setBounds(50, 150, 150, 20);
		
		tfDob = new JTextField();
		tfDob.setBounds(150, 150, 300, 20);
		
		lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(50, 200, 100, 20);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(150, 200, 300, 20);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(50, 250, 100, 20);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(150, 250, 300, 20);
	
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 300, 100, 20);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(150, 300, 300, 20);
		
		lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setBounds(50, 350, 100, 20);
		
		tfConfirmPassword = new JPasswordField();
		tfConfirmPassword.setBounds(150, 350, 300, 20);
		
		lblRole = new JLabel("Role");
		lblRole.setBounds(50, 400, 100, 20);
		
		cbRole = new JComboBox(roles);
		cbRole.setBounds(150, 400, 300, 20);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(200, 450, 130, 50);
		btnCreateAccount.addActionListener(this);
		
		f.add(lblError);
		f.add(lblFirstName);
		f.add(tfFirstName);
		f.add(lblLastName);
		f.add(tfLastName);
		f.add(lblDob);
		f.add(tfDob);
		f.add(lblPhone);
		f.add(tfPhone);
		f.add(lblUsername);
		f.add(tfUsername);
		f.add(lblPassword);
		f.add(tfPassword);
		f.add(lblConfirmPassword);
		f.add(tfConfirmPassword);
		f.add(lblRole);
		f.add(cbRole);
		f.add(btnCreateAccount);
		
		f.setSize(500, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	}
	
	/*This method is used to capture the button click event*/
	 public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == btnCreateAccount) {
	        	if(userDao.isUserExist(tfUsername.getText())) {
	        		lblError.setText("Error: User already exist with this username !");
	        	}else {
	        		userDao.createAccount(tfFirstName.getText(), tfLastName.getText(), tfDob.getText(), tfPhone.getText(), tfUsername.getText(), tfPassword.getText(),cbRole.getSelectedItem().toString());
	        		lblError.setText("");
	        		JOptionPane.showMessageDialog(f, "Account Created Successfully, Please Login");
	        		f.dispose();
	        		new LoginGui();
	        	}        	
	        }
	    } 
}
