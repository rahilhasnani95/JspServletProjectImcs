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
	
	public List<ProductBean> getAllprodforadmin()
	{
		return productdao.getAllProductsforAdmin();
	}
	
	public void updateQuantityofProducts(int itemid, int quantity)
	{
		productdao.updateQuantityOfProductAdmin(itemid, quantity);
	}

	public void addNewProduct(String itemname, int itemprice, int itemquantity)
	{
		productdao.updateQuantityOfProductAdmin(itemname, itemprice, itemquantity);
	}
	
}
