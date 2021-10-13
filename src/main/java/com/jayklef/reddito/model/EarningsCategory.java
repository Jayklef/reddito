package com.jayklef.reddito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EarningsCategory {

    @Id
    @SequenceGenerator(name = "earningsCategory_sequence", sequenceName = "earningsCategory_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "earningsCategory_sequence")
    private Long Id;
    private String name;

    @JsonIgnoreProperties
    @OneToOne
    private Earnings earnings;
}
