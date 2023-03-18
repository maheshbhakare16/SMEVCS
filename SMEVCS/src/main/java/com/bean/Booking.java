package com.bean;

public class Booking {
	String owner_id;
	String vehno;
	String mobileno;
	String city;
	String area;
	java.sql.Timestamp time;
	
	public Booking() {
		super();
	}
	public Booking(String owner_id, String vehno, String mobileno, String city, String area, java.sql.Timestamp time) {
		super();
		this.owner_id = owner_id;
		this.vehno = vehno;
		this.mobileno = mobileno;
		this.city = city;
		this.area = area;
		this.time = time;
	}
	
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getVehno() {
		return vehno;
	}
	public void setVehno(String vehno) {
		this.vehno = vehno;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
}
