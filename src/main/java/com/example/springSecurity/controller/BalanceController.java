package com.example.springSecurity.controller;

import com.example.springSecurity.model.AccountTransactions;
import com.example.springSecurity.repository.AccountTransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam long id) {
        List<AccountTransactions> transactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDateDesc(id);
        return transactions;
    }
}