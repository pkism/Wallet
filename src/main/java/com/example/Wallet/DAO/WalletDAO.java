package com.example.Wallet.DAO;

public interface WalletDAO {
   
	public void addMoney(int walletId,double money);

	public double deductmoney(int sourcewalletid, double money);
	
	public double getMoney(int walletId);

	public void addMoneyRevers(int sourcewalletid, double walletmoney);
}
