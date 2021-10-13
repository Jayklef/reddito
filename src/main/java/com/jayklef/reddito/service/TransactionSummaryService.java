package com.jayklef.reddito.service;

import com.jayklef.reddito.model.TransactionSummary;

import java.time.LocalDate;

public interface TransactionSummaryService {

    TransactionSummary getTransactionSummaryById(Long profileId);
}
