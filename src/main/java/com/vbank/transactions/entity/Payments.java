package com.vbank.transactions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Payments {

	
	private int paymentId;
	private int cif;
	private double amount;
	private double finalAmount;
	private String paymentDate;
	private String operation;
	
	
}