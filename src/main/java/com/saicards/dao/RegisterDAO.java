package com.saicards.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.saicards.model.Customer;

public class RegisterDAO {
	
	private Connection con;

	public RegisterDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saicards", "root", "ujwal@123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Database Connection Error:"+e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Database ConnectionURL Error:"+e);
		}
		
	}
	
	public boolean saveCustomer(Customer cust) {
		
		// Create query for inserting record 
		String sql = "insert into customer (f_name,l_name,address,mob_no,email,password,city,pincode) values(?,?,?,?,?,?,?,?)";
		try {
			//Create object of prepare statement
			PreparedStatement stm = con.prepareStatement(sql);
			
			//Sets all parameter of prepare statement
			stm.setString(1, cust.getF_name());
			stm.setString(2, cust.getL_name());
			stm.setString(3,cust.getAddress());
			stm.setString(4,cust.getMob_no());
			stm.setString(5,cust.getEmail());
			stm.setString(6,cust.getPassword());
			stm.setString(7,cust.getCity());
			stm.setString(8,cust.getPincode());
			
			//Execute prepare statement
			stm.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SaveCustomer Statement Error:"+e);
		}
		
		return false;
	}
	
public boolean checkLogin(Customer cust) {
	//Create query for fetch the user
	String sql = "select * from customer where email = (?) and password = (?)";
	
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, cust.getEmail());
		stm.setString(2,cust.getPassword());
		
		ResultSet rs = stm.executeQuery();
		
		if (rs.next()) {
			return true;
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}


public Customer getCustomerById(String email) {
	
	String sql = "select * from customer where email=(?)";
	
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, email);
		ResultSet rs = stm.executeQuery();
		rs.next();
		
		Customer c = new Customer();
		c.setF_name(rs.getString("f_name"));
		c.setL_name(rs.getString("l_name"));
		c.setAddress(rs.getString("address"));
		c.setCity(rs.getString("city"));
		c.setCust_id(rs.getInt("cust_id"));
		c.setEmail(rs.getString("email"));
		c.setMob_no(rs.getString("mob_no"));
		c.setPincode(rs.getString("pincode"));
		
		System.out.println(c);
		
		return c;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("getCustById Error"+e.getMessage());
	}
	return null;
	
}
	
public boolean ChangePassword (String oldpassword, String newpassword, String Email) {
	String sql = "Update customer set password = (?) where password = (?) and email = (?)";
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1,newpassword);
		stm.setString(2,oldpassword);
		stm.setString(3,Email);
		int n = stm.executeUpdate();
		if(n!=0) {
			return true;
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("change password error "+e.getMessage());
	}
	
	return false;
	
}

public int getLastCustId() {
	
	String sql = "select max(cust_id)from customer";
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		rs.next();
		int id = rs.getInt(1);
		return id;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("getLastCustIdErrror"+e.getMessage());
	}
	return -1;
}

public boolean createCart(int cust_id) {
	
	String sql = "insert into cart(cust_id) values (?)";
	
	
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setInt(1, cust_id);
		stm.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("createCartErrror"+e.getMessage());
	}
	
	
	return false;
	
}

public boolean checkAdminLogin(String email , String password) {
	//Create query for fetch the user
	String sql = "select * from admin where email = (?) and password = (?)";
	
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, email);
		stm.setString(2,password);
		
		ResultSet rs = stm.executeQuery();
		
		if (rs.next()) {
			return true;
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}
	

}
