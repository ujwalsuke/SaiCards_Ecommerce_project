package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.dao.CartItemDAO;
import com.saicards.model.CartItemModel;
import com.saicards.model.Customer;

/**
 * Servlet implementation class CartItem
 */

public class CartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in doget of CartItem");
		HttpSession session = request.getSession();
		Customer cust = (Customer) session.getAttribute("Cust");
		int cart_id = new CartItemDAO().getCartIdByCustId(cust.getCust_id());
		System.out.println(cart_id);
		JSONArray list = new CartItemDAO().getCartItems(cart_id);
		
		PrintWriter out = response.getWriter();
		out.println(list);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer c = (Customer)session.getAttribute("Cust");
		JSONObject obj = new JSONObject();
		if (c==null) {
			obj.put("Status", "Fail");
			
		} else {
			
			int p_id = Integer.parseInt(request.getParameter("p_id"));
			System.out.println(p_id);
			CartItemModel ct = new CartItemModel();
			CartItemDAO ctdao = new CartItemDAO();
			ct.setCart_id(ctdao.getCartIdByCustId(c.getCust_id()));
			ct.setP_id(p_id);
			ct.setQty(1);
			
			HashMap< Integer, Integer> hm = ctdao.getMap(ctdao.getCartIdByCustId(c.getCust_id()));
			if (hm.containsKey(p_id)) {
				
				int item_id = (int)hm.get(p_id);
				ctdao.incrementByItemId(item_id);
				obj.put("Status", "Success");
				
			} else {
				ctdao.saveCartItem(ct);
				obj.put("Status", "Success");
				

			}

		}
		
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

}
