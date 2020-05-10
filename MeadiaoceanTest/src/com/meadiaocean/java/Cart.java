package com.meadiaocean.java;

public class Cart {
	private int id;
	private String name;
	private double amount;
	private double totalAmount;
	private int quantity;
	public Cart(Integer id, String name, double amount, Integer quantity, double totalAmount) {
		this.id=id;
		this.name=name;
		this.amount=amount;
		this.quantity=quantity;
		this.totalAmount=totalAmount;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
