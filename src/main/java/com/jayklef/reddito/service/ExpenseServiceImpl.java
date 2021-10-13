package com.jayklef.reddito.service;

import com.jayklef.reddito.dtos.ExpenseDTO;
import com.jayklef.reddito.error.ProfileNotFoundException;
import com.jayklef.reddito.model.*;
import com.jayklef.reddito.repository.ExpenseCategoryRepository;
import com.jayklef.reddito.repository.ExpenseRepository;
import com.jayklef.reddito.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseCategoryRepository expenseCategoryRepository, ProfileRepository profileRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Expense saveExpense(ExpenseDTO expenseDTO) {
        //validate earning category exist
        final ExpenseCategory expenseCategory = this.expenseCategoryRepository
                .getById(expenseDTO.getExpenseCategoryId());

        if(expenseCategory == null){
            throw new EntityNotFoundException(String.format("Earnings Category with Id: %s not found.", expenseDTO.getExpenseCategoryId()));
        }

        // validate profile exist
        final Profile profile = this.profileRepository.getById(expenseDTO.getProfileId());
        if(profile == null){
            throw new ProfileNotFoundException(String.format("Profile with Id: %s not found.", expenseDTO.getProfileId()));
        }

        Expense expense = Expense.builder()
                .expenseTitle(expenseDTO.getExpenseTitle())
                .dateDone(expenseDTO.getDateDone())
                .amount(expenseDTO.getAmount())
                .expenseCategory(expenseCategory)
                .profile(profile)
                .build();

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getExpensesList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpensesById(Long expenseId) {
        return expenseRepository.findById(expenseId).get();
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }
}
