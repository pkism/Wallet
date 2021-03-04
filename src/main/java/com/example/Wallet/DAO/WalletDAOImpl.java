package com.example.Wallet.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Wallet.Entity.Wallet;


@Repository
public class WalletDAOImpl implements WalletDAO {

	@Autowired
	EntityManager entityManager;
	
	
	@Override
	@Transactional
	public void addMoney(int walletId, double money) {
		// TODO Auto-generated method stub
         
		Session session=entityManager.unwrap(Session.class);
		//System.out.println(walletId);
		Wallet wallet=session.get(Wallet.class, walletId);
		
		//System.out.println("yyyy");
		//System.out.println(wallet);
		
	    double balance=wallet.getBalance();
		
		balance=balance+money;
		
		Query query=session.createQuery("Update Wallet "
				                         + "set balance=:balance "
				                          + "where walletid=:walletId");
		
		query.setParameter("balance", balance);
		query.setParameter("walletId", walletId);
		
		query.executeUpdate();
	}


	@Override
	@Transactional
	public void deductmoney(int sourcewalletid, double money) throws Exception {
		// TODO Auto-generated method stub
	    
		
        Session session=entityManager.unwrap(Session.class);
		
        Wallet wallet=session.get(Wallet.class, sourcewalletid);
		
		
		
	    double balance=wallet.getBalance();
		
		balance=balance-money;
		
		if(balance<0)
		{
			throw new Exception();
		}
		Query query=session.createQuery("Update Wallet "
				                         + "set balance=:balance "
				                          + "where walletid=:walletId");
		
		query.setParameter("balance", balance);
		query.setParameter("walletId", sourcewalletid);
		
		query.executeUpdate();
	}

}
