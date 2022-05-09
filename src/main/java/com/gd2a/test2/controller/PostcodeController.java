package com.gd2a.test2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gd2a.test2.model.Postcode;
import com.gd2a.test2.repository.PostcodeRepository;

@RestController
public class PostcodeController {

	@Autowired
	private PostcodeRepository postcodeRepository;
	
	@GetMapping("/postcode/{postcode}")
	public Postcode getPostcode(@PathVariable String postcode) {
		return postcodeRepository.findByPostcode(postcode);
	}
	
}
