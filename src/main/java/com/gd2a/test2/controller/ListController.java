package com.gd2a.test2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd2a.test2.model.HousePrice;
import com.gd2a.test2.model.Postcode;
import com.gd2a.test2.model.Suburb;

@Controller
@CrossOrigin

public class ListController {

	@Autowired
	private HousePriceService housePriceService;
	@Autowired
	private SuburbService suburbService;
	@Autowired
	private PostcodeService postcodeService;
	
	@GetMapping("/postcode")
	public String listByPostcode(Model model) {
		model.addAttribute("postcodes", housePriceService.listByPostcode("3168"));
		return "postcode";
	}
	
	@GetMapping("/users")
	public String test() {
		return "users";
		
	}

	@RequestMapping(value = "/listHousePriceByPostcode")
	@ResponseBody
	public List<HousePrice> listHousrPriceByPostcode() {
		return housePriceService.listByPostcode("3168");
	}
	
	@RequestMapping(value = "/listSuburbs")
	@ResponseBody
	public List<Suburb> listAllSuburbs() {
		return suburbService.ListAllSuburbs();
	}
	
	@RequestMapping(value = "/suburbs/{suburb}")
	@ResponseBody
	public Suburb listBySuburbName(@PathVariable String suburb) {
		return suburbService.listBySuburb(suburb);
	}
	
	@RequestMapping(value = "/listPostcodes")
	@ResponseBody
	public List<Postcode> listAllPostcodes() {
		return postcodeService.ListAllPostcodes();
	}
	
	@RequestMapping(value = "/listSuburbsByPostcode/{postcode}")
	@ResponseBody
	public List<Suburb> listSuburbsByPostcode(@PathVariable String postcode) {
		return suburbService.ListSuburbsByPostcode(postcode);
	}
	
}
