package com.zuche.entity;

public class OrdersDetail {
	
	private Orders orders;
	
	private Store store;
	
	private StoreCar storeCar;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public StoreCar getStoreCar() {
		return storeCar;
	}

	public void setStoreCar(StoreCar storeCar) {
		this.storeCar = storeCar;
	}
	
}
