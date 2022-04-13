package com.hospital.management.system.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hospital.management.system.dao.UserDao;
import com.hospital.management.system.entity.UserEntity;

//import com.mysql.cj.util.StringUtils;
import com.mysql.jdbc.StringUtils;




/*
 * This class is used for main login gui.
 */
public class LoginGui implements ActionListener {

	private UserDao userDao = new UserDao();
	JFrame f ;
	JTextField  tfUserId;
	JPasswordField tfPassword;
	JLabel  lblUserId,lblPassword,lblError;

	JButton btnLogin, btnCreateAccount;

	/* This constructor is used to create the gui with all the label, textfield and buttons*/
	public LoginGui() {
		f = new JFrame("Main Login");
		
		lblError = new JLabel("");
		lblError.setBounds(50, 0, 300, 20);
		lblError.setForeground(Color.RED);

		lblUserId = new JLabel("Username");
		lblUserId.setBounds(50, 50, 150, 20);
		
		tfUserId = new JTextField();
		tfUserId.setBounds(150, 50, 150, 20);	
	
		lblPassword = new JLabel("Paaword");
		lblPassword.setBounds(50, 100, 150, 20);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(150, 100, 150, 20);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(50, 200, 100, 50);
		btnLogin.addActionListener(this);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(200, 200, 130, 50);
		btnCreateAccount.addActionListener(this);
		
		
		f.add(lblError);
		f.add(lblUserId);
		f.add(lblPassword);
		f.add(tfUserId);
		f.add(tfPassword);
		f.add(btnLogin);
		f.add(btnCreateAccount);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	
	}
	
	/*This method is used to capture the button click event*/
	 public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == btnLogin) {
	        	String userId = tfUserId.getText();
	        	String password = tfPassword.getText();
	        	UserEntity userEntity = userDao.validateLogin(userId, password);  	
	        	if(!StringUtils.isNullOrEmpty(userEntity.getRole())){
	        		f.dispose();
	        		new UserHomeGui(userEntity.getRole());
	        	}else {
	        		lblError.setText("Invalid username or password");
	        	}
	        }
	        if(e.getSource() == btnCreateAccount) {
	        	f.dispose();
        		new CreateAccountGui();
	        }
	    } 
}
