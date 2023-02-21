package com.axis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Category {
	@Id
    private String id = UUID.randomUUID().toString();
    private String name;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private List<Product> products = new ArrayList<>();

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
    
    
    

	
}
    
    