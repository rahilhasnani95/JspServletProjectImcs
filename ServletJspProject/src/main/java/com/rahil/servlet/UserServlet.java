package com.rahil.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rahil.model.UserBean;
import com.rahil.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userservice = new UserService();
	
		if(userservice.getUser(username, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("welcomeUser.jsp");		
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("invalidUser.jsp");		
			
		}
		
		
	}
	
	
	
}
