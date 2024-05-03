package com.dto;

public class OrderDto {
	private int orderID;
	private double totalAmount;
	private int customerID;

	public OrderDto(int orderID, double totalAmount, int customerID) {
		super();
		this.orderID = orderID;
		this.totalAmount = totalAmount;
		this.customerID = customerID;
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderDto [orderID=" + orderID + ", totalAmount=" + totalAmount + ", customerID=" + customerID + "]";
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
