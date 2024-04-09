package com.unipi.postgraduate_jkarageorgos.covidapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String isoCode;
    private String continent;
    private String location;
    private Double populationDensity;
    private Double medianAge;
    private Double aged65Older;
    private Double aged70Older;
    private Double gdpPerCapita;
    private Double extremePoverty;
    private Double cardiovascDeathRate;
    private Double diabetesPrevalence;
    private Double femaleSmokers;
    private Double maleSmokers;
    private Double handwashingFacilities;
    private Double hospitalBedsPerThousand;
    private Double lifeExpectancy;
    private Double humanDevelopmentIndex;
    private long population;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Data> dataList = new ArrayList<Data>();
}
