package com.zuche.entity;

import java.util.Date;

public class Garage {
    private Integer id;

    private Integer configurationId;

    private Date year;

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

    private String carphoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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

    public String getCarphoto() {
        return carphoto;
    }

    public void setCarphoto(String carphoto) {
        this.carphoto = carphoto == null ? null : carphoto.trim();
    }
}