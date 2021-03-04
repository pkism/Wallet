package com.example.Wallet.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User_Details {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int userid;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="wallet_id")
	private Wallet wallet;

	User_Details()
	{
		
	}
	

	public User_Details(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getId() {
		return userid;
	}

	public void setId(int id) {
		this.userid = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	
	
}
