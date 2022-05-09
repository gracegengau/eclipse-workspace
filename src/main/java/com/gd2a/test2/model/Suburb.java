package com.gd2a.test2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Suburb {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String suburb;
	@ManyToOne
	@JoinColumn(name = "postcodeid", insertable = false, updatable = false)
	private Postcode postcode;
	private String postcodeid;
	
	@Transient
	List<HousePrice> houseSold;
	
	public Suburb() {
		
	}
	public Suburb(Integer id, String suburb, Postcode postcode, String postcodeid) {
		super();
		this.id = id;
		this.suburb = suburb;
		this.postcode = postcode;
		this.postcodeid = postcodeid;
	}
	public Suburb(String suburb, Postcode postcode) {
		super();
		this.suburb = suburb;
		this.postcode = postcode;
		this.postcodeid = postcode.getId();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public Postcode getPostcode() {
		return postcode;
	}
	public void setPostcode(Postcode postcode) {
		this.postcode = postcode;
	}
	public String getPostcodeid() {
		return postcodeid;
	}
	public void setPostcodepostcode(String postcode) {
		this.postcodeid = postcode;
	}
	
	public List<HousePrice> getHouseSold() {
		return houseSold;
	}
	public void setHouseSold(List<HousePrice> houseSold) {
		this.houseSold = houseSold;
	}

	@Override
	public String toString() {
		return "Suburb " + suburb + ", " + postcode;
	}

}
