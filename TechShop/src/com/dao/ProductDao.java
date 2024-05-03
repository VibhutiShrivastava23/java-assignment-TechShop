package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ProductDto;
import com.exception.ResourceNotFoundException;
import com.model.Product;

public interface ProductDao {

	List<Product> findAll() throws SQLException;

	void updatePrice(int id, int price) throws ResourceNotFoundException, SQLException;

	boolean findOne(int id) throws ResourceNotFoundException, SQLException;

	List<ProductDto> checkStock() throws SQLException;

}
