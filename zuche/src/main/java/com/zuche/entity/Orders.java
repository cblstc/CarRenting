package com.zuche.entity;

import java.util.Date;

public class Orders {
    private String id;

    private Integer storeCarId;

    private Float price;

    private Float insurance;

    private Float nodeductibles;

    private Float totalmoney;

    private Date gettime;

    private Date returntime;

    private Date time;

    private Integer status;

    private Integer userId;
    
    private Integer storeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getStoreCarId() {
        return storeCarId;
    }

    public void setStoreCarId(Integer storeCarId) {
        this.storeCarId = storeCarId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getInsurance() {
        return insurance;
    }

    public void setInsurance(Float insurance) {
        this.insurance = insurance;
    }

    public Float getNodeductibles() {
        return nodeductibles;
    }

    public void setNodeductibles(Float nodeductibles) {
        this.nodeductibles = nodeductibles;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getGettime() {
        return gettime;
    }

    public void setGettime(Date gettime) {
        this.gettime = gettime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
    
}