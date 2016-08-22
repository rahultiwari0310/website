package com.avizva.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username;
		String cpassword;
		String password;
		String address;
		String firstname;
		String lastNnme;
		String gender;
		String dateofbirth;
		String forgotquestion;
		String city;
		
		PrintWriter out=response.getWriter();
		username=request.getParameter("username");
		password=request.getParameter("password");
		cpassword=request.getParameter("cpassword");
		firstname=request.getParameter("firstname");
		lastNnme=request.getParameter("lastNnme");
		dateofbirth=request.getParameter("dateofbirth");
		gender=request.getParameter("gender");
		forgotquestion=request.getParameter("forgotquestion");
		address=request.getParameter("address");
		city=request.getParameter("city");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
        session.setAttribute("username",username);

		

		
		
		try
		
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDetails","root","rahul");
			String q="select * from usercredential where username=?";
			PreparedStatement ps=conn.prepareStatement(q);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			
			
			if(rs.first())
			{
				out.println("username already taken");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request,response);
				return;
				
			}
			
			else if(!cpassword.equals(password))
			{
				out.println("passwords dont match");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request,response);
				return;
				
			}
			else
			{	
				RegisterDAO rdao=new RegisterDAO();
				rdao.update(username, cpassword, password, address, firstname, lastNnme, gender, dateofbirth, forgotquestion, city);
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.include(request,response);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
}

