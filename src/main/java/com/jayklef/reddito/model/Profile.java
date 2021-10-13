package com.jayklef.reddito.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {

    @Id
    @SequenceGenerator(
            name = "profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )
    private Long profileId;

    @NotBlank
    private String profileName;
    private String profileAge;
    private String profileGender;
    private String profileProfession;
    private String profileLocation;

    @OneToMany(
            mappedBy = "profile"
    )
    private List<Earnings> earnings;

    @OneToMany(
            mappedBy = "profile"
    )
    private List<Expense> expenses;

    public Profile(Long profileId, String profileName, String profileAge, String profileGender, String profileProfession, String profileLocation) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profileAge = profileAge;
        this.profileGender = profileGender;
        this.profileProfession = profileProfession;
        this.profileLocation = profileLocation;
    }


}
