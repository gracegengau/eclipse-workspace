package com.gd2a.test2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/load")

public class LoadController {
	@Autowired
	Job job;
	
	@Autowired
	JobLauncher jobLauncher;

	@GetMapping
	public String load1() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException 
	{
		 Map<String, JobParameter> maps = new HashMap<>();
	     maps.put("time", new JobParameter(System.currentTimeMillis()));
	     JobParameters parameters = new JobParameters(maps);
	     JobExecution jobExecution = jobLauncher.run(job, parameters);

	        System.out.println("@@@@@@@@@@>>>>>>>>>>>>load1()    JobExecution: " + (jobExecution).getStatus());

	        System.out.println(">>>>>>>>>>>Batch is Running...");
	        while (jobExecution.isRunning()) {
	            System.out.println(">>>>>>>>>...");
	        }

	        return "index";
	}

	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException 
	{
		 Map<String, JobParameter> maps = new HashMap<>();
	     maps.put("time", new JobParameter(System.currentTimeMillis()));
	     JobParameters parameters = new JobParameters(maps);
	     JobExecution jobExecution = jobLauncher.run(job, parameters);

	        System.out.println(">>>>>>>>>>>>JobExecution: " + (jobExecution).getStatus());

	        System.out.println(">>>>>>>>>>>Batch is Running...");
	        while (jobExecution.isRunning()) {
	            System.out.println(">>>>>>>>>...");
	        }

	        return jobExecution.getStatus();
	}
}	
