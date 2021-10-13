package com.jayklef.reddito.repository;

import com.jayklef.reddito.model.Earnings;
import com.jayklef.reddito.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EarningsRepository extends JpaRepository<Earnings, Long> {

    List<Earnings> findAllByProfile(Profile profile);
}
