package com.quespro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quespro.repository.OrderDAO;
import com.quespro.repository.OrderRequestDTO;
import com.quespro.repository.ProductDAO;

@Service
public class OrderService {
	@Autowired
	ProductDAO productdao;
	@Autowired
	OrderDAO orderDAO;

	public String createOrder(OrderRequestDTO orderRequest) {
		int orderId = orderDAO.insertOrder(orderRequest);

		if (orderId > 0) {
			orderDAO.insertOrderItems(orderId, orderRequest.getItems());
			return "Order placed successfully. Order ID: " + orderId;
		} else {
			return "Failed to place order.";
		}
	}
}
