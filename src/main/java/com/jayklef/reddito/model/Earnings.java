package com.jayklef.reddito.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Earnings {

    @Id
    @SequenceGenerator(name = "earnings_sequence", sequenceName = "earnings_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "earnings_sequence")
    private Long Id;

    private String earningsTitle;

    private LocalDate dateDone;

    private Integer amount;

    @OneToOne
    private EarningsCategory earningsCategory;
    

    @ManyToOne(
        cascade = CascadeType.ALL
    )

    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "profileId"
    )
    private Profile profile;
}
