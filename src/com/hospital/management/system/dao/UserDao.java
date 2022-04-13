package com.hospital.management.system.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.hospital.management.system.config.DbConfig;
import com.hospital.management.system.entity.UserEntity;

/*
 * This class is used to communicate with mysql database.
 * This is used for user related database operation.
 * 
 */
public class UserDao {

	/* This method is used validate the user login*/
	public UserEntity validateLogin(String userId, String password) {
		UserEntity userEntity = new UserEntity();
		try {
			// Get db connection from DbConfig
			Connection conn = DbConfig.getConnection();
			//Create Statement
			Statement stmt=conn.createStatement();  
			//Execute query in database
			ResultSet rs = stmt.executeQuery("select * from user where user_id='"+userId+"' and password='"+password+"'");  
			//Assign the result from db to userEntity
			while(rs.next()) {
				userEntity.setUserId(rs.getString(1));
				userEntity.setFirstName(rs.getString(2));
				userEntity.setLastName(rs.getString(3));
				userEntity.setDob(rs.getString(4));
				userEntity.setPhone(rs.getString(5));
				userEntity.setPassword(rs.getString(6));
				userEntity.setRole(rs.getString(7));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userEntity;
	}
	
	/* This method is used to create the user account in db */
	public UserEntity createAccount(String firstName,String lastName,String dob,String phone,String userId, String password,String role) {
		System.out.println( firstName+","+ lastName+","+dob+","+ phone+","+userId+","+password+","+ role);
		UserEntity userEntity = new UserEntity();
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			String query = "insert into user values('"+userId+"','"+firstName+"','"+lastName+"','"+dob+"','"+phone+"','"+password+"','"+role+"')";
			stmt.executeUpdate(query);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userEntity;
	}
	
	/* This method is used to check if user exist in db by userId*/
	public boolean isUserExist(String userId) {
		boolean isUserExist = false;
		try {
			Connection conn = DbConfig.getConnection();
			Statement stmt=conn.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from user where user_id='"+userId+"'");  
			while(rs.next()) {
				isUserExist = true;
				break;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUserExist;
	}
	
	public String[] getAllDoctors() {
		List<String> doctors = new ArrayList<String>();
		try {
			// Get db connection from DbConfig
			Connection conn = DbConfig.getConnection();
			//Create Statement
			Statement stmt=conn.createStatement();  
			//Execute query in database
			ResultSet rs = stmt.executeQuery("select first_name from user where role='Doctor'");  
			//Assign the result from db to userEntity
			while(rs.next()) {
				doctors.add(rs.getString(1));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctors.toArray(new String[0]);
	}
}
