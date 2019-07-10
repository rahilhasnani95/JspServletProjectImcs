package com.rahil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rahil.model.ProductBean;
import com.rahil.service.ProductService;
import com.rahil.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userservice = new UserService();
	
		if(username.equals("admin") && password.equals("admin123"))
		{
			
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("welcomeAdmin.jsp");		
			
		}
		else
		{
			if(userservice.getUser(username, password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("welcomeUser.jsp");		
			}
			else
			{
				request.setAttribute("invalidcredentialsmsg", "Invalid Credentials! ");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			
			}
		}
		
	}
	
	
	
}
