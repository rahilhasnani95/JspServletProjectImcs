package com.rahil.model;

public class CartBean {

	private String username;
	private int itemid;
	private int itemquantity;
	private int totalprice;
	private String itemname;
	
	public CartBean() {
		
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getItemquantity() {
		return itemquantity;
	}
	public void setItemquantity(int itemquantity) {
		this.itemquantity = itemquantity;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "CartBean [username=" + username + ", itemid=" + itemid + ", itemquantity=" + itemquantity
				+ ", totalprice=" + totalprice + "]";
	}
	
	
	
	
	
	
}
