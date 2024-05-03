package com.dto;

public class ProductDto {
	private String productName;
	private int quantityInStock;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(String productName, int quantityInStock) {
		super();
		this.productName = productName;
		this.quantityInStock = quantityInStock;
	}

	@Override
	public String toString() {
		return "ProductDto [productName=" + productName + ", quantityInStock=" + quantityInStock + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

}
