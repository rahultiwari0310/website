package com.avizva.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDAO {

	public boolean update(String username,
	String cpassword,
	String password,
	String address,
	String firstname,
	String lastNnme,
	String gender,
	String dateofbirth,
	String forgotquestion,
	String city){
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDetails","root","rahul");
			System.out.println("insert ready");
			
			String in="insert into usercredential (username,password,lastNnme,firstname,Address,"
					+ "city,gender,forgotquestion,dateofbirth) values (?,?,?,?,?,?,?,?,?) ";
			PreparedStatement ps=conn.prepareStatement(in);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, lastNnme);
			
			ps.setString(4, firstname);
			ps.setString(5, address);
			ps.setString(6, city);
			ps.setString(7, gender);
			ps.setString(8, forgotquestion);
			ps.setString(9, dateofbirth);
			ps.executeUpdate();
			return true;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}
}
