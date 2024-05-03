package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ProductInventoryDto;
import com.model.Inventory;

public interface InventoryDao {

	List<ProductInventoryDto> findAll() throws SQLException;

	List<Inventory> getQuantityInStock() throws SQLException;

	List<Inventory> getOutOfStock() throws SQLException;

}
