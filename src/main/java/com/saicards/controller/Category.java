package com.saicards.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.dao.CategoryDAO;
import com.saicards.model.*;

/**
 * Servlet implementation class Category
 */
//@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in doget of addCategory");
		CategoryDAO cdao = new CategoryDAO();
		JSONArray list = cdao.getAllCategories();
		

		PrintWriter out = response.getWriter();
		
		out.println(list);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in dopost of addCategory");
		String category = request.getParameter("category");
		
		CategoryModel c = new CategoryModel();
		c.setCategory_name(category);
		
		CategoryDAO cdao = new CategoryDAO();
		JSONObject obj = new JSONObject();
		if (cdao.saveCategory(c)) {
			
			obj.put("Status", "Success");
			
		} else {
			obj.put("Status", "Fail");

		}
		
		PrintWriter out = response.getWriter();
		
		out.println(obj);
		
		
		
	}

}
