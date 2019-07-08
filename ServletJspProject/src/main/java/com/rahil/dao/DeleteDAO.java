package com.rahil.dao;

import java.sql.SQLException;

public class DeleteDAO {

	DatabaseConnection db = new DatabaseConnection();
	
	public int deleteItem(String username, int itemid)
	{
		String sql = "delete from cart where username = '" + username + "' and itemid = '" + itemid + "'";
		int deletecount = 0;
		db.connect_db();
		try 
		{
			db.st = db.con.createStatement();
			deletecount = db.st.executeUpdate(sql);
			System.out.println("rows deleted " + deletecount );
			return deletecount;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			db.close_db();
		}
		
		return deletecount;
	}
	
	
	
}
