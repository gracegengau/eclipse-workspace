package com.gd2a.test2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd2a.test2.model.Suburb;
import com.gd2a.test2.repository.HousePriceRepository;
import com.gd2a.test2.repository.SuburbRepository;

@Service
public class SuburbService {

	@Autowired
	private SuburbRepository suburbRepository;
	@Autowired 
	private HousePriceRepository housePriceRepository;
	
	
	public List<Suburb> ListAllSuburbs() {
		return (List<Suburb>) suburbRepository.getAllByOrderByPostcode();
	}

	public List<Suburb> ListSuburbsByPostcode(String postcode) {
		List<Suburb> returnSuburbs = suburbRepository.listSuburbByPostcode(postcode, 3); 
		returnSuburbs.forEach(s -> {
			s.setHouseSold(housePriceRepository.findByPostcodeAndSuburb(postcode, s.getSuburb()));
		});
		return returnSuburbs;
	}
	
	public Suburb listBySuburb(String suburbName) {
		Suburb suburbFound = suburbRepository.findBySuburb(suburbName);
		
		suburbFound.setHouseSold(housePriceRepository.findByPostcodeAndSuburb(suburbFound.getPostcode().getPostcode(), suburbName));
		return suburbFound;
	}

}
