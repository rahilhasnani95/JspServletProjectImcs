package com.rahil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahil.service.CartService;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		CartService cartservice = new CartService();
		
		int qty = Integer.parseInt(request.getParameter("qty"));
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		String itemname = request.getParameter("itemname");
		int itemprice = Integer.parseInt(request.getParameter("itemprice"));
		String username = request.getSession().getAttribute("username").toString();

		 int noofrowsinserted = cartservice.addCart(username, itemid, itemname, qty, itemprice);
		
		 request.setAttribute("qty", qty);
		 request.setAttribute("itemname", itemname);
		 request.setAttribute("itemprice", itemprice);
		 request.setAttribute("itemname", itemname);
		
		 request.setAttribute("addmessage","Added " + qty + " quantity of " + itemname + "");

		 RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		 rd.forward(request, response);
		 
	}

}
