package com.dto;

public class CustomerDto {
	private int customerID;
	private int numberOfOrders;

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(int customerID, int numberOfOrders) {
		super();
		this.customerID = customerID;
		this.numberOfOrders = numberOfOrders;
	}

	@Override
	public String toString() {
		return "CustomerDto [customerID=" + customerID + ", numberOfOrders=" + numberOfOrders + "]";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getNumberOfOrders() {
		return numberOfOrders;
	}

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}

}
