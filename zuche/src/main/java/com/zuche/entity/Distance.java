package com.zuche.entity;

public class Distance {

	private Double latitude;
	private Double longitude;
	private int count;
	
	public Distance(Double latitude, Double longitude, int count) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.count = count;
	}
	public Distance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
