package com.saicards.model;

public class Customer {
	private int cust_id;
	private String f_name;
	private String l_name;
	private String address;
	private String mob_no;
	private String email;
	private String password;
	private String city;
	private String pincode;
	
	
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", f_name=" + f_name + ", l_name=" + l_name + ", address=" + address
				+ ", mob_no=" + mob_no + ", email=" + email + ", password=" + password + ", city=" + city + ", pincode="
				+ pincode + "]";
	}
	
	
	
	

}
