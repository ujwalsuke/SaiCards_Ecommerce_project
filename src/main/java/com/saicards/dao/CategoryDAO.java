package com.saicards.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.model.CategoryModel;

public class CategoryDAO {
	private Connection con;

	public CategoryDAO() {
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
	
	public boolean saveCategory(CategoryModel c) {
		
		String sql = "insert into category (category_name) values (?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,c.getCategory_name());
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("AddCategoryError"+e.getMessage());
		}
		
		return false;
		
	}
	
	public JSONArray getAllCategories() {
		
		String sql = "select * from category";
		
		JSONArray list = new JSONArray();
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("cata_id"));
				obj.put("category_name",rs.getString("category_name"));
				
				list.add(obj);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("GetCategoriesError"+e.getMessage());
		}
		
		return null;
		
	}
	
	public boolean deleteCategoryById(int id) {
		
		String sql = "delete from category where cata_id=(?)";
		
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
	
	

}
