package com.gd2a.test2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gd2a.test2.model.Postcode;

public interface PostcodeRepository extends CrudRepository<Postcode, String> {
	
	Postcode findByPostcode(String postcode);
	
	List<Postcode> getAllByOrderByPostcode();
}
