package com.jayklef.reddito.service;

import com.jayklef.reddito.error.ProfileNotFoundException;
import com.jayklef.reddito.model.Profile;
import com.jayklef.reddito.model.TransactionSummary;
import com.jayklef.reddito.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final TransactionSummaryService transactionSummaryService;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, TransactionSummaryService transactionSummaryService) {
        this.profileRepository = profileRepository;
        this.transactionSummaryService = transactionSummaryService;
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long profileId) throws ProfileNotFoundException {
        Optional<Profile> profile = profileRepository.findById(profileId);

        if (!profile.isPresent()){
            throw new ProfileNotFoundException("Profile Not Seen");
        }

        return profile.get();
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findProfileByProfileName(String profileName) {
        return profileRepository.findProfileByProfileName(profileName);
    }

    @Override
    public Profile updateProfile(Long profileId, Profile profile) {
        Profile profileInDb = profileRepository.findById(profileId).get();

        if (Objects.nonNull(profile.getProfileName()) &&
                !"".equalsIgnoreCase(profile.getProfileName())) {
                    profileInDb.setProfileName(profile.getProfileName());
        }

        if (Objects.nonNull(profile.getProfileAge()) &&
        !"".equalsIgnoreCase(profile.getProfileAge())){
            profileInDb.setProfileAge(profile.getProfileAge());
        }

        if (Objects.nonNull(profile.getProfileGender())&&
        !"".equalsIgnoreCase(profile.getProfileGender())){
            profileInDb.setProfileGender(profile.getProfileGender());
        }

        if (Objects.nonNull(profile.getProfileProfession()) &&
        !"".equalsIgnoreCase(profile.getProfileProfession())){
            profileInDb.setProfileProfession(profile.getProfileProfession());
        }

        if (Objects.nonNull(profile.getProfileLocation()) &&
        !"".equalsIgnoreCase(profile.getProfileLocation())){
            profileInDb.setProfileLocation(profile.getProfileLocation());
        }

        return profileRepository.save(profileInDb);
    }

    @Override
    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
    }

    @Override
    public TransactionSummary findTransactionSummaryByProfileId(Long profileId) {
        return transactionSummaryService.getTransactionSummaryById(profileId);
    }
}
