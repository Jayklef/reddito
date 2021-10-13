package com.jayklef.reddito.controller;

import com.jayklef.reddito.model.ExpenseCategory;
import com.jayklef.reddito.service.ExpenseCategoryService;
import com.jayklef.reddito.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping("/expenseCategories")
    public ExpenseCategory saveExpenseCategory(@RequestBody ExpenseCategory expenseCategory){
       return expenseCategoryService.saveExpenseCategory(expenseCategory);
    }

    @GetMapping("/expenseCategories/{id}")
    public ExpenseCategory getExpenseCategoryById(@PathVariable ("id") Long id){
       return expenseCategoryService.getExpenseCategoryById(id);
    }

    @GetMapping("/expenseCategories")
    public List<ExpenseCategory> getAllExpenseCategory(){
        return expenseCategoryService.getAllExpenseCategory();
    }
}
