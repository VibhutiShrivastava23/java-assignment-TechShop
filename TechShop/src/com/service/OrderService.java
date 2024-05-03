package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDao;
import com.daoImpl.OrderDaoImpl;
import com.dto.OrderDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;
import com.model.Orders;

public class OrderService {
	OrderDao dao = new OrderDaoImpl();

	public List<OrderDto> totalAmount() throws SQLException {
		// TODO Auto-generated method stub
		return dao.totalAmount();
	}

	public List<Orders> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void updateStatus(int oid, String status) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(oid);
		if (!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		dao.updateStatus(oid, status);

	}

	public List<OrderDetails> getOrderDetail() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getOrderDetail();
	}

	public void softDeleteByid(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if (!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");

		dao.softDeleteById(id);

	}

}
