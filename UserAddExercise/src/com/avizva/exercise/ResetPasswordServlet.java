package com.avizva.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		ResetPasswordDAO rp=new ResetPasswordDAO();
		HttpSession session=request.getSession(false); 
		String username=(String)session.getAttribute("username");
		boolean flag=rp.updatePassword(username, password, cpassword);
		
		if(flag)
		{
			RequestDispatcher rd;
			response.setContentType("text/html");
			out.println("password has been reset");
			rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			username=null;
			
		}
		
		else
		{
			RequestDispatcher rd;
			response.setContentType("text/html");
			out.println("username or passwords dont match");
			rd=request.getRequestDispatcher("resetpassword.html");
			
			rd.forward(request, response);
			
		}
		
		
		
		
		
	}

	
	

}
