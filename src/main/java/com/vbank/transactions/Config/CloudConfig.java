package com.vbank.transactions.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class CloudConfig {
 
	@Value("${Transaction.PaymentService}")
	public  String url ;
	@Bean
	public RestTemplate template() {
		System.out.println("url inside rest template " + url);
		return new RestTemplate();
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	

}
