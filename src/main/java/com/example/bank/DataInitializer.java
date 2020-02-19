package com.example.bank;

import com.example.bank.account.Account;
import com.example.bank.account.AccountRepository;
import com.example.bank.account.transfer.TransferRequest;
import com.example.bank.account.transfer.TransferRequestRepository;
import com.example.bank.user.BankUser;
import com.example.bank.user.UserRepository;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author Rob Winch
 */
@Component
public class DataInitializer implements SmartInitializingSingleton {
	private final UserRepository users;

	private final AccountRepository accounts;

	private final TransferRequestRepository requests;

	public DataInitializer(UserRepository users, AccountRepository accounts,
			TransferRequestRepository requests) {
		this.users = users;
		this.accounts = accounts;
		this.requests = requests;
	}

	@Override
	public void afterSingletonsInstantiated() {
		BankUser ria = this.users
				.save(new BankUser(1L, "Ria", "Stein", "ria@example.com", "password"));
		BankUser henry = this.users
				.save(new BankUser(2L, "Henry", "Hacker", "hacker@example.com", "password"));

		Account riaAccount = this.accounts.save(new Account(ria, 500.00));
		Account henryAccount = this.accounts.save(new Account(henry, 10.00));

		TransferRequest request = new TransferRequest("I'm broke", henryAccount, riaAccount, 100);
		this.requests.save(request);
	}
}
