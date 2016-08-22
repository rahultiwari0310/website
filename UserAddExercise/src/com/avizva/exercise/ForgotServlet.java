package com.avizva.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String forgotquestion=request.getParameter("forgotquestion");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	
	
try
		
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDetails","root","rahul");
			String q="select * from usercredential where username=? and forgotquestion=?";
			PreparedStatement ps=conn.prepareStatement(q);
			ps.setString(1, username);
			ps.setString(2, forgotquestion);
			
			ResultSet rs=ps.executeQuery();
			if(rs.first())
			{	HttpSession session=request.getSession();
	        session.setAttribute("username",username);
				out.println("<a href=resetpassword.html>reset password</a>");
			}
		
	}
catch(Exception e)
{
	e.printStackTrace();
	}

	
}
}
