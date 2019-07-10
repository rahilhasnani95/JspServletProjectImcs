package com.rahil.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahil.service.ProductService;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		
		ProductService productservice = new ProductService();
		productservice.updateQuantityofProducts(itemid, quantity);
		
		 request.setAttribute("adminupdatemsg","Updated quantity of itemid " + itemid + " to " + quantity +"!!");

		 RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		 rd.forward(request, response);
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemname = request.getParameter("itemname");
		int itemprice = Integer.parseInt(request.getParameter("itemprice"));
		int itemquantity = Integer.parseInt(request.getParameter("itemquantity"));
		ProductService productservice = new ProductService();
		
		productservice.addNewProduct(itemname, itemprice, itemquantity);
		request.setAttribute("adminaddproductmsg","Added New Product " + itemname +"!!");

		 RequestDispatcher rd = request.getRequestDispatcher("addproductadmin.jsp");
		 rd.forward(request, response);
		
	}

}
