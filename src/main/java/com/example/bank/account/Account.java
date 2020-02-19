package com.example.bank.account;

import com.example.bank.user.BankUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Rob Winch
 */
@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private BankUser owner;

	private Double balance;

	public Account(BankUser owner, Double balance) {
		this.owner = owner;
		this.balance = balance;
	}

	public Account() {}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BankUser getOwner() {
		return this.owner;
	}

	public void setOwner(BankUser owner) {
		this.owner = owner;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
