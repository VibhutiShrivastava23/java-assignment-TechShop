package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;
import com.model.Orders;

public interface OrderDao {

	List<OrderDto> totalAmount() throws SQLException;

	List<Orders> findAll() throws SQLException;

	boolean findOne(int oid) throws SQLException, ResourceNotFoundException;

	void updateStatus(int oid, String status) throws SQLException, ResourceNotFoundException;

	List<OrderDetails> getOrderDetail() throws SQLException;

	void softDeleteById(int id) throws SQLException, ResourceNotFoundException;

}
