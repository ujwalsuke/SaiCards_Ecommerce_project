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
 * Servlet implementation class ChangePassword
 */

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("I am changing password");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword = request.getParameter("old_password");
		String newpassword = request.getParameter("new_password");
		System.out.println(oldpassword+newpassword);
		HttpSession session = request.getSession();
		Customer c =(Customer) session.getAttribute("Cust");
		String email = c.getEmail();
        RegisterDAO rdao = new RegisterDAO();
        JSONObject obj = new JSONObject();
        
        
        if (rdao.ChangePassword(oldpassword, newpassword, email)) {
        	obj.put("Status","Success");
        	
			
		} else {
			obj.put("Status","Fail");
		}
        PrintWriter out = response.getWriter();
        out.println(obj);
        
	}

	
}
