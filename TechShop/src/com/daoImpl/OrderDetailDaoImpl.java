package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDetailDao;
import com.dto.OrderDetailDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;
import com.utility.DBConnection;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public List<OrderDetailDto> getSubtotal() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select o.customerid,o.orderid,sum(od.quantity * o.totalamount) as SubtotalAmount"
				+ " from orders o join orderdetails od on o.orderid=od.orderid " + "group by o.customerid";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<OrderDetailDto> list = new ArrayList<>();
		while (rst.next() == true) {
			int cid = rst.getInt("customerid");
			int oid = rst.getInt("orderid");
			Double amount = rst.getDouble("SubtotalAmount");

			OrderDetailDto order = new OrderDetailDto(cid, oid, amount);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<OrderDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from orderdetails";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<OrderDetails> list = new ArrayList<>();
		while (rst.next() == true) {
			int odid = rst.getInt("orderDetailId");
			int oid = rst.getInt("orderId");
			int pid = rst.getInt("productId");
			int quantity = rst.getInt("quantity");
			String status = rst.getString("status");

			OrderDetails order = new OrderDetails(odid, oid, pid, quantity, status);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public boolean findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select orderdetailid from orders where orderdetailid=?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void updateStockQuantity(int id, int newQuantity) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = " update orderdetails set quantity=? where orderdetailid=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, newQuantity);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();

		DBConnection.dbClose();
	}

}
