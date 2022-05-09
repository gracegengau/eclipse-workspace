package com.gd2a.test2.model;

public class HousePriceInput {

	private String streetAddress;
	private String suburb;
	private String postcode;
	private Integer bedrooms;
	private Integer bathrooms;
	private String propertyType;
	private String price;
	private String dateSold;
	private Integer lineNumber;
	
	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public HousePriceInput() {
		
	}
	
	public HousePriceInput(String streetAddress, String suburb, String postcode, Integer bedrooms, 
			Integer bathrooms, String propertyType, String price, String dateSold) {
		super();
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.propertyType = propertyType;
		this.price = price;
		this.dateSold = dateSold;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getDateSold() {
		return dateSold;
	}

	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

}
