package com.example.bank.account;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Rob Winch
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
	Account findAccountByOwnerId(Long ownerId);

	Account findAccountByOwnerEmail(String email);
}
