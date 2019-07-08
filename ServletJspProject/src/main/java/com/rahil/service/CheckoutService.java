package com.rahil.service;

import com.rahil.dao.CheckoutDAO;

public class CheckoutService {

	private CheckoutDAO checkoutdao;
	
	public CheckoutService()
	{
		checkoutdao = new CheckoutDAO();
	}
	
	public int checkout1(String username)
	{
		return checkoutdao.updateProducts(username);
	}
	
	public int checkout2(String username)
	{
		return checkoutdao.removeDetailsFromCart(username);
	}
	
}
