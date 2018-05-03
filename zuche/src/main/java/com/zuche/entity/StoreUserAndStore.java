package com.zuche.entity;

/**
 * 门店账号和门店
 * @author cbl
 *
 */
public class StoreUserAndStore {
	
	private StoreUser storeUser;
	
	private Store store;

	public StoreUserAndStore() {
		super();
	}

	public StoreUserAndStore(StoreUser storeUser, Store store) {
		super();
		this.storeUser = storeUser;
		this.store = store;
	}

	public StoreUser getStoreUser() {
		return storeUser;
	}

	public void setStoreUser(StoreUser storeUser) {
		this.storeUser = storeUser;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
}
