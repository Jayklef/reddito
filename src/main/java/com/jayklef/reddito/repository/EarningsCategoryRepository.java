package com.jayklef.reddito.repository;

import com.jayklef.reddito.model.EarningsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningsCategoryRepository extends JpaRepository<EarningsCategory, Long> {
}
