package com.example.bank.account;

import com.example.bank.account.transfer.TransferRequest;
import com.example.bank.account.transfer.TransferRequestRepository;
import com.example.bank.user.BankUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Rob Winch
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	final AccountRepository accounts;

	final TransferRequestRepository transfers;

	public AccountController(AccountRepository accounts, TransferRequestRepository transfers) {
		this.accounts = accounts;
		this.transfers = transfers;
	}

	@GetMapping
	String account(@ModelAttribute("currentUser") BankUser currentUser, Map<String, Object> model) {
		Long currentUserId = currentUser.getId();
		Account account = this.accounts.findAccountByOwnerId(currentUserId);
		Iterable<TransferRequest> transfers = this.transfers.findByTransferFromOwnerId(currentUserId);
		model.put("account", account);
		model.put("transfers", transfers);
		return "account/index";
	}
}
