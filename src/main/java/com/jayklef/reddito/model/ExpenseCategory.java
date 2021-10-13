package com.jayklef.reddito.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExpenseCategory {

    @Id
    @SequenceGenerator(name = "expenseCategory_sequence", sequenceName = "expenseCategory_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenseCategory_sequence")
    private Long Id;
    private String name;

    @OneToOne
    private Expense expense;
}
