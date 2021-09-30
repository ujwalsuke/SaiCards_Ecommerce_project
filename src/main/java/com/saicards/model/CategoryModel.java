package com.saicards.model;

public class CategoryModel {
	private int cata_id;
	private String category_name;
	public int getCata_id() {
		return cata_id;
	}
	public void setCata_id(int cata_id) {
		this.cata_id = cata_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "Category [cata_id=" + cata_id + ", category_name=" + category_name + "]";
	} 

}
