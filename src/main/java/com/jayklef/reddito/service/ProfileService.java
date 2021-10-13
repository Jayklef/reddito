package com.jayklef.reddito.service;

import com.jayklef.reddito.error.ProfileNotFoundException;
import com.jayklef.reddito.model.Profile;
import com.jayklef.reddito.model.TransactionSummary;

import java.util.List;

public interface ProfileService {
    public Profile saveProfile(Profile profile);

    public Profile getProfileById(Long profileId) throws ProfileNotFoundException;

    public List<Profile> getAllProfiles();

    public Profile findProfileByProfileName(String profileName);

    public Profile updateProfile(Long profileId, Profile profile);

    public void deleteProfile(Long profileId);

    public TransactionSummary findTransactionSummaryByProfileId(Long profileId);
}
