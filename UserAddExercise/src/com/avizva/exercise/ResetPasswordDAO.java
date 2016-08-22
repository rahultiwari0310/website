package com.avizva.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResetPasswordDAO {

	public boolean updatePassword(String username,String password,String cpassword)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDetails","root","rahul");
			
			
			
			
				 if(password.equals(cpassword))
			 {	
				String q="update usercredential set password=? where username=?";
				 PreparedStatement stmt=conn.prepareStatement(q);
				 stmt.setString(2, username);
				 stmt.setString(1, password);
				 
				 stmt.executeUpdate();
				 System.out.println("updated");
				 
				 return true;
				 
			 }
			
			
			else
				return false;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
}
