package com.unipi.postgraduate_jkarageorgos.covidapi.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private Integer totalCases;
    private Integer newCases;
    private Double newCasesSmoothed;
    private Integer totalDeaths;
    private Integer newDeaths;
    private Double newDeathsSmoothed;
    private Double totalCasesPerMillion;
    private Double newCasesPerMillion;
    private Double newCasesSmoothedPerMillion;
    private Double totalDeathsPerMillion;
    private Double newDeathsPerMillion;
    private Double newDeathsSmoothedPerMillion;
    private Double reproductionRate;
    private Integer icuPatients;
    private Double icuPatientsPerMillion;
    private Integer hospPatients;
    private Double hospPatientsPerMillion;
    private Integer weeklyIcuAdmissions;
    private Double weeklyIcuAdmissionsPerMillion;
    private Integer weeklyHospAdmissions;
    private Double weeklyHospAdmissionsPerMillion;
    private Long totalTests;
    private Integer newTests;
    private Double totalTestsPerThousand;
    private Double newTestsPerThousand;
    private Integer newTestsSmoothed;
    private Double newTestsSmoothedPerThousand;
    private Double positiveRate;
    private Double testsPerCase;
    private String testsUnits;
    private Long totalVaccinations;
    private Long peopleVaccinated;
    private Long peopleFullyVaccinated;
    private Long totalBoosters;
    private Integer newVaccinations;
    private Integer newVaccinationsSmoothed;
    private Double totalVaccinationsPerHundred;
    private Double peopleVaccinatedPerHundred;
    private Double peopleFullyVaccinatedPerHundred;
    private Double totalBoostersPerHundred;
    private Integer newVaccinationsSmoothedPerMillion;
    private Integer newPeopleVaccinatedSmoothed;
    private Double newPeopleVaccinatedSmoothedPerHundred;
    private Double stringencyIndex;
    private Double excessMortalityCumulativeAbsolute;
    private Double excessMortalityCumulative;
    private Double excessMortality;
    private Double excessMortalityCumulativePerMillion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;
}
