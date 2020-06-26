package com.orders.model;

public class ProductsDto {
	
	private Integer productCode;
	private String productName;
	private Long quantity;
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Integer getProductCode() {
		return productCode;
	}
	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
