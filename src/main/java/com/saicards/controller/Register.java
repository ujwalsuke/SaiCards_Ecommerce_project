package com.saicards.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saicards.dao.RegisterDAO;
import com.saicards.model.Customer;

/**
 * Servlet implementation class Register
 */

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Getting submitted data from request object
		String f_name = request.getParameter("f_name");
		String l_name = request.getParameter("l_name");
		String address = request.getParameter("address");
		String mob_no = request.getParameter("mob_no");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		
		// Sets data to Customer model using setter method
		Customer cust = new Customer();
		cust.setF_name(f_name);
		cust.setL_name(l_name);
		cust.setAddress(address);
		cust.setEmail(email);
		cust.setMob_no(mob_no);
		cust.setPassword(password);
		cust.setCity(city);
		cust.setPincode(pincode);
		
		//Create object of RegisterDAO
		RegisterDAO rdao = new RegisterDAO();
		
		//Called saveCustomer method of object of RegisterDAO
		
		if (rdao.saveCustomer(cust)) {
			
			int cust_id = rdao.getLastCustId();
			rdao.createCart(cust_id);
			System.out.println(cust_id);
			System.out.println("Registration successfull");
			response.sendRedirect("login.jsp");
			
		} else {
			System.out.println("Registration Fail");

		}
		
	}

}
