package com.jayklef.reddito.controller;

import com.jayklef.reddito.error.ProfileNotFoundException;
import com.jayklef.reddito.model.Profile;
import com.jayklef.reddito.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/profiles")
    public Profile saveProfile(@Valid @RequestBody Profile profile){
        return profileService.saveProfile(profile);
    }

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/profiles/{id}")
    public Profile getProfileById(@PathVariable("id") Long profileId) throws ProfileNotFoundException {
        return profileService.getProfileById(profileId);
    }

    @GetMapping("/profiles/name/{name}")
    public Profile findProfileByProfileName(@PathVariable("name") String profileName){
        return profileService.findProfileByProfileName(profileName);
    }

    @PutMapping("/profiles/{id}")
    public Profile updateProfile(@PathVariable("id") Long profileId,
                                 @RequestBody Profile profile){
        return profileService.updateProfile(profileId, profile);
    }

    @DeleteMapping("/profiles/{id}")
    public String deleteProfile(@PathVariable("id") Long profileId){
        profileService.deleteProfile(profileId);
        return "Profile deleted successfully";
    }
}

