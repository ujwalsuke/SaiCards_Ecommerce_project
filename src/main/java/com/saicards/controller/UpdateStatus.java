package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.saicards.dao.OrderItemDAO;

/**
 * Servlet implementation class UpdateStatus
 */

public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
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
		int id = Integer.parseInt(request.getParameter("item_id"));
		int status_id = Integer.parseInt(request.getParameter("status"));
		String status ="";
		
		if (status_id==0) {
			status="Cancelled";
			
		} else {
			status = "Dispatched";

		}
		
		OrderItemDAO ordao = new OrderItemDAO();
		if (ordao.updateStatus(id, status)) {
			JSONObject obj =new  JSONObject();
			obj.put("status", "success");
			
			PrintWriter out = response.getWriter();
			out.println(obj);
			
		}
		
		
		
	}

}
