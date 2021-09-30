package com.saicards.model;

public class ProductModel {
	private int p_id;
	private String name;
	private int cata_id;
	private int price;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCata_id() {
		return cata_id;
	}
	public void setCata_id(int cata_id) {
		this.cata_id = cata_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", name=" + name + ", cata_id=" + cata_id + ", price=" + price + "]";
	}
	
	

}
