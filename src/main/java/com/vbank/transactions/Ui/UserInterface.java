package com.vbank.transactions.Ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vbank.transactions.entity.Transactions;
import com.vbank.transactions.service.Deposits;
import com.vbank.transactions.service.TransactionService;

@RestController
@RequestMapping("/api")
public class UserInterface {

	private static final Logger log=LoggerFactory.getLogger(UserInterface.class);		
	@Autowired
	private  TransactionService serv;
	@Autowired
	private  Deposits deposite;

	@PostMapping("/save")
	public Transactions savetrans(@RequestBody Transactions trans) {
		log.info("Save Transaction");
		return serv.saveTrans(trans);
	}

	@GetMapping("/get/{cif}")
	public Transactions getTransactions(@PathVariable int cif) {
		log.info("get transaction");
		return serv.getTrans(cif);
	}

	@PatchMapping("/update")
	public Transactions depositeAmount(@RequestBody Transactions trans) {
		log.info("Deposite Amount..");
		return deposite.depositeAmount(trans);

	}
}
