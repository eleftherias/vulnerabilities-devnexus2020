package com.example.bank.account.transfer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Rob Winch
 */
public interface TransferRequestRepository extends CrudRepository<TransferRequest, Long> {
	List<TransferRequest> findByTransferFromOwnerId(Long id);
}
