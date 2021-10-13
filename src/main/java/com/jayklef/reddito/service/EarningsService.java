package com.jayklef.reddito.service;

import com.jayklef.reddito.dtos.EarningsDTO;
import com.jayklef.reddito.error.EarningNotFoundException;
import com.jayklef.reddito.error.ProfileNotFoundException;
import com.jayklef.reddito.model.Earnings;

import java.util.List;

public interface EarningsService {
    Earnings saveEarning(EarningsDTO earningsDto);

    List<Earnings> getEarningsList();

    List<Earnings> getEarningsByProfile(Long profileId) throws ProfileNotFoundException;

    Earnings getEarningById(Long Id) throws EarningNotFoundException;

    void deleteEarning(Long id);

}
