package com.example.springSecurity.repository;

import com.example.springSecurity.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDateDesc(Long customerId);
}