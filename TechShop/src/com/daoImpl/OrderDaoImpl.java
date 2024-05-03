package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDao;
import com.dto.OrderDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;
import com.model.Orders;
import com.utility.DBConnection;

public class OrderDaoImpl implements OrderDao {
//1
	@Override
	public List<OrderDto> totalAmount() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select o.orderID , sum(o.totalAmount) as totalAmount,c.customerID "
				+ "from customer c join orders o on c.customerID=o.customerID" + " group by c.customerID ";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<OrderDto> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("orderID");
			double amount = rst.getDouble("totalAmount");
			int cid = rst.getInt("customerID");

			OrderDto order = new OrderDto(id, amount, cid);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
	}

//2
	@Override
	public List<Orders> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from orders";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Orders> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("orderID");
			int cid = rst.getInt("customerID");
			String date = rst.getString("orderDate");
			double amount = rst.getInt("totalAmount");
			String valid = rst.getString("isValid");

			Orders order = new Orders(id, cid, date, amount, valid);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;

	}

//3
	@Override
	public boolean findOne(int oid) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select orderDetailID from orderDetails where orderDetailID=?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, oid);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;
	}

//3
	@Override
	public void updateStatus(int oid, String status) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "update orderdetails set status= ? where orderdetailID= ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setInt(2, oid);
		pstmt.executeUpdate();

		DBConnection.dbClose();
	}

//3
	@Override
	public List<OrderDetails> getOrderDetail() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from orderdetails";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<OrderDetails> list = new ArrayList<>();
		while (rst.next() == true) {
			int id = rst.getInt("orderDetailID");
			int cid = rst.getInt("orderID");
			int pid = rst.getInt("productID");
			int quantity = rst.getInt("quantity");
			String status = rst.getString("status");

			OrderDetails order = new OrderDetails(id, cid, pid, quantity, status);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
	}

//4
	@Override
	public void softDeleteById(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "update orders set isValid='no' where orderId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();

	}

}
