package com.example.demo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductOrderMySQLDAO {
	private final JdbcTemplate jdbcTemplate;
	
	public ProductOrderMySQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<ProductOrder> getAllPurchaseOrders() {
		return jdbcTemplate.query("SELECT * FROM product_order", (rs, rowNum) -> {
			ProductOrder order = new ProductOrder();
			int productId = rs.getInt(2);
			int userId = rs.getInt(1);
			
			ProductSQL product = jdbcTemplate.queryForObject("SELECT * FROM product_table WHERE Id = ?", (rs1, rowNum1) -> {
				ProductSQL productInner = new ProductSQL();
				productInner.setId(rs1.getInt(1));
				productInner.setBrand(rs1.getString(2));
				productInner.setCategory(rs1.getString(3));
				productInner.setColor(rs1.getString(4));
				productInner.setCreatedDate(rs1.getString(5));
				productInner.setDiscount(rs1.getInt(6));
				productInner.setProductName(rs1.getString(7));
				productInner.setPrice(rs1.getDouble(8));
				productInner.setQuantity(rs1.getInt(9));
				productInner.setSeason(rs1.getString(10));
				return productInner;
			}, productId);
			User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE user_id = ?", (rs2, rowNum2) -> {
				User u = new User();
				u.setUserId(rs2.getInt(1));
				u.setEmail(rs2.getString(2));
				u.setPassword(rs2.getString(3));
				u.setPhoneNo(rs2.getInt(4));
				u.setUsername(rs2.getString(5));
				return u;
			}, userId);
			
			order.setProduct(product);
			order.setUser(user);
			return order;
					
		});
		
	}
	
	public List<ProductOrder> getFilteredOrders(String date, String category) {
        List<ProductOrder> orders = getAllPurchaseOrders();

        if (date != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCreatedDate().toString().equals(date))
                    .toList();
        }
        if (category != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCategory().equals(category))
                    .toList();
        }
        return orders;
    }
}
