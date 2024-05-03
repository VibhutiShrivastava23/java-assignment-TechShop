package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.dto.ProductDto;
import com.exception.ResourceNotFoundException;
import com.model.Product;
import com.utility.DBConnection;

public class productDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from product";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Product> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("productId");
			String name = rst.getString("productName");
			String decscription = rst.getString("description");
			double price = rst.getDouble("price");

			Product product = new Product(id, name, decscription, price);
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public void updatePrice(int id, int price) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "update product set price= ? where productID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, price);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();

	}

	@Override
	public boolean findOne(int id) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select productId from product where productId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;

	}

	@Override
	public List<ProductDto> checkStock() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.productName, i.quantityInStock \r\n" + "FROM product p \r\n"
				+ "JOIN inventory i ON p.productID = i.productID \r\n" + "WHERE i.quantityInStock > 0 \r\n"
				+ "GROUP BY p.productName";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<ProductDto> list = new ArrayList<>();
		while (rst.next() == true) {
			String name = rst.getString("productName");
			int stock = rst.getInt("quantityInStock");

			ProductDto product = new ProductDto(name, stock); // 100X 200X 300X
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
	}

}
