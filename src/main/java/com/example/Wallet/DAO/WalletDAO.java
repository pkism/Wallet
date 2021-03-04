package com.example.Wallet.DAO;

public interface WalletDAO {
   
	public void addMoney(int walletId,double money);

	public void deductmoney(int sourcewalletid, double money) throws Exception;
}
