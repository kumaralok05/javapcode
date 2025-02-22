package com.quespro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quespro.service.DbConnection;


@RestController

@RequestMapping("/api")
public class MainController {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/user")
	public String ShowUserName() {
		DbConnection dbconnection=new DbConnection(jdbcTemplate);	
		dbconnection.testQuery();
		return "Alok";
		
	}

}
