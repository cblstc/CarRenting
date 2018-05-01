package com.zuche.entity;

public class StoreCar {
    private Integer id;

    private Integer storeId;

    private String brand;

    private String model;

    private String configuration;

    private Integer seats;

    private Integer doors;

    private String displacement;

    private Integer navigator;

    private Integer pdc;

    private Integer drivenmode;

    private Integer fueltankage;

    private Integer gearbox;

    private Integer skylight;

    private Integer aircell;

    private Float price;

    private Float insurance;

    private Float nodeductibles;

    private Integer count;

    private Integer status;

    private String carphoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
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

    public Integer getFueltankage() {
        return fueltankage;
    }

    public void setFueltankage(Integer fueltankage) {
        this.fueltankage = fueltankage;
    }

    public Integer getGearbox() {
        return gearbox;
    }

    public void setGearbox(Integer gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getSkylight() {
        return skylight;
    }

    public void setSkylight(Integer skylight) {
        this.skylight = skylight;
    }

    public Integer getAircell() {
        return aircell;
    }

    public void setAircell(Integer aircell) {
        this.aircell = aircell;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCarphoto() {
        return carphoto;
    }

    public void setCarphoto(String carphoto) {
        this.carphoto = carphoto == null ? null : carphoto.trim();
    }
}