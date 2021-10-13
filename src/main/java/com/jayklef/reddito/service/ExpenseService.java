package com.jayklef.reddito.service;

import com.jayklef.reddito.dtos.ExpenseDTO;
import com.jayklef.reddito.model.Expense;

import java.util.List;

public interface ExpenseService {
    public Expense saveExpense(ExpenseDTO expenseDTO);

    public List<Expense> getExpensesList();

    public Expense getExpensesById(Long expenseId);

    public void deleteExpenseById(Long expenseId);
}
