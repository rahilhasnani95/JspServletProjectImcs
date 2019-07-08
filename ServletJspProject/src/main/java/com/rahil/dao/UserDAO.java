package com.rahil.dao;

import java.sql.SQLException;

import com.rahil.model.UserBean;

public class UserDAO {

	DatabaseConnection db = new DatabaseConnection();
	
	public boolean checkUser(String username, String password)
	{
		String sql = "select * from users where username = ? and password = ?";
		db.connect_db();
		
		try {
			db.prepst = db.con.prepareStatement(sql);
		
			db.prepst.setString(1, username);
			db.prepst.setString(2, password);
			
			db.rs = db.prepst.executeQuery();
			if(db.rs.next())
			{
				return true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		
		return false;
	
	}
	
	
	
	
	
}
