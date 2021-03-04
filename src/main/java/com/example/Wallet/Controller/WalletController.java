package com.example.Wallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/addmoney/{walletid}/{money}")
	public void addMoney(@PathVariable int walletid, @PathVariable double money)
	{
		walletdao.addMoney(walletid, money);		
	}
}
