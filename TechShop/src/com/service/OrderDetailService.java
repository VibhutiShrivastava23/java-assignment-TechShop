package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDetailDao;
import com.daoImpl.OrderDetailDaoImpl;
import com.dto.OrderDetailDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;

public class OrderDetailService {
	OrderDetailDao dao = new OrderDetailDaoImpl();

	public List<OrderDetailDto> getSubtotal() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getSubtotal();
	}

	public List<OrderDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void updateQuantity(int id, int newQuantity) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if (!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		dao.updateStockQuantity(id, newQuantity);

	}

}
