package com.hospital.management.system.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.hospital.management.system.dao.PatientDao;
import com.hospital.management.system.dao.ServiceDao;
import com.hospital.management.system.entity.PatientEntity;

/*
 * This class is used for view/edit patient gui.
 */

public class BankerViewEditPatientGui implements ActionListener {
	private PatientDao patientDao = new PatientDao();
	private ServiceDao serviceDao = new ServiceDao();
	
	JLabel lblGeneral, lblName,lblNameValue, lblPatientId, lblPatientIdValue, lblNoOfDays, lblNoOfDaysValue, lblServices,lblServicesValue, lblAmount, lblAmountValue;
	JButton btnPrint, btnBack;
	JScrollPane scroll ;
	JTextArea taServices ;
	JFrame f;
	/*
	 * This constructor is used to create the gui with all the label, textfield and
	 * buttons
	 */
	public BankerViewEditPatientGui(String patientId, String action) {
		boolean isEnabled = true;
		if(action.equals("View")) {
			isEnabled = false;
		}
		PatientEntity patientEntity = patientDao.getPatient(patientId);
		
		String servicesOrdered = patientEntity.getBloodWork()+","+patientEntity.getOtherLabTest()+","+patientEntity.getxRay();
		Double totalAmount = serviceDao.getTotalAmount(servicesOrdered.split(","));
		f = new JFrame(action + " Patient");

		lblGeneral = new JLabel("General");
		lblGeneral.setBounds(150, 0, 200, 20);

		lblName = new JLabel("Name");
		lblName.setBounds(50, 50, 150, 20);
		
		lblNameValue = new JLabel(patientEntity.getFirstName()+"  "+patientEntity.getLastName());
		lblNameValue.setBounds(250, 50, 150, 20);
		
		lblPatientId = new JLabel("PHN/ID");
		lblPatientId.setBounds(50, 100, 150, 20);
		
		lblPatientIdValue = new JLabel(patientEntity.getPatientId());
		lblPatientIdValue.setBounds(250, 100, 150, 20);
		
		lblNoOfDays = new JLabel("No Of Days Admitted");
		lblNoOfDays.setBounds(50, 150, 150, 20);
		
		lblNoOfDaysValue = new JLabel(patientEntity.getNoOfDays());
		lblNoOfDaysValue.setBounds(250, 150, 150, 20);
		
		lblServices = new JLabel("Services Ordered");
		lblServices.setBounds(50, 200, 150, 20);
		
		lblServicesValue = new JLabel(servicesOrdered);
		lblServicesValue.setBounds(250, 200, 200, 40);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setBounds(50, 250, 150, 20);
		
		lblAmountValue = new JLabel(totalAmount.toString());
		lblAmountValue.setBounds(250, 250, 150, 20);

		btnPrint = new JButton("Print");
		btnPrint.setBounds(50, 300, 100, 40);
		btnPrint.addActionListener(this);
		btnPrint.setVisible(isEnabled);

		btnBack = new JButton("Back");
		btnBack.setBounds(250, 300, 100, 40);
		btnBack.addActionListener(this);
		
		if(!isEnabled) {
			btnBack.setBounds(150, 300, 100, 40);
		}

		f.add(lblGeneral);
		f.add(lblName);
		f.add(lblNameValue);
		f.add(lblPatientId);
		f.add(lblPatientIdValue);
		f.add(lblNoOfDays);
		f.add(lblNoOfDaysValue);
		f.add(lblServices);
		f.add(lblServicesValue);
		f.add(lblAmount);
		f.add(lblAmountValue);
		f.add(btnPrint);
		f.add(btnBack);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
	}

	/* This method is used to capture the button click event */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrint) {
			printComponenet(f);
		}
		if (e.getSource() == btnBack) {
			f.dispose();
			new UserHomeGui("Banker");
		}
	}
	
	public void printComponenet(Component component){
		  PrinterJob pj = PrinterJob.getPrinterJob();
		  pj.setJobName("Bill");
		  pj.setPrintable (new Printable() {    
		    public int print(Graphics pg, PageFormat pf, int pageNum){
		      if (pageNum > 0){
		      return Printable.NO_SUCH_PAGE;
		      }
		      Graphics2D g2 = (Graphics2D) pg;
		      g2.translate(pf.getImageableX(), pf.getImageableY());
		      component.paint(g2);
		      return Printable.PAGE_EXISTS;
		    }
		  });
		  if (pj.printDialog() == false) {
			  return;
		  }
		  try {
		        pj.print();
		  } catch (PrinterException e) {
		        e.printStackTrace();
		  }
		}
	
}
