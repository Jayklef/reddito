package com.jayklef.reddito.dtos;

import com.jayklef.reddito.model.EarningsCategory;
import com.jayklef.reddito.model.Profile;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class EarningsDTO {

    @NotBlank
    private String earningsTitle;
    private LocalDate dateDone;
    private Integer amount;

    @Min(1)
    private Long earningsCategoryId;

    @Min(1)
    private Long profileId;
}
