package com.jayklef.reddito.repository;

import com.jayklef.reddito.model.Earnings;
import com.jayklef.reddito.model.Profile;
import com.jayklef.reddito.model.TransactionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findProfileByProfileName(String profileName);

//    Profile findByProfileName(String profileName);

}
