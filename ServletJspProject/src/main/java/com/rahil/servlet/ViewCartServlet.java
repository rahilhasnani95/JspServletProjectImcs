package com.rahil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rahil.model.CartBean;
import com.rahil.service.ViewCartService;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ViewCartService viewcartservice = new ViewCartService();
		
		String username = (String) request.getSession().getAttribute("username");
		
		List<CartBean> cartlist = viewcartservice.getCart(username);
		
		if(cartlist.isEmpty())
		{
			  request.setAttribute("emptycartmessage","Your cart is currenty empty! Please add items to cart");
			  
			  RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
			  rd.forward(request, response);
			 
		}
		else
		{
			request.getSession().setAttribute("cartlist", cartlist);
			response.sendRedirect("mycart.jsp");
		}
		
	}

}
