package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.saicards.dao.CartItemDAO;

/**
 * Servlet implementation class UpdateQty
 */

public class UpdateQty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQty() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in post of UpdateQty");
		int item_id = Integer.parseInt(request.getParameter("id"));
		int flag = Integer.parseInt(request.getParameter("flag"));
		CartItemDAO crtdao = new CartItemDAO();
		JSONObject obj = new JSONObject();
		
		if (flag==0) {
			crtdao.decrementByItemId(item_id);
			obj.put("Status", "Success");
		} else {
			crtdao.incrementByItemId(item_id);
			obj.put("Status", "Success");

		}
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

}
