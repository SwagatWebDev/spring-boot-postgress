package com.springbootpostgres.springbootpostgrespractise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "citycode", columnDefinition = "Character varying(3) not null default 'NA'")
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

//    @Column(name = "country_id")
//    private int countryId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    //@JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;
}
