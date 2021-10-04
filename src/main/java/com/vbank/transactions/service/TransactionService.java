package com.vbank.transactions.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vbank.transactions.Call.CallingToService;
import com.vbank.transactions.connecttodb.TransactionConnecttoDb;
import com.vbank.transactions.entity.Payments;
import com.vbank.transactions.entity.Transactions;

@Service
public class TransactionService {
private static final Logger log= LoggerFactory.getLogger(TransactionService.class);
	@Autowired
	TransactionConnecttoDb con;
	
	@Autowired
	CallingToService serv;
	
	public Transactions saveTrans(Transactions trans) {
		log.info("Save Transaction {}",trans);
		con.save(trans);
		return trans;
		
	}
	
	
	public Transactions updateAmount(Transactions trans) {
		
		return saveTrans(trans);
	}
	
	public Transactions getTrans(int cif) {
		Transactions trans=con.findByCif(cif);
		return trans;
	}
	
	public ResponseEntity<Payments> name(Payments payment) {
		return serv.createPayment(payment);
		
	}
}
