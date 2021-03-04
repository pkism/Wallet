package com.example.Wallet.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Wallet.Entity.Transaction;
import com.example.Wallet.Entity.User_Details;
import com.example.Wallet.Entity.Wallet;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	WalletDAO walletdao;
	
	
	
	@Override
	@Transactional
	public void addUser(User_Details user) {
		// TODO Auto-generated method stub
       Session session=entityManager.unwrap(Session.class);
       
       Wallet wallet=user.getWallet();
       
       user.setWallet(wallet);
       
       session.saveOrUpdate(user); 
	}

	@Override
	@Transactional
	public List<Transaction> getalltransaction(int userid) {
		// TODO Auto-generated method stub
		List<Transaction> transationlist=new ArrayList<>();
		try {
		
		
		Session session=entityManager.unwrap(Session.class);
		
		User_Details user=session.get(User_Details.class, userid);
		
		int sourceid=user.getWallet().getId();
		
		Query query=session.createQuery("from Transaction"
				                         + " where sid=:userid");
		
		query.setParameter("userid", sourceid);
		
		transationlist=query.getResultList();
				
	    }catch(Exception e)
	    {
	    	System.out.println("Invalid UserId");
	    	e.printStackTrace(); 
	    }
		return transationlist;
	}

	@Override
	@Transactional
	public String dotransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
		int sourcewalletid=transaction.getSourcewalletid();
		int targetwalletid=transaction.getTargetwalletid();
		//System.out.println(targetwalletid);
		double money=transaction.getAmount();
		try {
		
		double charges=(money*0.2/100);
		
		double commision=(money*.05/100);
		
		double finalmoney = money-(charges + commision);   
				
		walletdao.deductmoney(sourcewalletid,money);
		
		walletdao.addMoney(targetwalletid, finalmoney);
		
		}
		catch(Exception e)
		{
			walletdao.addMoney(sourcewalletid, money);
			e.printStackTrace();
			return "Transaction Failed !!!";
		}
		return "Successfully Transaction !!!";
	}

	@Override
	@Transactional
	public void addtransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
	       
	    session.saveOrUpdate(transaction);
	}

}
