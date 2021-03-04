package com.example.Wallet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int transactionid;
	
	@Column(name="sid")
	private int sourcewalletid;
	
	@Column(name="tid")
	private int targetwalletid;
	
	@Column(name="amount")
	private double amount;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(int sourcewalletid, int targetwalletid, double amount) {
		
		this.sourcewalletid = sourcewalletid;
		this.targetwalletid = targetwalletid;
		this.amount = amount;
	}

	

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getSourcewalletid() {
		return sourcewalletid;
	}

	public void setSourcewalletid(int sourcewalletid) {
		this.sourcewalletid = sourcewalletid;
	}

	public int getTargetwalletid() {
		return targetwalletid;
	}

	public void setTargetwalletid(int targetwalletid) {
		this.targetwalletid = targetwalletid;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	
}
