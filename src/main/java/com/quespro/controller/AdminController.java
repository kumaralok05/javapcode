package com.quespro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quespro.repository.ProductDAO;
import com.quespro.repository.Product_DTO;
import com.quespro.service.ProductService;

@RestController
@RequestMapping("/questionpro/admin")
public class AdminController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	ProductService productservice;

	// view existing item
	@GetMapping("/items")
	public List<Product_DTO> getAvailableItems() {
		List<Product_DTO> items = productDAO.getItems();
		return items;

	}
	// adding new item in the db
	@PostMapping("/add-items")
	public String addItems(@RequestBody List<Product_DTO> products) {
		return productservice.addGroceryItems(products);

	}
	// remove item
	@DeleteMapping("/delete/{ids}")
	public String deleteItems(@RequestBody List<Integer> ids) {
		return productservice.removeItems(ids);
	}
	// update existing item
	@PutMapping("/update")
	public String updateItems(@RequestBody List<Product_DTO> products) {
		return productservice.updateItem(products);

	}
}
