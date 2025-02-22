package com.quespro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quespro.repository.OrderRequestDTO;
import com.quespro.repository.ProductDAO;
import com.quespro.repository.Product_DTO;
import com.quespro.service.OrderService;

@RestController
@RequestMapping("/questionpro/user")
public class UserController {
	@Autowired
	ProductDAO productdao;
	@Autowired
	private OrderService orderService;

	@GetMapping("/items")
	public List<Product_DTO> getAvailableItems() {
		List<Product_DTO> items = productdao.getItems();
		return items;
	}

	@PostMapping("/order")
	public String placeOrder(@RequestBody OrderRequestDTO orderRequest) {
		return orderService.createOrder(orderRequest);

	}
}
