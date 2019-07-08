package com.rahil.service;

import com.rahil.dao.CartDAO;

public class CartService {

	private CartDAO cartdao;
	
	public CartService()
	{
		cartdao = new CartDAO();
	}
	
	public int addCart(String username, int itemid,String itemname, int qty, int itemprice)
	{	
		 return cartdao.addToCart(username, itemid, itemname, qty, itemprice);
	}
	
}
