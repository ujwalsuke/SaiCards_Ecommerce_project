package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.saicards.dao.CategoryDAO;
import com.saicards.dao.ProductDAO;

/**
 * Servlet implementation class DeleteCategory
 */

public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DOPOST of delCat");
		int cata_id = Integer.parseInt(request.getParameter("id"));
		
		ProductDAO pdao = new ProductDAO();
		CategoryDAO cdao = new CategoryDAO();
		JSONObject obj = new JSONObject();
				
		if(pdao.deleteProductsById(cata_id)) {
			if(cdao.deleteCategoryById(cata_id)) {
				obj.put("Status", "Success");
			}else {
				obj.put("Status", "Fail");
			}
		}else {
			obj.put("Status", "Fail");
		}
		
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

}
