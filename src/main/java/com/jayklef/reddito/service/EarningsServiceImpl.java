package com.jayklef.reddito.service;

import com.jayklef.reddito.dtos.EarningsDTO;
import com.jayklef.reddito.error.EarningNotFoundException;
import com.jayklef.reddito.error.ProfileNotFoundException;
import com.jayklef.reddito.model.Earnings;
import com.jayklef.reddito.model.EarningsCategory;
import com.jayklef.reddito.model.Profile;
import com.jayklef.reddito.repository.EarningsCategoryRepository;
import com.jayklef.reddito.repository.EarningsRepository;
import com.jayklef.reddito.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EarningsServiceImpl implements EarningsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EarningsServiceImpl.class);

    private final EarningsRepository earningsRepository;
    private final ProfileRepository profileRepository;
    private final EarningsCategoryRepository earningsCategoryRepository;

    @Autowired
    public EarningsServiceImpl(final EarningsRepository earningsRepository,
                               final ProfileRepository profileRepository,
                               final EarningsCategoryRepository earningsCategoryRepository) {
        this.earningsRepository = earningsRepository;
        this.profileRepository = profileRepository;
        this.earningsCategoryRepository = earningsCategoryRepository;
    }

    @Override
    public Earnings saveEarning(EarningsDTO earningsDto) {

        //validate earning category exist
        final EarningsCategory earningsCategory = this.earningsCategoryRepository
                .getById(earningsDto.getEarningsCategoryId());

        if(earningsCategory == null){
            throw new EntityNotFoundException(String.format("Earnings Category with Id: %s not found.", earningsDto.getEarningsCategoryId()));
        }

        // validate profile exist
        final Profile profile = this.profileRepository.getById(earningsDto.getProfileId());
        if(profile == null){
            throw new ProfileNotFoundException(String.format("Profile with Id: %s not found.", earningsDto.getProfileId()));
        }

        Earnings earnings = Earnings.builder()
                .earningsTitle(earningsDto.getEarningsTitle())
                .dateDone(earningsDto.getDateDone())
                .amount(earningsDto.getAmount())
                .earningsCategory(earningsCategory)
                .profile(profile)
                .build();
        return earningsRepository.save(earnings);
    }

    @Override
    public List<Earnings> getEarningsList() {
        return earningsRepository.findAll();
    }

    @Override
    public List<Earnings> getEarningsByProfile(Long profileId) throws ProfileNotFoundException {
        final Profile profile = this.profileRepository.getById(profileId);
        if(profile == null) throw new ProfileNotFoundException("Profile with Id: " + profileId + " not found");


        return this.earningsRepository.findAllByProfile(profile);
    }

    @Override
    public Earnings getEarningById(Long Id) throws EarningNotFoundException {
        Optional<Earnings> earnings = earningsRepository.findById(Id);

        if(earnings.isEmpty())
            throw new EarningNotFoundException("Earning with Id: " + Id + " not found.");

        return earnings.get();
    }

    @Override
    public void deleteEarning(Long id) {
        earningsRepository.deleteById(id);
    }

}
