package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.dao.ProductDAO;
import com.saicards.model.ProductModel;
import com.saicards.utility.Storage;



/**
 * Servlet implementation class Products
 */

@MultipartConfig
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in doget of Products");
		
		ProductDAO pdao = new ProductDAO();
		JSONArray list = pdao.getProducts();
		
		PrintWriter out = response.getWriter();
		out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in products");
		String name = request.getParameter("pname");
		int cata_id = Integer.parseInt(request.getParameter("category"));
		int price = Integer.parseInt(request.getParameter("pprice"));
		
		ProductModel p = new ProductModel();
		p.setName(name);
		p.setCata_id(cata_id);
		p.setPrice(price);
		
		ProductDAO pdao = new ProductDAO();
		JSONObject obj = new JSONObject();
		if (pdao.saveProduct(p)) {
			int id = pdao.getLastProductId();
			Storage mycloud = new Storage();
			mycloud.savePhoto(request.getPart("pimage"), id);
			obj.put("Status", "Success");
			
		} else {
			obj.put("Status", "Fail");

		}
		
		PrintWriter out = response.getWriter();
		
		out.println(obj);
		
		
	}

}
