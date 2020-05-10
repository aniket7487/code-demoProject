package com.meadiaocean.java;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String name;
	private double amount;
	private int stock;
	private int category;
	public Product(int id, String name, double amount,int stock,int category) {
		this.id=id;
		this.name=name;
		this.amount=amount;
		this.stock=stock;
		this.category=category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
}
