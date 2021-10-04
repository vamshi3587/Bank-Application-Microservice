package com.vbank.transactions.Ui;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vbank.transactions.entity.Transactions;
import com.vbank.transactions.service.Deposits;
import com.vbank.transactions.service.TransactionService;

class UserInterfaceTest {

	@Autowired
	private  TransactionService serv;
	@Autowired
	private  Deposits deposite;
	
	Transactions trans=new Transactions(1234, 101,"25/09/2021");
	

	@Test
	public void savetrans() {
		Transactions trans2=serv.saveTrans(trans);
		assertNull(trans2.getCif()+trans2.getAmount(),trans2.getPaymentdate());
		
	}

	
}
