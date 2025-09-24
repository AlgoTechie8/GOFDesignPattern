package com.algotechie.mutable;

public class Address implements Cloneable{
	private String flatNo;
	private String street;
	private String city;
	
	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();  // shallow clone (ok for immutable fields)
	}

	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", street=" + street + ", city=" + city + "]";
	}
}
