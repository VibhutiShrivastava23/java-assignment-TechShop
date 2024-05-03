package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDao;
import com.daoImpl.productDaoImpl;
import com.dto.ProductDto;
import com.exception.ResourceNotFoundException;
import com.model.Product;

public class ProductService {
	ProductDao dao = new productDaoImpl();

	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void updatePrice(int id, int price) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean isValid = dao.findOne(id);
		if (!isValid) {
			throw new ResourceNotFoundException("id is invalid");

		}
		dao.updatePrice(id, price);
	}

	public List<ProductDto> checkStock() throws SQLException {
		// TODO Auto-generated method stub
		return dao.checkStock();
	}

}
