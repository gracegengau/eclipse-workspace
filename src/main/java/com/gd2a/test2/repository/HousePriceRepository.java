package com.gd2a.test2.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.gd2a.test2.model.HousePrice;

public interface HousePriceRepository extends CrudRepository<HousePrice, Integer> {
	
	List<HousePrice> findByPostcode(String postcode);

	List<HousePrice> findByPostcodeAndSuburb(String postcode, String suburb);
	
	List<HousePrice> getByPostcodeOrderByDateSoldDesc(String postcode, Pageable pageable);

	default List<HousePrice> findLatestHouseSold(String postcode, int count) {
		return getByPostcodeOrderByDateSoldDesc(postcode, PageRequest.of(0, count));
	}
}
