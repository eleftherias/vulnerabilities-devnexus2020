package com.example.bank.user;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Rob Winch
 */
public interface UserRepository extends PagingAndSortingRepository<BankUser, Long> {
	BankUser findByEmail(String email);
}
