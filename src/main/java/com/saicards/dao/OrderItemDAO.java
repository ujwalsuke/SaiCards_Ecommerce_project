package com.saicards.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.model.CartItemModel;
import com.saicards.model.OrderItem;
import com.saicards.model.ProductModel;
import com.saicards.utility.Storage;

public class OrderItemDAO {
	private Connection con;

	public OrderItemDAO() {
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
	
	public boolean saveOrder(int cust_id) {
		
		String sql = "insert into custorder(cust_id) values(?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, Integer.toString(cust_id));
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
public boolean saveOrderItem(OrderItem item) {
		
		String query = "insert into orderitem(order_id,p_id,price,qty,status)values(?,?,?,?,?)";
		
		PreparedStatement stm;
		try {
			
			stm = con.prepareStatement(query);
			stm.setInt(1,item.getOrder_id());
			stm.setInt(2,item.getP_id());
			stm.setInt(3,item.getPrice());
			stm.setInt(4,item.getQty());
			stm.setString(5,item.getStatus());
			
			
			
			stm.executeUpdate();
			
			stm.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

public int getLastOrderId() {
	String query = "select max(order_id) from custorder";
	
	Statement stm;
	try {
		stm = con.createStatement();
		ResultSet rs=stm.executeQuery(query);
        rs.next();
        int orderId=rs.getInt(1);
        
        stm.close();
        rs.close();
        
        return orderId;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	
	return -1;
}
public List<Integer> getOrderList(int cust_id) {
	List<Integer> list = new ArrayList();
	
	
	String sql = "select * from custorder  where cust_id="+cust_id+" order by order_id desc";
	System.out.println(sql);
	
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			list.add(rs.getInt("order_id"));	
			
			
		}
		System.out.println(list);
		
		return list;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("getorderList"+e.getMessage());
		
	}
	
	return null;
	
	
}

public List<OrderItem> getOrderItemList(int order_id) {
	List<OrderItem> list = new ArrayList();
	
	
	String sql = "select * from orderitem  where order_id="+order_id+" order by item_id desc";
	System.out.println(sql);
	
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			OrderItem oritem = new OrderItem();
			oritem.setItem_id(rs.getInt("item_id"));
			oritem.setOrder_id(rs.getInt("order_id"));
			oritem.setP_id(rs.getInt("p_id"));
			oritem.setPrice(rs.getInt("price"));
			oritem.setQty(rs.getInt("qty"));
			oritem.setStatus(rs.getString("status"));
			
			list.add(oritem);
			
			
				
			
			
		}
		System.out.println(list);
		
		return list;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("getorderList"+e.getMessage());
		
	}
	
	return null;
	
	
}

public JSONArray getJsonArrayOrder() {
	JSONArray list = new JSONArray();
	Storage mycloud = new Storage();
	String sql = "select * from orderitem order by item_id desc";
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()) {
			
			JSONObject obj = new JSONObject();
			ProductDAO pdao = new ProductDAO();
			ProductModel p = pdao.getProductBYId(rs.getInt("p_id")) ;
			
			obj.put("item_id",rs.getInt("item_id") );
			obj.put("order_id", rs.getInt("order_id"));
			obj.put("price", rs.getInt("price"));
			obj.put("qty", rs.getInt("qty"));
			obj.put("status", rs.getString("status"));
			obj.put("p_name",p.getName() );
			obj.put("imgdata", mycloud.getPhoto(rs.getInt("p_id")));
			
			list.add(obj);
			
			
			
		}
		return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public boolean updateStatus(int id,String status) {
	
	String sql = "update orderitem set status=? where item_id=?";
	
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, status);
		stm.setInt(2, id);
		stm.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}



}
