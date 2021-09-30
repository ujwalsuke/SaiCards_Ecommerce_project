package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.saicards.model.Customer;

/**
 * Servlet implementation class GetCustomer
 */

public class GetCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get of getCustomer");
		HttpSession session = request.getSession();
		Customer c = (Customer) session.getAttribute("Cust");
		JSONObject obj = new JSONObject();
		if (c!=null) {
			obj.put("name", c.getF_name()+" "+c.getL_name());
			obj.put("email", c.getEmail());
			obj.put("mob_no",c.getMob_no());
			
			
		}
		
		PrintWriter out = response.getWriter();
		out.println(obj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
