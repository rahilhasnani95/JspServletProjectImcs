package com.rahil.dao;

import java.sql.SQLException;


public class CheckoutDAO {

	DatabaseConnection db = new DatabaseConnection();
	
	public int checkAnyItemInCartNotInStock(String username)
	{
		int noofrowsincheckitemexist =0;
		String sql = "select itemid, itemquantity from cart where username = '" + username + "'";
		try
		{ 
			int newqty =0; 
			db.connect_db();db.st = db.con.createStatement();db.st2 = db.con.createStatement();
			db.rs = db.st.executeQuery(sql);
			int qntincart = 0;int qntinitems = 0;
			
			while(db.rs.next())
			{
				int id = db.rs.getInt(1);
				qntincart = db.rs.getInt(2);
				String sql1 = "select itemquantity from items where itemid = '" + id + "'";
				db.rs2 = db.st2.executeQuery(sql1);		
				if(db.rs2.next())
				{
					qntinitems = db.rs2.getInt(1);
					newqty = qntinitems - qntincart;
					if(newqty < 0)
					{
						++noofrowsincheckitemexist;
						return noofrowsincheckitemexist;
					}
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		return noofrowsincheckitemexist;	
	}	
	
	public int updateProducts(String username)
	{
		int noofrowsupdated = 0;
		String sql = "select itemid, itemquantity from cart where username = '" + username + "'";
		try
		{
			db.connect_db();db.st = db.con.createStatement();db.st2 = db.con.createStatement();db.st3 = db.con.createStatement();
			int qntincart = 0;int qntinitems = 0;
			db.rs = db.st.executeQuery(sql);
			
			while(db.rs.next())
			{
				int id = db.rs.getInt(1);
				qntincart = db.rs.getInt(2);
				System.out.println(id);System.out.println(qntincart);
				
				String sql1 = "select itemquantity from items where itemid = '" + id + "'";
				db.rs2 = db.st2.executeQuery(sql1);
				if(db.rs2.next())
				{
					qntinitems = db.rs2.getInt(1);
				}
				int newquantity = qntinitems - qntincart;
			
				String sql2 = "update items set itemquantity = '" + newquantity + "' where itemid = '" + id + "'";
				noofrowsupdated = db.st3.executeUpdate(sql2);
				
				System.out.println("updated in itemstable" + noofrowsupdated);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			db.close_db();
		}
		return noofrowsupdated;
	}
	
	public int removeDetailsFromCart(String username)
	{
		int rowsdeleted = 0;
		String sql3 = "delete from cart where username = '" + username + "'";
		try
		{
			db.connect_db();

			db.st = db.con.createStatement();
			rowsdeleted = db.st.executeUpdate(sql3);
			System.out.println("deleted rows from cart " + rowsdeleted);
 			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			db.close_db();
		}
		return rowsdeleted;
		
	}
	
	
	
	
	
}
