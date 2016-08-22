package com.avizva.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	
	public boolean validate(String username,String password)
	{	
		try
		
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDetails","root","rahul");
			String q="select * from usercredential where username=? and password=?";
			PreparedStatement ps=conn.prepareStatement(q);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.first())
			{
				return true;
			}
				
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
		
		return false;
	}

	

}
