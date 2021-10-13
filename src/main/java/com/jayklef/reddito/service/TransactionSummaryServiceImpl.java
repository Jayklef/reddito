package com.jayklef.reddito.service;

import com.jayklef.reddito.model.Earnings;
import com.jayklef.reddito.model.Expense;
import com.jayklef.reddito.model.Profile;
import com.jayklef.reddito.model.TransactionSummary;
import com.jayklef.reddito.repository.EarningsRepository;
import com.jayklef.reddito.repository.ExpenseRepository;
import com.jayklef.reddito.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TransactionSummaryServiceImpl implements TransactionSummaryService{

    private ProfileRepository profileRepository;
    private EarningsRepository earningsRepository;
    private ExpenseRepository expenseRepository;

    @Override
    public TransactionSummary getTransactionSummaryById(Long profileId) {

        Profile profile = this.profileRepository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));

        Collection<Earnings> earnings = this.earningsRepository.findAllByProfile(profile);
        Collection<Expense> expenses = this.expenseRepository.findAllByProfile(profile);

        int e = 0;

        int totalExpenses = earnings.stream().mapToInt(Earnings::getAmount)
                .sum();

        int totalEarnings = expenses.stream().mapToInt(Expense::getAmount)
                .sum();

        int disposableIncome = totalEarnings - totalExpenses;

        final TransactionSummary transactionSummary = new TransactionSummary();
        transactionSummary.setTotalEarnings(totalEarnings);
        transactionSummary.setTotalExpenses(totalExpenses);
        transactionSummary.setDisposableIncome(disposableIncome);

        return transactionSummary;
    }

}
