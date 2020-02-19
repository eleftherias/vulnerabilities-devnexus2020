package com.example.bank.account.transfer;

import com.example.bank.account.Account;
import com.example.bank.account.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Rob Winch
 */
@Controller
@RequestMapping("/account/request")
public class TransferRequestController {

    final AccountRepository accounts;

    final TransferRequestRepository requests;

    public TransferRequestController(AccountRepository accounts,
            TransferRequestRepository requests) {
        this.accounts = accounts;
        this.requests = requests;
    }

    @PostMapping("/approve")
    String approve(@RequestParam Long requestId) {
        TransferRequest request = this.requests.findById(requestId).orElse(null);
        double amount = request.getAmount();
        Account to = request.getTransferTo();
        Account from = request.getTransferFrom();
        to.setBalance(to.getBalance() + amount);
        from.setBalance(from.getBalance() - amount);
        this.accounts.save(to);
        this.accounts.save(from);
        this.requests.deleteById(requestId);
        return "redirect:/account";
    }
}
