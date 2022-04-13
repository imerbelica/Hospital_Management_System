package com.hospital.management.system.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.management.system.config.DbConfig;
import com.hospital.management.system.entity.PatientEntity;
import com.hospital.management.system.entity.UserEntity;

/*
 * This class is used to communicate with mysql database.
 * This is used for patient service related database operation.
 * 
 */
public class ServiceDao {

	// get list of services by type from db
	public String[] getServicesByType(String type) {
		List<String> services = new ArrayList<String>();
		try {
			// Get db connection from DbConfig
			Connection conn = DbConfig.getConnection();
			//Create Statement
			Statement stmt=conn.createStatement();  
			//Execute query in database
			ResultSet rs = stmt.executeQuery("select name from services where type='"+type+"'");  
			//Assign the result from db to userEntity
			while(rs.next()) {
				services.add(rs.getString(1));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return services.toArray(new String[0]);
	}
	
	public Double getTotalAmount(String[] services) {
		Double totalAmount = 0.0;
		try {
			for(int i= 0;i <services.length; i++) {
				// Get db connection from DbConfig
				Connection conn = DbConfig.getConnection();
				//Create Statement
				Statement stmt=conn.createStatement();  
				//Execute query in database
				ResultSet rs = stmt.executeQuery("select price from services where name='"+services[i]+"'");  
				//Assign the result from db to userEntity
				while(rs.next()) {
					totalAmount += rs.getInt(1);
				}
				conn.close();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalAmount;
		
	}
}
