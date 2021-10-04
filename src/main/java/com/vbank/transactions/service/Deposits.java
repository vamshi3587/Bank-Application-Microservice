package com.vbank.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vbank.transactions.Call.CallingToService;
import com.vbank.transactions.entity.Payments;
import com.vbank.transactions.entity.Transactions;

@Service
public class Deposits {

	@Autowired
	TransactionService serv;

	@Autowired
	CallingToService call;

	public Transactions depositeAmount(Transactions payment) {
		double oldAmount = payment.getAmount();
		Transactions trans = serv.getTrans(payment.getCif());
		ResponseEntity<Payments> pay = call.createPayment(
				new Payments(0, payment.getCif(), payment.getAmount(), 0, payment.getPaymentdate(), "DEPOSIT"));
		System.out.println("Deposite Service " + pay);
		double newAmount = trans.getAmount() + oldAmount;
		trans.setAmount(newAmount);
		System.out.println(newAmount);
		/*
		 * Payments pay2 = call.getPayment(new Payments(pay.getBody().getPaymentId(),
		 * trans.getCif(), trans.getAmount(), newAmount, trans.getPaymentdate(),
		 * "DEPOSIT"));
		 */
		System.out.println(call.updatepayment(new Payments(pay.getBody().getPaymentId(), pay.getBody().getCif(), payment.getAmount(), newAmount, payment.getPaymentdate(), pay.getBody().getOperation())));
		serv.saveTrans(trans);
		return trans;

	}
}
