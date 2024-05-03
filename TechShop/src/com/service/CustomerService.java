package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.daoImpl.CustomerDaoImpl;
import com.dto.CustomerDto;
import com.exception.ResourceNotFoundException;
import com.model.Customer;

public class CustomerService {
	CustomerDao dao = new CustomerDaoImpl();

	public List<CustomerDto> calculateTotalOrder() throws SQLException {
		// TODO Auto-generated method stub
		return dao.calculateTotalOrder();
	}

	public List<Customer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void updatePhone(int customerId, int newPhone) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(customerId);
		if (!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		dao.updateStockQuantity(customerId, newPhone);

	}

}
