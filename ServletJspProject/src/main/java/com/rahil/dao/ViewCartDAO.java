package com.rahil.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rahil.model.CartBean;


public class ViewCartDAO {

	DatabaseConnection db = new DatabaseConnection();
	
	public List<CartBean> getCart(String username)
	{
		List<CartBean> cartlist = new ArrayList<CartBean>();
		String sql = "select * from cart where username = '" + username + "'";
		db.connect_db();

		try 
		{
			db.st = db.con.createStatement();
			db.rs = db.st.executeQuery(sql);
			
			if(!db.rs.next())
			{
				return cartlist;
			}
			db.rs = null;
			db.rs = db.st.executeQuery(sql);
			
			while(db.rs.next())
			{
				CartBean cartbean = new CartBean();
				cartbean.setItemid(db.rs.getInt(2));
				cartbean.setItemname(db.rs.getString(3));
				cartbean.setItemquantity(db.rs.getInt(4));
				cartbean.setTotalprice(db.rs.getInt(5));
				cartlist.add(cartbean);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		
	return cartlist;	
		
	}

}
