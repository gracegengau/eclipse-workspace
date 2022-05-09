package com.gd2a.test2.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Postcode {

	@Id
	private String id;
	private String postcode;
	private Long listTotal;
	private BigDecimal highestPrice;
	private BigDecimal lowestPrice;
	@OneToMany(mappedBy="postcode")
	private List<Suburb> suburbs;
	
	public Postcode() {
	
	}
	public Postcode(String postcode, Long listTotal) {
		super();
		this.id = postcode;
		this.postcode = postcode;
		this.listTotal = listTotal;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Long getListTotal() {
		return listTotal;
	}
	public void setListTotal(Long listTotal) {
		this.listTotal = listTotal;
	}
	
	@JsonIgnore
	public List<Suburb> getSuburbs() {
		return suburbs;
	}
	public void setSuburbs(List<Suburb> suburbs) {
		this.suburbs = suburbs;
	}
	
	@Override
	public String toString() {
		return "Postcode " + postcode + " appared " + 
				listTotal + " times" + " (max) $" + highestPrice + " (min) $" + lowestPrice;
	}
	public BigDecimal getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(BigDecimal highestPrice) {
		this.highestPrice = highestPrice;
	}
	public BigDecimal getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(BigDecimal lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	

}
