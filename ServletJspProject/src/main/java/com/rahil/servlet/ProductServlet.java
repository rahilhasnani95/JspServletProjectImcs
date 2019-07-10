package com.rahil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahil.model.ProductBean;
import com.rahil.service.ProductService;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	ProductService productservice = new ProductService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ProductBean> productlist = productservice.getprod();
		
		if(productlist.isEmpty())
		{
			response.sendRedirect("Noproduct.jsp");	
		}
		else
		{
			request.getSession().setAttribute("productlist", productlist);
			response.sendRedirect("product.jsp");		
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ProductBean> allprodlist = productservice.getAllprodforadmin();
		
		if(allprodlist.isEmpty())
		{
			response.sendRedirect("Noproduct.jsp");	
		}
		else
		{
			request.getSession().setAttribute("allprodlist", allprodlist);
			response.sendRedirect("Admin.jsp");		
		}
		
	}
	
	

}
