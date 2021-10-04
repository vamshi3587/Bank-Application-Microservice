package com.vbank.transactions.connecttodb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbank.transactions.entity.Transactions;

public interface TransactionConnecttoDb extends JpaRepository<Transactions, Integer>{

	public Transactions findByCif(int cif);
}
