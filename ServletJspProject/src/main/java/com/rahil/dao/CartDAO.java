package com.rahil.dao;

import java.util.ArrayList;
import java.util.List;

import com.rahil.model.ProductBean;
import com.rahil.servlet.ProductServlet;

public class CartDAO {

	DatabaseConnection db = new DatabaseConnection();

	public int addToCart(String username, int itemid, String itemname, int qty, int itemprice)
	{	
		db.connect_db();
		int rowcount = 0;
		try
		{
			int totalprice = itemprice*qty;
			db.st = db.con.createStatement();
			db.st2 = db.con.createStatement();
			db.st3 = db.con.createStatement();
			
			String sql1 = "select username, itemid from cart where username = '" + username + "' and itemid = '" + itemid + "'";
			String sql2 = "update cart set itemquantity = '"+qty+ "', totalprice = '"+totalprice+"' where username = '"+username+"' and itemid = '"+itemid+"'" ;
			String sql3 = "insert into cart values ('" + username + "', '" + itemid + "', '" + itemname + "', '" + qty + "', '" + totalprice + "')";

			db.rs = db.st.executeQuery(sql1);
					
			if(db.rs.next())
			{
			rowcount = db.st2.executeUpdate(sql2);
			System.out.println("updated table");
			}
			else
			{
			rowcount = db.st3.executeUpdate(sql3);
			System.out.println("inserted in table");	
			}
		
			return rowcount;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		return rowcount;
	}

}


