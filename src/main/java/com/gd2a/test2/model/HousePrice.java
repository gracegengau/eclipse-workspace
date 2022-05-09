package com.gd2a.test2.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HousePrice {

	@Id
	private Integer id;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private Integer bedrooms;
	private Integer bathrooms;
	private BigDecimal price;
	private LocalDate dateSold;
	
	public HousePrice() {
		
	}
	
	public HousePrice(Integer id, String streetAddress, String suburb, String postcode, 
			Integer bedrooms, Integer bathrooms, BigDecimal price, LocalDate dateSold) 
	{
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.price = price;
		this.dateSold = dateSold;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Property{");
        sb.append("id=").append(id);
        sb.append(", address: ").append(streetAddress).append(" at ").append(suburb);
        sb.append(", with ").append(bedrooms).append(" bedrooms, sold at price $");
        sb.append(price);
        sb.append('}');
        return sb.toString();
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public LocalDate getDateSold() {
		return dateSold;
	}

	public void setDateSold(LocalDate dateSold) {
		this.dateSold = dateSold;
	}
}
