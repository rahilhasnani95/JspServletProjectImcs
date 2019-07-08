package com.rahil.service;

import com.rahil.dao.UserDAO;
import com.rahil.model.UserBean;

public class UserService {

	private UserDAO userdao;
	
	public UserService()
	{
		userdao = new UserDAO();
		
	}
	
	public boolean getUser(String username, String password)
	{
		return userdao.checkUser(username, password);
	}
	
}
