package com.example.bank.account.transfer;

import com.example.bank.account.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Rob Winch
 */
@Entity
public class TransferRequest {
	@Id
	@GeneratedValue
	private Long id;

	private String description;

	@ManyToOne
	private Account transferTo;

	@ManyToOne
	private Account transferFrom;

	private double amount;

	public TransferRequest() {}

	public TransferRequest(String description, Account transferTo, Account transferFrom, double amount) {
		this.description = description;
		this.transferTo = transferTo;
		this.transferFrom = transferFrom;
		this.amount = amount;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the account the money is going to
	 * @return
	 */
	public Account getTransferTo() {
		return this.transferTo;
	}

	public void setTransferTo(Account transferTo) {
		this.transferTo = transferTo;
	}

	/**
	 * Get the account the money is from
	 * @return
	 */
	public Account getTransferFrom() {
		return this.transferFrom;
	}

	public void setTransferFrom(Account transferFrom) {
		this.transferFrom = transferFrom;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
