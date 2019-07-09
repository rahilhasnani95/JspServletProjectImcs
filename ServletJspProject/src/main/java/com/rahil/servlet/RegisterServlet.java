package com.rahil.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahil.service.UserService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService userservice = new UserService();

		int rowsreturned = userservice.registerUser(username, password);

		if(rowsreturned!= 0)
		{
			request.setAttribute("regsuccessmsg", "Registration Successfull!! Please Login and Shop ");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		}
		else
		{
			request.setAttribute("userexistsmessage", "Username " + username + " already exists! Please select a unique username");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
	}


}
