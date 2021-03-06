package com.example.Wallet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {

	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 private int walletid;
	 
	 @Column(name="balance")
	 private double balance;
	 
	public int getId() {
		return walletid;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}
	public Wallet(double balance) {
		
		this.balance = balance;
	}

	public void setId(int id) {
		this.walletid = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
 	 
}
