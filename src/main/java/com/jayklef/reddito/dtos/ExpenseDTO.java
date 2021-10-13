package com.jayklef.reddito.dtos;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class ExpenseDTO {

    @NotBlank
    private String expenseTitle;
    private LocalDate dateDone;
    private Integer amount;

    @Min(1)
    private Long expenseCategoryId;

    @Min(1)
    private Long profileId;
}
