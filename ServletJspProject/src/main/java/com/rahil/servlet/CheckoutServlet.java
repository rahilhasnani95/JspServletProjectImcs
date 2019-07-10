package com.rahil.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahil.service.CheckoutService;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("username");

		CheckoutService checkoutservice = new CheckoutService();		

		int noofrowsreturnedfromcheckitem =	checkoutservice.checkItemsinCartButNotinProducts(username);
			
		if(noofrowsreturnedfromcheckitem > 0)
		{
			request.setAttribute("itemsoldoutmessage","One of the items in your cart is sold out! Please update your cart for checkout");

			RequestDispatcher rd = request.getRequestDispatcher("mycart.jsp");
			rd.forward(request, response);
		}
		else
		{
			int rowsreturnedfromupdateproducts = checkoutservice.checkout1(username);
			int rowsreturnedfromdeletefromcart = checkoutservice.checkout2(username);
			
			if(rowsreturnedfromdeletefromcart  >=1 && rowsreturnedfromupdateproducts >=1)
			{//change here
				int finalbill = Integer.parseInt(request.getParameter("finaltotalbill"));
	
				request.setAttribute("finalbillmessage","Your Final Amount Bill was : " + finalbill + " ! Thank you for Shopping");
	
				RequestDispatcher rd = request.getRequestDispatcher("mycart.jsp");
				rd.forward(request, response);
	
			}
			else 
			{ 
				request.setAttribute("cantcheckoutmessage","You can not checkout with empty cart! Please add items to cart");
	
				RequestDispatcher rd = request.getRequestDispatcher("mycart.jsp");
				rd.forward(request, response); 
			}
		}



	}

}
