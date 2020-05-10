package com.meadiaocean.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MediaoceanMart {

	public static void main(String[] args) {
		MediaoceanMart mediaoceanMart=new MediaoceanMart();
		Scanner sc=new Scanner(System.in);
		Map<Integer,Integer> map=new HashMap<>();
		List<Product> productList=mediaoceanMart.getProductList();
		if(productList!=null && productList.size()>0) {
			map=mediaoceanMart.addToCart(productList,sc);
		}else {
			System.out.println("No Product are Available..");
		}
		if(map!=null && map.size()>0) {
			mediaoceanMart.getPreview(productList,map,sc);
		}else {
			System.out.println("Thank you for visiting..");
		}

	}

	public void getPreview(List<Product> productList,Map<Integer, Integer> map,Scanner sc) {
		List<Cart> cartList=new ArrayList<>();
		System.out.println("Preview Bill:");
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			for (Product product : productList) {
				if(entry.getKey()==product.getId()) {
					cartList.add(new Cart(entry.getKey(),product.getName(),product.getAmount(),entry.getValue(),getTotalAmount(entry.getValue(),product.getAmount(),product.getCategory())));
				}
			}
		}
		getFinalBill(cartList);
		System.out.println("1 Generate Bill");
		System.out.println("2 Remove Product");
		System.out.println("3 EXIST");
		while (!sc.hasNextInt()) {
			
			System.out.println("Please Enter Int");
			sc.next();
		}
		int code=sc.nextInt();
		if(code==1) {
			getFinalBill(cartList);
		}else if(code==2) {
			deleteProduct(cartList,sc);
		}else if(code==3) {
			System.out.println("Thank You For Visiting...");
		}
		
	}

	public void deleteProduct(List<Cart> cartList,Scanner sc) {
		System.out.println("Enter Product Code:");
		while (!sc.hasNextInt()) {
			System.out.println("Please Enter Int");
			sc.next();
		}
		int deleteProduct=sc.nextInt();
		if(deleteProduct>0 && deleteProduct<=cartList.size()) {
			cartList.remove(deleteProduct-1);
		}else {
			System.out.println("Enter Valid Product Code.");
		}
		getFinalBill(cartList);
	}

	public void getFinalBill(List<Cart> cartList) {
		double totalBillAmount=0.0d;
		int count=1;
		System.out.printf("%2s. %-20s %.15s %10s %12s%n","ID","NAME","AMOUNT PER(Rs.)","QUANTITY","TOTAL AMOUNT(Rs.)");
		for (Cart cart : cartList) {
			System.out.printf("%2d. %-20s Rs.%4.2f %13d %15.2f%n",count,cart.getName(),cart.getAmount(),cart.getQuantity(),cart.getTotalAmount());
			count++;
			totalBillAmount+=cart.getTotalAmount();
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.printf("%-48s %15.2f%n","Total Bill Amount: ",totalBillAmount);
	}

	public Map<Integer,Integer> addToCart(List<Product> productList,Scanner sc) {
		Map<Integer,Integer> map=new HashMap<>();
		boolean checkoutFlag=false;
		boolean exitFlag=false;
		boolean productFlag=false;
		boolean quantityFlag=false;
		int count=1;
		for(int i=0;i<count;i++) {
			System.out.println("Enter Code: ");
			while (!sc.hasNextInt()) {
				
				System.out.println("Please Enter Int");
				sc.next();
			}
			int id=sc.nextInt();
			if(id == 999) {
				checkoutFlag=true;
				break;
			}else if(id==000) {
				exitFlag=true;
				break;
			}
			for (Product product : productList) {
				productFlag=false;
				if(product.getId()==id) {
					productFlag=true;
					break;
				}
			}
			if(productFlag) {
				System.out.println("Enter Quantity: ");
				quantityFlag=false;
				while (!sc.hasNextInt()) {
					
					System.out.println("Please Enter Int");
					sc.next();
				}
				int quantity=sc.nextInt();
				for (Product product : productList) {
					if(product.getId()==id && product.getStock()>quantity) {
						product.setStock(product.getStock()-quantity);
						quantityFlag=true;
					}
				}
				if(!quantityFlag) {
					System.out.println("Product quantity is exceed limit..");
				}else if(productFlag && quantityFlag) {
					if(map.containsKey(id)) {
						map.put(id, map.get(id)+quantity);
					}else {
						map.put(id, quantity);
					}
				}
			}else if(!productFlag){
				System.out.println("Product Code is not Valid..");
			}else {
				System.out.println("Product Code is not found..");
			}
			if(map.size()==productList.size()) {
				return map;
			}else {
				count++;
			}
		}
		return map;
	}

	private List<Product> getProductList() {
		System.out.println("==================Welcome To Mediaocean Mart==============================");
		List<Product> productList=new ArrayList<>();
		productList.add(new Product(1,"BISCUIT",20.0d,200,1));
		productList.add(new Product(2,"ALMOND",200.0d,200,1));
		productList.add(new Product(3,"SALT",10.0d,200,1));
		productList.add(new Product(4,"SOAP",20.0d,200,2));
		productList.add(new Product(5,"MILK",60.0d,200,2));
		productList.add(new Product(6,"PANEER",120.0d,200,3));
		productList.add(new Product(7,"OATS",30.0d,200,3));
		System.out.printf("%2s. %-20s %.12s%n","ID", "NAME" ,"AMOUNT(Rs.)");
		productList.forEach(product-> System.out.printf("%2d. %-20s Rs.%.2f%n",product.getId(), product.getName() ,product.getAmount()));
//		System.out.printf("%2d. %-20s $%.2f%n",  i + 1, BOOK_TYPE[i], COST[i]);
		System.out.println("999 CHECKOUT");
		System.out.println("000 EXIT");
		return productList;
	}
	
	public double getTotalAmount(Integer quantity, double amount, int category) {
		double total=0.0d;
		total=quantity*amount;
		if(category==1) {
			return total+ total*10/100;
		}else if(category==2) {
			return total+ total*20/100;
		}else {
			return total;
		}
	}

	public void getProductPreview(List<Product> productList,Map<Integer, Integer> map) {
		List<Cart> cartList=new ArrayList<>();
		System.out.println("Preview Bill:");
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			for (Product product : productList) {
				if(entry.getKey()==product.getId()) {
					cartList.add(new Cart(entry.getKey(),product.getName(),product.getAmount(),entry.getValue(),getTotalAmount(entry.getValue(),product.getAmount(),product.getCategory())));
				}
			}
		}
		getFinalBill(cartList);
	}

}
