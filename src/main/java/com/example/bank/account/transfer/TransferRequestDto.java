package com.example.bank.account.transfer;

/**
 * @author Rob Winch
 */
public class TransferRequestDto {
	private String description;

	private double amount;

	private String from;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
