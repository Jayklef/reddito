package com.jayklef.reddito.controller;

import com.jayklef.reddito.dtos.ExpenseDTO;
import com.jayklef.reddito.model.Expense;
import com.jayklef.reddito.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/expenses")
    public Expense saveExpense(@RequestBody ExpenseDTO expenseDTO){
        return expenseService.saveExpense(expenseDTO);
    }

    @GetMapping("/expenses")
    public List<Expense> getExpensesList(){
        return expenseService.getExpensesList();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpensesById(@PathVariable("id") Long expenseId){
        return expenseService.getExpensesById(expenseId);
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpenseById(@PathVariable("id")Long expenseId){
        expenseService.deleteExpenseById(expenseId);
        return "Expense deleted successfully";
    }
}
