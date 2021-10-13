package com.jayklef.reddito.service;

import com.jayklef.reddito.controller.EarningsCategoryController;
import com.jayklef.reddito.model.EarningsCategory;
import com.jayklef.reddito.repository.EarningsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarningsCategoryServiceImpl implements EarningsCategoryService{

    private final EarningsCategoryRepository earningsCategoryRepository;

    @Autowired
    public EarningsCategoryServiceImpl(EarningsCategoryRepository earningsCategoryRepository) {
        this.earningsCategoryRepository = earningsCategoryRepository;
    }

    @Override
    public EarningsCategory saveEarningsCategory(EarningsCategory earningsCategory) {
        return earningsCategoryRepository.save(earningsCategory);
    }
}
