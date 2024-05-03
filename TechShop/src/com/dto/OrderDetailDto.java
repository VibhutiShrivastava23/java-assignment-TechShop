package com.dto;

public class OrderDetailDto {
	private int customerid;

	private int orderid;
	private Double SubtotalAmount;

	public OrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailDto(int customerid, int orderid, Double amount) {
		super();
		this.customerid = customerid;
		this.orderid = orderid;
		SubtotalAmount = amount;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [customerid=" + customerid + ", orderid=" + orderid + ", SubtotalAmount="
				+ SubtotalAmount + "]";
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public double getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Double getSubtotalAmount() {
		return SubtotalAmount;
	}

	public void setSubtotalAmount(Double subtotalAmount) {
		SubtotalAmount = subtotalAmount;
	}

}
