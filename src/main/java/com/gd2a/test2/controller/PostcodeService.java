package com.gd2a.test2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd2a.test2.model.Postcode;
import com.gd2a.test2.repository.PostcodeRepository;

@Service
public class PostcodeService {
	@Autowired
	private PostcodeRepository postcodeRepository;
	
	public List<Postcode> ListAllPostcodes() {
		return (List<Postcode>) postcodeRepository.getAllByOrderByPostcode();
	}

	public Postcode listByPostcode(String postcode) {
		return postcodeRepository.findByPostcode(postcode);
	}
}
