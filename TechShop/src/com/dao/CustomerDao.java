package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerDto;
import com.exception.ResourceNotFoundException;
import com.model.Customer;

public interface CustomerDao {

	List<CustomerDto> calculateTotalOrder() throws SQLException;
	// TODO Auto-generated method stub

	List<Customer> findAll() throws SQLException;

	void updateStockQuantity(int customerId, int newPhone) throws SQLException, ResourceNotFoundException;

	boolean findOne(int customerId) throws SQLException, ResourceNotFoundException;

}
