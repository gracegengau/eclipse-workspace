package com.gd2a.test2.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.gd2a.test2.model.HousePrice;
import com.gd2a.test2.model.HousePriceInput;

@Configuration
@EnableBatchProcessing
public class BatchConfig 
{
	private final String[] FIELD_NAMES = new String[] {
		"streetAddress", "suburb", "postcode", "bedrooms", "bathrooms", "propertyType", "price", "dataSold"
	};
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job importHousePriceJob(JobCompletionNotificationListener listener, Step step1) {
	  return jobBuilderFactory.get("importHousePriceJob")
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	@Bean
	public Step step1(ItemProcessor<HousePriceInput, HousePrice> processor, ItemWriter<HousePrice> writer) {
	  return stepBuilderFactory
		.get("step1")
	    .<HousePriceInput, HousePrice> chunk(10)
	    .reader(reader())
	    .processor(processor)
	    .writer(writer)
	    .build();
	}
	
	@Bean
	public FlatFileItemReader<HousePriceInput> reader() {
	  return new FlatFileItemReaderBuilder<HousePriceInput>()
	    .name("housePriceItemReader")
	    .resource(new FileSystemResource("input/soldPrice-simple3.csv"))
	    .linesToSkip(1)
	    .lineMapper(LineMapper())
	    .build();
	}
	
	@Bean
	public LineMapper<HousePriceInput> LineMapper() {
		DefaultLineMapper<HousePriceInput> lineMapper = new DefaultLineMapper<HousePriceInput>() {
			@Override
			public HousePriceInput mapLine(String line, int lineNumber) throws Exception {
				HousePriceInput input = super.mapLine(line, lineNumber);
		        input.setLineNumber(lineNumber-1);
				return input;
			}
		};
		
		lineMapper.setLineTokenizer(new DelimitedLineTokenizer() {
	    	{
	    		setNames(FIELD_NAMES);
    			setDelimiter(",");
    		}
    	});

		lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<HousePriceInput>() {
			{
					setTargetType(HousePriceInput.class);
			}
		});
		
		return lineMapper;
	}

}
