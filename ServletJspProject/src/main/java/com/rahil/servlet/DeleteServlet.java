package com.rahil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rahil.service.DeleteService;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeleteService deleteservice = new DeleteService();
		String username = (String) request.getSession().getAttribute("username");
		int itemid =  Integer.parseInt(request.getParameter("itemid"));
		String itemname =  request.getParameter("itemname");

		int deletedrows = deleteservice.deleteItem(username, itemid);
		
		request.setAttribute("itemid", itemid);
		request.setAttribute("itemname", itemname); 
		request.setAttribute("deletemessage","Deleted " + itemname + " from your cart");
		
		  RequestDispatcher rd = request.getRequestDispatcher("ViewCartServlet");
		  rd.forward(request, response);
		 
		
	}

}
