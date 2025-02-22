package com.quespro.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public OrderDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final RowMapper<Order_DTO> groceryRowMapper = (rs, rowNum) -> {
		Order_DTO order = new Order_DTO();
		order.setOrder_id(rs.getLong("getOrder_id"));
		order.setUser_id(rs.getLong("getUser_id"));
		order.setProduct_id(rs.getLong("getProduct_id"));
		order.setQuantity(rs.getInt("getQuantity"));
		order.setTotal_price(rs.getDouble("getTotal_price"));
		return order;
	};

	public List<Order_DTO> getItems() {
		return jdbcTemplate.query("select * from product_table", groceryRowMapper);

	}

	public int insertOrder(OrderRequestDTO orderRequest) {
		String sql = "INSERT INTO orders (userId, userName, userAddress, totalAmount) VALUES (?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, orderRequest.getUserId());
			ps.setString(2, orderRequest.getUserName());
			ps.setString(3, orderRequest.getUserAddress());
			ps.setDouble(4, calculateTotalAmount(orderRequest.getItems()));
			return ps;
		}, keyHolder);

		return keyHolder.getKey().intValue(); // Get the generated orderId
	}

	public void insertOrderItems(int orderId, List<OrderItemDTO> items) {
		String sql = "INSERT INTO order_items (orderId, productId, quantity, price) VALUES (?, ?, ?, ?)";

		jdbcTemplate.batchUpdate(sql, items, items.size(), (ps, item) -> {
			ps.setInt(1, orderId);
			ps.setInt(2, item.getProductId());
			ps.setInt(3, item.getQuantity());
			ps.setDouble(4, item.getPrice());
		});
	}

	private double calculateTotalAmount(List<OrderItemDTO> items) {
		return items.stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
	}
}
