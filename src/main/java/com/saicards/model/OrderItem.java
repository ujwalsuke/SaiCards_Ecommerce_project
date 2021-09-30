package com.saicards.model;

public class OrderItem {
	
	private int item_id;
	private int order_id;
	private int p_id;
	private int price;
	private int qty;
	private String status;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderItem [item_id=" + item_id + ", order_id=" + order_id + ", p_id=" + p_id + ", price=" + price
				+ ", qty=" + qty + ", status=" + status + "]";
	}
	
		
	
	

}
