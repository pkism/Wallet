package com.example.Wallet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Wallet.DAO.UserDAO;
import com.example.Wallet.DAO.WalletDAO;
import com.example.Wallet.Entity.Transaction;
import com.example.Wallet.Entity.User_Details;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	UserDAO userdao;
	
	@Autowired
	WalletDAO walletdao;
	
	
	//This API will work for new user or we can say login/sign-up
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody User_Details user)
	{
        userdao.addUser(user);		
	}
	
	
	//This will return all transaction for a user
	
	@GetMapping("/gettransaction/{userid}")
	public List<Transaction> getalltransaction(@PathVariable int userid)
	{
		return userdao.getalltransaction(userid);
	}
	
	//This api will call for transaction between two users
	
	@PutMapping("/dotransaction")
	public String dotransaction(@RequestBody Transaction transaction)
	{
	     userdao.addtransaction(transaction);
		//System.out.println(transaction.getTargetwalletid());
		 return userdao.dotransaction(transaction);
		  
	}
}
