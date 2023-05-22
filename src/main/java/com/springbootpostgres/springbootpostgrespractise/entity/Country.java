package com.springbootpostgres.springbootpostgrespractise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="country_name")
    private String countryName;

    private Long population;

    private int gdp;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "country_id")
    private Set<City> cities;
}
