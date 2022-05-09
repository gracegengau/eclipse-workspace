package com.gd2a.test2.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd2a.test2.model.HousePrice;
import com.gd2a.test2.repository.HousePriceRepository;

@Component
public class Writer implements ItemWriter<HousePrice> {
	
	@Autowired
	private HousePriceRepository housePriceRepository;
	
	public Writer() {
		
	}

	public Writer(HousePriceRepository housePriceRepository) {
		this.housePriceRepository = housePriceRepository;
	}
	
	@Override
	public void write(List<? extends HousePrice> housePrices) throws Exception {
		housePriceRepository.saveAll(housePrices);
		
//		System.out.println("      > > > > > > > > > > > data saved for house: " + housePrices);
	}
	
	
}
