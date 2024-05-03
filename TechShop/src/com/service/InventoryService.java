package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InventoryDao;
import com.daoImpl.InventoryDaoImpl;
import com.dto.ProductInventoryDto;
import com.model.Inventory;

public class InventoryService {
	InventoryDao dao = new InventoryDaoImpl();

	public List<ProductInventoryDto> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Inventory> getQuantityInStock() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getQuantityInStock();
	}

	public List<Inventory> getOutOfStock() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getOutOfStock();
	}

}
