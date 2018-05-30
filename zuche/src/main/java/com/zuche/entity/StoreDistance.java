package com.zuche.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StoreDistance {

	private Integer id;

    private Integer storeUserId;

    private String storename;

    private String phone;

    @DateTimeFormat(pattern="HH:mm")
    private Date starttime;
    
    @DateTimeFormat(pattern="HH:mm")
    private Date endtime;

    private String address;

    private Float longitude;

    private Float latitude;

    private String description;

    private String traffic;

    private Integer totalstar;

    private Integer totalcomment;

    private Float avgstar;

    private Integer status;
	
	private Double distance;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreUserId() {
		return storeUserId;
	}

	public void setStoreUserId(Integer storeUserId) {
		this.storeUserId = storeUserId;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
