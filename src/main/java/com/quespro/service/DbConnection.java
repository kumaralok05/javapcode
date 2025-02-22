package com.quespro.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DbConnection {
	private final JdbcTemplate jdbcTemplate;

    public DbConnection(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testQuery() {
        List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT * FROM Employee");
        System.out.println(results.toString());
    }

}
