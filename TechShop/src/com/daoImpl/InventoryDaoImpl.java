package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.InventoryDao;
import com.dto.ProductInventoryDto;
import com.model.Inventory;
import com.utility.DBConnection;

public class InventoryDaoImpl implements InventoryDao {

	@Override
	public List<ProductInventoryDto> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select i.*,p.productName,p.price " + "from product p left join inventory i "
				+ "on p.productid=i.productid " + "group by p.productname";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<ProductInventoryDto> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("inventoryID");
			int pid = rst.getInt("productID");
			int quant = rst.getInt("quantityInStock");
			String last = rst.getString("lastStockUpdate");
			String name = rst.getString("productName");
			Double price = rst.getDouble("price");

			ProductInventoryDto product = new ProductInventoryDto(id, pid, quant, last, name, price);
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Inventory> getQuantityInStock() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = " select * from inventory where quantityinstock>0";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<Inventory> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("inventoryID");
			int pid = rst.getInt("productID");
			int quant = rst.getInt("quantityInStock");
			String last = rst.getString("lastStockUpdate");

			Inventory product = new Inventory(id, pid, quant, last);
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Inventory> getOutOfStock() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = " select * from inventory where quantityinstock=0";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<Inventory> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("inventoryID");
			int pid = rst.getInt("productID");
			int quant = rst.getInt("quantityInStock");
			String last = rst.getString("lastStockUpdate");

			Inventory product = new Inventory(id, pid, quant, last);
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
	}

}
