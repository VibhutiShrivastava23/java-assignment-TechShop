package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerDao;
import com.dto.CustomerDto;
import com.exception.ResourceNotFoundException;
import com.model.Customer;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<CustomerDto> calculateTotalOrder() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select c.customerID , count(o.orderID) as numberOfOrders "
				+ "from customer c join orders o on c.customerID=o.customerID " + "group by c.customerID ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<CustomerDto> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("customerID");
			int numOrder = rst.getInt("numberOfOrders");

			CustomerDto customer = new CustomerDto(id, numOrder);
			list.add(customer);
		}
		DBConnection.dbClose();
		return list;

	}

	@Override
	public List<Customer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from customer";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Customer> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("customerID");
			String fName = rst.getString("firstName");
			String lName = rst.getString("lastName");
			String email = rst.getString("email");
			int phone = rst.getInt("phone");
			String address = rst.getString("address");

			Customer customer = new Customer(id, fName, lName, email, phone, address);
			list.add(customer);

		}
		DBConnection.dbClose();
		return list;

	}

	@Override
	public void updateStockQuantity(int customerId, int newPhone) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "update customer set phone=? where customerID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, newPhone);
		pstmt.setInt(2, customerId);
		pstmt.executeUpdate();

		DBConnection.dbClose();

	}

	@Override
	public boolean findOne(int customerId) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select customerID from customer where customerID=?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;

	}

}
