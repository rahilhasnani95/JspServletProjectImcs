package com.rahil.service;

import java.util.List;

import com.rahil.dao.ProductDAO;
import com.rahil.model.ProductBean;

public class ProductService {

	private ProductDAO productdao;

	public ProductService()
	{
		productdao = new ProductDAO();
	}
	
	
	public List<ProductBean> getprod()
	{
		return productdao.getProducts();
	}
	
	
}
