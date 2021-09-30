package com.saicards.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;
import com.saicards.dao.CartItemDAO;
import com.saicards.dao.OrderItemDAO;
import com.saicards.dao.ProductDAO;
import com.saicards.model.Customer;
import com.saicards.model.OrderItem;
import com.saicards.model.ProductModel;
import com.saicards.model.CartItemModel;

/**
 * Servlet implementation class PlaceOrder
 */

public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in Placeorder");
		HttpSession session = request.getSession();
		Customer c = (Customer)session.getAttribute("Cust");
		CartItemDAO crtdao = new CartItemDAO();
		int cartId = crtdao.getCartIdByCustId(c.getCust_id());
		OrderItemDAO ordao = new OrderItemDAO();
		
		List<CartItemModel> list = crtdao.getCartItemsList(cartId);
		System.out.println(list);
		System.out.println(cartId);
		
		if (ordao.saveOrder(c.getCust_id())) {
			for(CartItemModel item:list) {
				
				OrderItem orditem =  new OrderItem();
				ProductDAO pdao = new ProductDAO();
				ProductModel p = pdao.getProductBYId(item.getP_id());
				
				orditem.setOrder_id(ordao.getLastOrderId());
				orditem.setP_id(item.getP_id());
				orditem.setPrice(p.getPrice());
				orditem.setQty(item.getQty());
				orditem.setStatus("Placed");
				
				System.out.println(item.getQty()+"gggggggggggg");
				
				ordao.saveOrderItem(orditem);
				
			}
			
			crtdao.deleteCartById(cartId);
			
		}
		
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
