package com.jayklef.reddito.controller;

import com.jayklef.reddito.model.TransactionSummary;
import com.jayklef.reddito.service.EarningsService;
import com.jayklef.reddito.service.ExpenseService;
import com.jayklef.reddito.service.ProfileService;
import com.jayklef.reddito.service.TransactionSummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TransactionSummaryController {

    private TransactionSummaryService transactionSummaryService;
    private EarningsService earningsService;
    private ExpenseService expenseService;
    private ProfileService profileService;

    public TransactionSummaryController(TransactionSummaryService transactionSummaryService, EarningsService earningsService, ExpenseService expenseService, ProfileService profileService) {
        this.transactionSummaryService = transactionSummaryService;
        this.earningsService = earningsService;
        this.expenseService = expenseService;
        this.profileService = profileService;
    }

    @GetMapping("/transactionsummaries/{id}")
    public TransactionSummary findTransactionSummaryById(@PathVariable("id") Long profileId){
        return profileService.findTransactionSummaryByProfileId(profileId);
    }

}
