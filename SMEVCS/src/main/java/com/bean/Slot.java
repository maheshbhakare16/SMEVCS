package com.bean;

public class Slot {
	private String slotname,address,area,city,state,country;

	public Slot() {
		super();
	}

	public Slot(String slotname, String address, String area, String city, String state, String country) {
		super();
		this.slotname = slotname;
		this.address = address;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getSlotname() {
		return slotname;
	}

	public void setSlotname(String slotname) {
		this.slotname = slotname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
