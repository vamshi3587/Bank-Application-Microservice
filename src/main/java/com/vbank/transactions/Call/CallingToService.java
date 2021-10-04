package com.vbank.transactions.Call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vbank.transactions.Config.CloudConfig;
import com.vbank.transactions.entity.Payments;


@Service
//@PropertySource("classpath:/src/main/resources/app.properties")
public class CallingToService {

private static final Logger log=LoggerFactory.getLogger(CallingToService.class);
	@Autowired
	RestTemplate temp ;
	
	@Autowired
	private CloudConfig config;
	
	public ResponseEntity<Payments> createPayment(Payments payment) {
		//System.out.println("calling url " + url);
		log.info("Request url http://localhost:9696/payment and request body {}" , payment);
		ResponseEntity<Payments> paymentresponse = temp.postForEntity(config.url+"payment", payment, Payments.class);
		log.info("Response received {}",paymentresponse);
		//System.out.println("Post class \n" +  payment);
		return paymentresponse;
		
	}
	
	/*
	 * public Payments getPayment(Payments payment){
	 * 
	 * Payments pay=temp.getForObject("http://localhost:9696/getpayment?id="+
	 * payment.getPaymentId(), Payments.class); System.out.println("get Class \n"+
	 * pay); return pay; }
	 */
	
	public ResponseEntity<Payments> updatepayment(Payments payment ) {
		System.out.println("first \n"+ payment);
		ResponseEntity<Payments> pay=temp.postForEntity(config.url+"update", payment,Payments.class);
		System.out.println("last\n" + pay);
		System.out.println(pay.getStatusCodeValue()+"/n"+pay.getHeaders()+"/n"+pay.getStatusCode()+"/n");
		return pay;
	}
}
