package com.rahil.dao;

import java.sql.SQLException;

import com.rahil.model.UserBean;

public class UserDAO {
	DatabaseConnection db = new DatabaseConnection();
	
	public int registeringUser(String username, String password)
	{
		int rowsinserted=0;
		String sql = "select username from users where username = '" + username + "'";
		String sql2 = "insert into users values ('" + username + "', '" + password + "')";
		try
		{
			db.connect_db();
			db.st = db.con.createStatement();
		
			db.rs = db.st.executeQuery(sql);
			if(db.rs.next())
			{
				rowsinserted = 0;
				return rowsinserted;
			}
			else
			{
				rowsinserted = db.st.executeUpdate(sql2);
				return rowsinserted;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		return rowsinserted;
	}

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
