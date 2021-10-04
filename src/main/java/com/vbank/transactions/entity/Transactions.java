package com.vbank.transactions.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Transaction")
public class Transactions {

	@Id
	private int cif;
	private double amount;
	@JsonFormat(shape = Shape.STRING,pattern = "dd/mm/yyyy")
	private String paymentdate;
}

