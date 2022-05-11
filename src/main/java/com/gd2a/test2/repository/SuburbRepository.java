package com.gd2a.test2.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.gd2a.test2.model.Suburb;

public interface SuburbRepository extends CrudRepository<Suburb, Integer> {

	List<Suburb> getAllByOrderByPostcode();
	
	Suburb findBySuburb(String suburbName);
	
	List<Suburb> findByPostcodeid(String postcode, Pageable pageable);
	
	default
		List<Suburb> listSuburbByPostcode(String postcode, Integer count) {
			Pageable pageable = PageRequest.of(0, count);
			return findByPostcodeid(postcode, pageable);
		}
}
