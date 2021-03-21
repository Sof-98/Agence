package com.login.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class LoginDao {
	
	public boolean check(String uname, String pass) {
		
		String sql="select * from client where UserName=? and Password=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "root", "");
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1, uname);
			stm.setString(2, pass);
			ResultSet rs=stm.executeQuery();
			if (rs.next()) {
				return true;		
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return false;
	}

}
