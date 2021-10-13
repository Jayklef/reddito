package com.jayklef.reddito.service;

import com.jayklef.reddito.model.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryService {
    ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory);

    ExpenseCategory getExpenseCategoryById(Long id);

    List<ExpenseCategory> getAllExpenseCategory();
}
