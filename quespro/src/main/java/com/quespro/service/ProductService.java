package com.quespro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quespro.repository.ProductDAO;
import com.quespro.repository.Product_DTO;

@Service
public class ProductService {
	
	 private final ProductDAO productdao;

	    public ProductService(ProductDAO productdao) {
	        this.productdao = productdao;
	    }
	
	 public String addGroceryItems(List<Product_DTO> products) {
	        int[] result = productdao.addGroceryItems(products);
			return result.length > 0 ? "Items added successfully!" : "Failed to add items.";
	       
	    }
	 
	 public String updateItem(List<Product_DTO> products) {
	        int updatedRows = productdao.updateProductItem(products);
	        return (updatedRows > 0) ? "Product updated successfully." : "Product not found.";
	    }
	 
	 public String removeItems(List<Integer>id) {
		 int result =productdao.removeitemsById(id);
		 System.out.println("found Result:"+result);
		 if(result>0) {
			 return"Products deleted successfully.";
		 }
		 else {
			 return"No products found with given IDs.";
		 }
	 }		 
		

}
