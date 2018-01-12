package com.zuche.entity;

import java.util.Date;

public class UserCar {
    private Integer id;

    private Integer userId;

    private String platenumber;

    private String brand;

    private String model;

    private String configuration;

    private Date year;

    private Integer gearbox;

    private String displacement;

    private Integer navigator;

    private Integer pdc;

    private Integer drivenmode;

    private Integer mileage;

    private Integer capacity;

    private Integer fueltankage;

    private String description;

    private Float price;

    private Float disposit;

    private Integer ordertakingcount;

    private Integer sales;

    private Float ordertakingrate;

    private Integer status;

    private Integer totalstar;

    private Integer totalcomment;

    private Float avgstar;

    private String carphoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber == null ? null : platenumber.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration == null ? null : configuration.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getGearbox() {
        return gearbox;
    }

    public void setGearbox(Integer gearbox) {
        this.gearbox = gearbox;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement == null ? null : displacement.trim();
    }

    public Integer getNavigator() {
        return navigator;
    }

    public void setNavigator(Integer navigator) {
        this.navigator = navigator;
    }

    public Integer getPdc() {
        return pdc;
    }

    public void setPdc(Integer pdc) {
        this.pdc = pdc;
    }

    public Integer getDrivenmode() {
        return drivenmode;
    }

    public void setDrivenmode(Integer drivenmode) {
        this.drivenmode = drivenmode;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFueltankage() {
        return fueltankage;
    }

    public void setFueltankage(Integer fueltankage) {
        this.fueltankage = fueltankage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDisposit() {
        return disposit;
    }

    public void setDisposit(Float disposit) {
        this.disposit = disposit;
    }

    public Integer getOrdertakingcount() {
        return ordertakingcount;
    }

    public void setOrdertakingcount(Integer ordertakingcount) {
        this.ordertakingcount = ordertakingcount;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Float getOrdertakingrate() {
        return ordertakingrate;
    }

    public void setOrdertakingrate(Float ordertakingrate) {
        this.ordertakingrate = ordertakingrate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotalstar() {
        return totalstar;
    }

    public void setTotalstar(Integer totalstar) {
        this.totalstar = totalstar;
    }

    public Integer getTotalcomment() {
        return totalcomment;
    }

    public void setTotalcomment(Integer totalcomment) {
        this.totalcomment = totalcomment;
    }

    public Float getAvgstar() {
        return avgstar;
    }

    public void setAvgstar(Float avgstar) {
        this.avgstar = avgstar;
    }

    public String getCarphoto() {
        return carphoto;
    }

    public void setCarphoto(String carphoto) {
        this.carphoto = carphoto == null ? null : carphoto.trim();
    }
}