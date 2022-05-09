package com.gd2a.test2.config;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd2a.test2.model.Postcode;
import com.gd2a.test2.model.Suburb;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport
{
	
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	  private final EntityManager em;
	  
	  @Autowired
	  public JobCompletionNotificationListener(EntityManager em) {
	    this.em = em;
	  }

	  @Override
	  @Transactional
	  public void afterJob(JobExecution jobExecution) 
	  {
		  if(jobExecution.getStatus() == BatchStatus.COMPLETED) 
		  {
			  Map<String, Postcode> pc = new HashMap<>();
			  Map<String, Suburb> ss = new HashMap<>();
			  
			  log.info("\n!!!!!!->-> JOB FINISHED! Time to verify the results");
	      
//			  em.createQuery("select h.postcode, max(h.suburb) as suburb, count(*) from HousePrice h group by h.postcode", Object[].class)
//			  .getResultList()
//			  .stream()
//			  .map(e -> new Postcode((String) e[0], (String) e[1], (Long) e[2]))
//			  .forEach(postcode -> pc.put(postcode.getPostcode(), postcode)

			  em.createQuery("select h.postcode, count(*) from HousePrice h group by h.postcode", Object[].class)
			  .getResultList()
			  .stream()
			  .map(e -> new Postcode((String) e[0], (Long) e[1]))
			  .forEach(postcode -> pc.put(postcode.getPostcode(), postcode)
			  );
			  
			  em.createQuery("select h.postcode, max(h.price) from HousePrice h group by h.postcode", Object[].class)
			  .getResultList()
			  .stream()
			  .forEach(e -> {
				  Postcode postcode = pc.get((String) e[0]);
				  postcode.setHighestPrice((BigDecimal) e[1]);
			  });

			  em.createQuery("select h.postcode, min(h.price) from HousePrice h group by h.postcode", Object[].class)
			  .getResultList()
			  .stream()
			  .forEach( e-> {
				  Postcode postcode = pc.get((String) e[0]);
				  postcode.setLowestPrice((BigDecimal) e[1]);
			  });
			  
			  em.createQuery("select h.suburb, max(h.postcode) as postcode from HousePrice h group by h.suburb", Object[].class)
			  .getResultList()
			  .stream()
			  .map(e -> new Suburb((String) e[0], (Postcode) pc.get(e[1])))
			  .forEach(suburb -> {
//				  System.out.println(suburb.toString());
				  ss.put(suburb.getSuburb(), suburb);  
			  });
			  
			  log.info("\n!!!!!!->-> JOB FINISHED! check suburb results");

			 //			  em.createQuery("select h.suburb, max(h.postcode) as postcode from HousePrice h group by h.suburb", Object[].class)
//			  .getResultList()
//			  .stream()
//			  .forEach(e -> {
//				  Postcode postcode = pc.get((String) e[1]);
//				  List<String> names = postcode.getSuburbName();
//				  names.add((String) e[0]);
//				  postcode.setSuburbName(names);
				  
//				  postcode.getSuburbName()
//				  .forEach(t -> System.out.println("-----------------------strings: " + t));
//			  });
			  
		      pc.values().forEach(postcode -> em.persist(postcode));
		      ss.values().forEach(suburb -> em.persist(suburb));
		      //		      pc.values().forEach(postcode -> System.out.println(postcode));
		  }
	  
	  }
	  
}
