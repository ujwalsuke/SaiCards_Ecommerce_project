package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Servlet implementation class CreateOrder
 */

public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrder() {
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
		System.out.println("Post of Createorder");
		int amount = Integer.parseInt(request.getParameter("amount"));
		org.json.simple.JSONObject obj = new org.json.simple.JSONObject();
		try {
			RazorpayClient rz = new RazorpayClient("rzp_test_KmycnDS3FGyZ4v", "f2NUl80Bi7iLEdWDHDUfFDJI");
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			
			Order order = rz.Orders.create(orderRequest);
			
			
			obj.put("Status", "Success");
			
			
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Razorpay order Error"+e.getMessage());
		}
		
		PrintWriter out = response.getWriter();
		out.println(obj);
		
		
		
	}

}
