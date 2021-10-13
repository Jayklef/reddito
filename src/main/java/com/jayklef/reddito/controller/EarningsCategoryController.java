package com.jayklef.reddito.controller;

import com.jayklef.reddito.model.EarningsCategory;
import com.jayklef.reddito.service.EarningsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EarningsCategoryController {

    private final EarningsCategoryService earningsCategoryService;

    @Autowired
    public EarningsCategoryController(EarningsCategoryService earningsCategoryService) {
        this.earningsCategoryService = earningsCategoryService;
    }

    @PostMapping("/earningsCategories")
    public EarningsCategory saveEarningsCategory(@RequestBody EarningsCategory earningsCategory){
        return earningsCategoryService.saveEarningsCategory(earningsCategory);
    }
}
