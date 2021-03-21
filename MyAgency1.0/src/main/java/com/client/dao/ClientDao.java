package com.client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.client.model.ClientModel;

public class ClientDao {
	
		
	public boolean CheckAlreadyExist(ClientModel c) {
		
		String sql="select * from client where UserName=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "root", "");
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1, c.getUsername());			
			ResultSet rs=stm.executeQuery();
			if (rs.next()) {
				return true;		
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	
	public int RegisterClient(ClientModel c ) {
		String sql="INSERT INTO client (FirstName,LastName,UserName,Password,Adresse) VALUES(?,?,?,?,?)";
		int result=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "root", "");
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,c.getFirstname());  
			stm.setString(2,c.getLastname());  
			stm.setString(3,c.getUsername());  
			stm.setString(4,c.getMdp());
			stm.setString(5,c.getAdresse()); 
			result=stm.executeUpdate();
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
