package com.jayklef.reddito.repository;

import com.jayklef.reddito.model.Expense;
import com.jayklef.reddito.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Collection<Expense> findAllByProfile(Profile profile);
}
