package com.example.Wallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Wallet.DAO.WalletDAO;

@RestController
@RequestMapping("/walletapi")
public class WalletController {

	@Autowired
	WalletDAO walletdao;
	
	//This api will call for add money in wallet
	
	@PostMapping("/addmoney/{walletid}/{money}")
	public void addMoney(@PathVariable int walletid, @PathVariable double money)
	{
		walletdao.addMoney(walletid, money);		
	}
	
	
	//This api will use for get money from a wallet
	
	@GetMapping("/getmoney/{walletid}")
	public double getMoney(@PathVariable int walletid)
	{
		return walletdao.getMoney(walletid);
	}
}
