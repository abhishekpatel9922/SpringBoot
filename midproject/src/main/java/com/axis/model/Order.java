package com.axis.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    private String orderNumber = UUID.randomUUID().toString();
    private Double totalPrice;
    private LocalDateTime orderTime;
    private String deliveryStatus;

    @ManyToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Product> products = new ArrayList<>();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderNumber, Double totalPrice, LocalDateTime orderTime, String deliveryStatus,
			List<Product> products) {
		super();
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.deliveryStatus = deliveryStatus;
		this.products = products;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
    
    
