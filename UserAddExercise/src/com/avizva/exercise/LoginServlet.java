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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginDAO d=new LoginDAO();
		boolean z=d.validate(username, password);
		RequestDispatcher rd;
		response.setContentType("text/html");
		if(z==true)
		{	HttpSession session=request.getSession();
        	session.setAttribute("username",username);
			 rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h1><font color='red'>Invalid Credentials</font></h1>");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

	

}


