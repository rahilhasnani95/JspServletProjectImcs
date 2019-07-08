package com.rahil.service;

import com.rahil.dao.DeleteDAO;

public class DeleteService {

	private DeleteDAO deletedao;
	
	public DeleteService()
	{
		deletedao = new DeleteDAO();
	}
	
	public int deleteItem(String username, int itemid)
	{
		return deletedao.deleteItem(username, itemid);
	}
	
	
}
