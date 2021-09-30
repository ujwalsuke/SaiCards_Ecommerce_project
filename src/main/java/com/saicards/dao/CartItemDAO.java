package com.saicards.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.model.CartItemModel;
import com.saicards.model.ProductModel;
import com.saicards.utility.Storage;

public class CartItemDAO {
	
	private Connection con;

	public CartItemDAO() {
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
	
	public int getCartIdByCustId(int cust_id) {
		String sql = "select cart_id from cart where cust_id=(?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, cust_id);
			System.out.println(cust_id+"xxxxxxxxxx");
			ResultSet rs = stm.executeQuery();
			rs.next();
			int cart_id = rs.getInt(1);
			return cart_id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getCartIdByCustId"+e.getMessage());
		}
		
		return -1;
	}
	
	public boolean saveCartItem(CartItemModel c) {
		String sql = "insert into cartitem (cart_id,p_id,qty) values(?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,c.getCart_id());
			stm.setInt(2,c.getP_id());
			stm.setInt(3,c.getQty());
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("saveCartItemError"+e.getMessage());
		}
		
		return false;
		
		
	}
	
public HashMap<Integer,Integer> getMap(int cartId) {
		
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		
		String query = "select item_id,p_id from cartitem where cart_id=(?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, cartId);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				hm.put(rs.getInt("p_id"), rs.getInt("item_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return hm;
		
	}

public boolean incrementByItemId(int itemId) {
	String query = "update cartitem set qty=qty+1 where item_id=(?)";
	
	try {
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, itemId);
		stm.executeUpdate();
		
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
}

public boolean decrementByItemId(int itemId) {
	String query = "update cartitem set qty=qty-1 where item_id=(?)";
	
	try {
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, itemId);
		stm.executeUpdate();
		
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
}

public JSONArray getCartItems(int cart_id) {
	JSONArray list = new JSONArray();
	Storage mycloud = new Storage();
	
	String sql = "select * from cartitem  where cart_id="+cart_id+" order by item_id desc";
	System.out.println(sql);
	
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			JSONObject obj = new JSONObject();
			obj.put("p_id",rs.getInt("p_id") );
			obj.put("item_id", rs.getString("item_id"));
			obj.put("cart_id", rs.getInt("cart_id"));
			obj.put("qty", rs.getInt("qty"));
			
			obj.put("imgdata",mycloud.getPhoto(rs.getInt("p_id")));
			
			ProductModel p = new ProductDAO().getProductBYId(rs.getInt("p_id"));
			obj.put("p_name", p.getName());
			obj.put("price", p.getPrice());
			
			list.add(obj);
			System.out.println(obj);
			
			
		}
		System.out.println(list);
		
		return list;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("getAllCartItems"+e.getMessage());
		
	}
	
	return null;
	
	
}

public List<CartItemModel> getCartItemsList(int cart_id) {
	List<CartItemModel> list = new ArrayList();
	Storage mycloud = new Storage();
	
	String sql = "select * from cartitem  where cart_id="+cart_id+" order by item_id desc";
	System.out.println(sql);
	
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			CartItemModel cm = new  CartItemModel();
			cm.setCart_id(rs.getInt("cart_id"));
			cm.setItem_id( rs.getInt("item_id"));
			cm.setP_id(rs.getInt("p_id") );
			cm.setQty( rs.getInt("qty"));
			
			list.add(cm);
			
			
			
		}
		System.out.println(list);
		
		return list;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("getAllCartItemsList"+e.getMessage());
		
	}
	
	return null;
	
	
}

public boolean deleteCartById(int cartId) {
	
	String query = "delete from cartitem where cart_id=(?)";
	
	try {
		PreparedStatement stm = con.prepareStatement(query);
		stm.setInt(1, cartId);
		stm.executeUpdate();
		return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

}
