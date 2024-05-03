package com.dto;

public class ProductInventoryDto {
	private int inventoryID;
	private int productID;
	private int quantityInStock;
	private String lastStockUpdate;
	private String productName;
	private Double price;

	public ProductInventoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInventoryDto(int inventoryID, int productID, int quantityInStock, String lastStockUpdate,
			String productName, Double price) {
		super();
		this.inventoryID = inventoryID;
		this.productID = productID;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductInventoryDto [inventoryID=" + inventoryID + ", productID=" + productID + ", quantityInStock="
				+ quantityInStock + ", lastStockUpdate=" + lastStockUpdate + ", productName=" + productName + ", price="
				+ price + "]";
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getLastStockUpdate() {
		return lastStockUpdate;
	}

	public void setLastStockUpdate(String lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
