package com.zuche.entity;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7464872789805131176L;

	private String id;

    private Integer storeCarId;

    private Integer userCarId;

    private Float price;

    private Float insurance;

    private Float nodeductibles;

    private Float poundage;

    private Float totalmoney;

    private Float disposit;

    private Date gettime;

    private Date returntime;

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

    public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
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

    public Float getPoundage() {
        return poundage;
    }

    public void setPoundage(Float poundage) {
        this.poundage = poundage;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Float getDisposit() {
        return disposit;
    }

    public void setDisposit(Float disposit) {
        this.disposit = disposit;
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
}