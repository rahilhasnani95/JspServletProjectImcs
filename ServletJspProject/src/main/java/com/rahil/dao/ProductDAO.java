package com.rahil.dao;

import java.util.ArrayList;
import java.util.List;

import com.rahil.model.ProductBean;

public class ProductDAO {

	DatabaseConnection db = new DatabaseConnection();
	//ProductBean productbean = new ProductBean();
	
	public List<ProductBean> getProducts()
	{
		List<ProductBean> list = new ArrayList<ProductBean>();
		
		String sql = "select * from items where itemquantity > 0";
		db.connect_db();
		
		try {
			db.st = db.con.createStatement();
		
			db.rs = db.st.executeQuery(sql);
			if(!db.rs.next())
			{
				return list;
			}
			db.rs = null;
			db.rs = db.st.executeQuery(sql);

			while(db.rs.next())
			{
				ProductBean productbean = new ProductBean();
				productbean.setItemid(db.rs.getInt(1));
				productbean.setItemname(db.rs.getString(2));
				productbean.setItemprice(db.rs.getInt(3));
				productbean.setItemimage(db.rs.getBlob(4));
				productbean.setItemquantity(db.rs.getInt(5));
				
				list.add(productbean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		
		return list;
	
	}
	
	
	
	
	
}
