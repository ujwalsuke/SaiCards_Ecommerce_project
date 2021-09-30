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

import com.saicards.dao.RegisterDAO;
import com.saicards.model.Customer;

/**
 * Servlet implementation class CheckAdminLogin
 */

public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminLogin() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		RegisterDAO rdao = new RegisterDAO();
		JSONObject obj = new JSONObject();
		if (rdao.checkAdminLogin(email, password)) {
			
			
			
			HttpSession session = request.getSession();
			session.setAttribute("adminEmail", email);
			
			obj.put("Status", "Success");
			
		} else {
			obj.put("Status", "Fail");

		}
		
		PrintWriter out = response.getWriter();
		
		out.println(obj);
	}

}
