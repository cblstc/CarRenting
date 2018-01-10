package com.zuche.entity;

public class Location {
    private Integer id;

    private String ordersId;

    private Integer userCarId;

    private String getaddress;

    private Float getlongitude;

    private Float getlatitude;

    private String returnaddress;

    private Float returnlongitude;

    private Float returnlatitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId == null ? null : ordersId.trim();
    }

    public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
    }

    public String getGetaddress() {
        return getaddress;
    }

    public void setGetaddress(String getaddress) {
        this.getaddress = getaddress == null ? null : getaddress.trim();
    }

    public Float getGetlongitude() {
        return getlongitude;
    }

    public void setGetlongitude(Float getlongitude) {
        this.getlongitude = getlongitude;
    }

    public Float getGetlatitude() {
        return getlatitude;
    }

    public void setGetlatitude(Float getlatitude) {
        this.getlatitude = getlatitude;
    }

    public String getReturnaddress() {
        return returnaddress;
    }

    public void setReturnaddress(String returnaddress) {
        this.returnaddress = returnaddress == null ? null : returnaddress.trim();
    }

    public Float getReturnlongitude() {
        return returnlongitude;
    }

    public void setReturnlongitude(Float returnlongitude) {
        this.returnlongitude = returnlongitude;
    }

    public Float getReturnlatitude() {
        return returnlatitude;
    }

    public void setReturnlatitude(Float returnlatitude) {
        this.returnlatitude = returnlatitude;
    }
}