package com.gd2a.test2.step;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.gd2a.test2.model.HousePrice;
import com.gd2a.test2.model.HousePriceInput;

@Component
public class Processor implements ItemProcessor<HousePriceInput, HousePrice> {
	
//	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	private static final Map<String, String> GRADE_NAMES = new HashMap<>();

	public Processor() {
        GRADE_NAMES.put("1", "Grade-1");
        GRADE_NAMES.put("2", "Grade-2");
        GRADE_NAMES.put("3", "Grade-3");
        GRADE_NAMES.put("4", "Grade-4");
        GRADE_NAMES.put("5", "Grade-5");
	}
		
	@Override
	public HousePrice process(HousePriceInput item) throws Exception {
		HousePrice housePrice = new HousePrice();

//		String gradeCode = item.getGrade().toString();
//        String gradeName = GRADE_NAMES.get(gradeCode);
        housePrice.setId(item.getLineNumber());
        housePrice.setStreetAddress(item.getStreetAddress());
        housePrice.setSuburb(item.getSuburb());
        housePrice.setPostcode(item.getPostcode());
        housePrice.setBedrooms(item.getBedrooms());
        housePrice.setBathrooms(item.getBathrooms());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        housePrice.setDateSold(LocalDate.parse(item.getDateSold(), formatter));
        
        housePrice.setPrice(BigDecimal.valueOf(Long.valueOf(item.getPrice().replace("$", "").replace(",", ""))));
        
        return housePrice;
	}

}
