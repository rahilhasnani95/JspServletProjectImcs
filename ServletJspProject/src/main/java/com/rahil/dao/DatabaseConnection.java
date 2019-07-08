package com.rahil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	String url = "jdbc:mysql://localhost:3306/rahilimcs";
	String username = "root";
	String password= "Rahil1234";
	//String sql = "select * from users where username = ? and password = ?";
	
	PreparedStatement prepst = null;
	Statement st = null;
	Statement st2 = null;
	Statement st3 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	Connection con = null;
	
	public void connect_db()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);					
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void close_db()
	{
		try
		{
			if(con!=null) {
				con.close();
			}
			if(prepst!=null) {
				prepst.close();
			}
			if(st!=null) {
				st.close();
			}
			if(st2!=null) {
				st2.close();
			}
			if(st3!=null) {
				st3.close();
			}
			if(rs!=null) {
				rs.close();
			}
			if(rs2!=null) {
				rs2.close();
			}
			if(rs3!=null) {
				rs3.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
