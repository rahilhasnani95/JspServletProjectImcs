package com.rahil.dao;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.mysql.cj.jdbc.Blob;
import com.rahil.model.ProductBean;

public class ProductDAO {

	DatabaseConnection db = new DatabaseConnection();
	public void updateQuantityOfProductAdmin(String itemname, int itemprice, int itemquantity)
	{
		String sql = "insert into items (itemname, itemprice, itemquantity) values ('" + itemname + "', '" + itemprice + "', '" + itemquantity + "')"; 
		db.connect_db();
		
		try {
			db.st = db.con.createStatement();
			db.st.executeUpdate(sql);
		}
		 catch (Exception e) {
				e.printStackTrace();
		}
		finally {
				db.close_db();
		}	
			
	}
	
	public void updateQuantityOfProductAdmin(int itemid, int quantity)
	{
		String sql = "update items set itemquantity = '" + quantity + "' where itemid = '" + itemid + "'";
		db.connect_db();
		
		try {
			db.st = db.con.createStatement();
			db.st.executeUpdate(sql);
			System.out.println("updated qty by admin");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}	
	}
	
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
	
	public List<ProductBean> getAllProductsforAdmin()
	{
		List<ProductBean> allproductlist = new ArrayList<ProductBean>();
		
		String sql1 = "select * from items";
		db.connect_db();	
		try {
			db.st = db.con.createStatement();
			db.rs = db.st.executeQuery(sql1);
			if(!db.rs.next())
			{
				return allproductlist;
			}
			db.rs = null;
			db.rs = db.st.executeQuery(sql1);

			while(db.rs.next())
			{
				ProductBean productbean = new ProductBean();
				productbean.setItemid(db.rs.getInt(1));
				productbean.setItemname(db.rs.getString(2));
				productbean.setItemprice(db.rs.getInt(3));
				productbean.setItemimage(db.rs.getBlob(4));
				productbean.setItemquantity(db.rs.getInt(5));
				
				allproductlist.add(productbean);
			}		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.close_db();
		}
		
		return allproductlist;
	}
	
}
