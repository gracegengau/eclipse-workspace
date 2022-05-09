package com.gd2a.test2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd2a.test2.model.HousePrice;
import com.gd2a.test2.repository.HousePriceRepository;

@Service
public class HousePriceService {

	@Autowired
	private HousePriceRepository housePriceRepository;
	
	public List<HousePrice> listByPostcode(String postcode) {
		return housePriceRepository.findByPostcode(postcode);
	}
	
	
}
