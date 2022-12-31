package com.optivem.kata.banking.adapters.persistence.jpa.internal;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JpaBankAccountDataAccessor extends CrudRepository<BankAccountRecord, Long> {
    Optional<BankAccountRecord> findByAccountNumber(String accountNumber);
}