package com.example.Wallet.DAO;

import java.util.List;

import com.example.Wallet.Entity.Transaction;
import com.example.Wallet.Entity.User_Details;

public interface UserDAO {

	
	public void addUser(User_Details user);

	public List<Transaction> getalltransaction(int userid);

	public String dotransaction(Transaction transaction);

	public void addtransaction(Transaction transaction);
	
}
