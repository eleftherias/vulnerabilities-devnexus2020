package com.example.bank.user;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author Rob Winch
 */
@ControllerAdvice
public class UserControllerAdvice {
	final UserRepository users;

	public UserControllerAdvice(UserRepository users) {
		this.users = users;
	}

	@ModelAttribute("currentUser")
	BankUser currentUser(@SessionAttribute(name = "USER", required = false) Long id) {
		Long currentUserId = id == null ? 1L : id;
		return this.users.findById(currentUserId).orElse(null);
	}
}
