package com.saicards.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saicards.dao.OrderItemDAO;
import com.saicards.dao.ProductDAO;
import com.saicards.model.Customer;
import com.saicards.model.OrderItem;
import com.saicards.model.ProductModel;
import com.saicards.utility.Storage;

/**
 * Servlet implementation class GetOrderItems
 */

public class GetOrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer c = (Customer) session.getAttribute("Cust");
		int cust_id = c.getCust_id();
		JSONArray itemList = new JSONArray();
		
		OrderItemDAO ordao = new OrderItemDAO();
		ProductDAO pdao = new ProductDAO();
		Storage mycloud = new Storage();
		
		List<Integer> list = ordao.getOrderList(cust_id);
		System.out.println(list);
		
		for(int i:list) {
			List<OrderItem> oritemList = ordao.getOrderItemList(i);
			for(OrderItem item:oritemList) {
				JSONObject obj = new JSONObject();
				ProductModel p = pdao.getProductBYId(item.getP_id());
				obj.put("item_id", item.getItem_id());
				obj.put("order_id", item.getOrder_id());
				obj.put("p_name", p.getName());
				obj.put("qty", item.getQty());
				obj.put("price", item.getPrice());
				obj.put("imgdata", mycloud.getPhoto(item.getP_id()));
				obj.put("status", item.getStatus());
				
				itemList.add(obj);
				
			}
			
			
		}
		
		PrintWriter out = response.getWriter();
		out.println(itemList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
