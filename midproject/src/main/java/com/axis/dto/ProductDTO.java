package com.axis.dto;

public class ProductDTO {
    private String productId;
    private Double quantityToPurchase;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getQuantityToPurchase() {
		return quantityToPurchase;
	}
	public void setQuantityToPurchase(Double quantityToPurchase) {
		this.quantityToPurchase = quantityToPurchase;
	}
    
    
}