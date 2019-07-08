package com.rahil.service;

import java.util.List;

import com.rahil.dao.ViewCartDAO;
import com.rahil.model.CartBean;

public class ViewCartService {

	private ViewCartDAO viewcartdao;
	
	public ViewCartService()
	{
		viewcartdao = new ViewCartDAO();
	}
	
	public List<CartBean> getCart(String username)
	{
		return viewcartdao.getCart(username);
	}
	
}
