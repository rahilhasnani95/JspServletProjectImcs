package com.rahil.model;

import com.mysql.cj.jdbc.Blob;

public class ProductBean {

	private int itemid;
	private String itemname;
	private int itemprice;
	private int itemquantity;
	private java.sql.Blob itemimage;
	public ProductBean() {
		super();
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public int getItemquantity() {
		return itemquantity;
	}
	public void setItemquantity(int itemquantity) {
		this.itemquantity = itemquantity;
	}
	public java.sql.Blob getItemimage() {
		return itemimage;
	}
	public void setItemimage(java.sql.Blob itemimage) {
		this.itemimage = itemimage;
	}
	@Override
	public String toString() {
		return "ProductBean [itemid=" + itemid + ", itemname=" + itemname + ", itemprice=" + itemprice
				+ ", itemquantity=" + itemquantity + ", itemimage=" + itemimage + "]";
	}
	

	
}
