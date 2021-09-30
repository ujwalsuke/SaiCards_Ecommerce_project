package com.saicards.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.model.ProductModel;
import com.saicards.utility.Storage;

public class ProductDAO {
	private Connection con;

	public ProductDAO() {
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
	
	public boolean saveProduct(ProductModel p) {
		
		String sql = "insert into products(name,cata_id,price)values(?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, p.getName());
			stm.setInt(2, p.getCata_id());
			stm.setInt(3,p.getPrice());
			
			stm.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SaveProductError"+e.getMessage());
		}
		
		return false;
	}
	
	public int getLastProductId() {
		
		String sql = "select max(p_id)from products";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			int id = rs.getInt(1);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getLastProductIdErrror"+e.getMessage());
		}
		return -1;
	}
	
	public JSONArray getProducts() {
		JSONArray list = new JSONArray();
		Storage mycloud = new Storage();
		
		String sql = "select * from products order by p_id desc";
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("p_id",rs.getInt("p_id") );
				obj.put("p_name", rs.getString("name"));
				obj.put("cata_id", rs.getInt("cata_id"));
				obj.put("p_price",rs.getInt("price"));
				obj.put("imgdata",mycloud.getPhoto(rs.getInt("p_id")));
				
				list.add(obj);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getAllProducts"+e.getMessage());
			
		}
		
		return null;
		
		
	}
	
	public ProductModel getProductBYId(int id) {
		
		String sql = "select * from products where p_id=?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				ProductModel p = new ProductModel();
				p.setCata_id(rs.getInt("cata_id"));
				p.setName(rs.getString("name"));
				p.setP_id(rs.getInt("p_id"));
				p.setPrice(rs.getInt("price"));
				
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getProductBYId"+e.getMessage());
		}
		
		return null;
		
		
	}
	
	public boolean deleteProductsById(int id) {
		
		String sql = "delete from products where cata_id=(?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public JSONArray getProductsByCategory(int cata_id) {
		JSONArray list = new JSONArray();
		Storage mycloud = new Storage();
		
		String sql = "select * from products where cata_id="+cata_id+" order by p_id desc";
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("p_id",rs.getInt("p_id") );
				obj.put("p_name", rs.getString("name"));
				obj.put("cata_id", rs.getInt("cata_id"));
				obj.put("p_price",rs.getInt("price"));
				obj.put("imgdata",mycloud.getPhoto(rs.getInt("p_id")));
				
				list.add(obj);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getAllProducts"+e.getMessage());
			
		}
		
		return null;
		
		
	}
	

}
