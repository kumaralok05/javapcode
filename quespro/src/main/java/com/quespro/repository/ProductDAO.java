package com.quespro.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProductDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final RowMapper<Product_DTO> groceryRowMapper = (rs, rowNum) -> {
		Product_DTO product = new Product_DTO();
		product.setProduct_id(rs.getLong("product_id"));
		product.setProduct_name(rs.getString("Product_name"));
		product.setPrice(rs.getDouble("price"));
		product.setStock(rs.getInt("stock"));
		return product;
	};

	public List<Product_DTO> getItems() {
		return jdbcTemplate.query("select * from product_table", groceryRowMapper);

	}

	public int[] addGroceryItems(List<Product_DTO> products) {
		String sql = "INSERT INTO product_table (Product_name, price,stock, quantity) VALUES (?, ?, ?, ?)";

		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, products.get(i).getProduct_name());
				ps.setDouble(2, products.get(i).getPrice());
				ps.setInt(3, products.get(i).getStock());
				ps.setInt(4, products.get(i).getQuantity());
			}

			@Override
			public int getBatchSize() {
				return products.size();
			}
		});
	}

	public int updateProductItem(List<Product_DTO> products) {
		String sql = "UPDATE product_table SET Product_name = ?, price = ?, stock = ?,quantity = ? WHERE product_id = ?";
		return jdbcTemplate.update(sql, products.get(0).getProduct_name(), products.get(0).getPrice(),
				products.get(0).getStock(), products.get(0).getQuantity(), products.get(0).getProduct_id());
	}

	public int removeitemsById(List<Integer> ids) {
		if (ids.isEmpty()) {
			return 0; // No IDs provided, nothing to delete
		}
		String placeholders = String.join(",", Collections.nCopies(ids.size(), "?"));
		String sql = "DELETE FROM product_table WHERE product_id IN (" + placeholders + ")";

		return jdbcTemplate.update(sql, ids.toArray());
	}
}
