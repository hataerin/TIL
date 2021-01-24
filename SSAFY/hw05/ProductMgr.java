package com.ssafy.hw05.step3;

public class ProductMgr {
	private final int MAX_SIZE = 100;
	
	private Product[] products = new Product[MAX_SIZE];
	private int index = 0;
	
	public void add(Product p) {
		if (index < MAX_SIZE)
			products[index++] = p;
	}
	
	public Product[] list() {
		return products;
	}
	
	public Product list(int num) {
		for (int i = 0; i < index; i++) {
			if (products[i] != null && products[i].getId() == num)
				return products[i];
		}
		return null;
	}
	
	public void delete(int num) {
		for (int i = 0; i < index; i++) {
			if (products[i] != null && products[i].getId() == num) {
				products[i] = null;
				break;
			}
		}
	}
	
	public Product[] priceList(int price) {
		Product[] temp = new Product[index];
		int tempIndex = 0;
		for (int i = 0; i < index; i++) {
			if (products[i] != null && products[i].getPrice() <= price)
				temp[tempIndex++] = products[i];
		}
		
		return temp;
	}
}
