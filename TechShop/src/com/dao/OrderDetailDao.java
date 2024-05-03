package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderDetailDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;

public interface OrderDetailDao {

	List<OrderDetailDto> getSubtotal() throws SQLException;

	List<OrderDetails> findAll() throws SQLException;

	boolean findOne(int id) throws SQLException;

	void updateStockQuantity(int id, int newQuantity) throws SQLException, ResourceNotFoundException;

}
