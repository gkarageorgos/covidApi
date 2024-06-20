package com.unipi.postgraduate_jkarageorgos.covidapi.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
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

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getNewCases() {
        return newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Double getNewCasesSmoothed() {
        return newCasesSmoothed;
    }

    public void setNewCasesSmoothed(Double newCasesSmoothed) {
        this.newCasesSmoothed = newCasesSmoothed;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Double getNewDeathsSmoothed() {
        return newDeathsSmoothed;
    }

    public void setNewDeathsSmoothed(Double newDeathsSmoothed) {
        this.newDeathsSmoothed = newDeathsSmoothed;
    }

    public Double getTotalCasesPerMillion() {
        return totalCasesPerMillion;
    }

    public void setTotalCasesPerMillion(Double totalCasesPerMillion) {
        this.totalCasesPerMillion = totalCasesPerMillion;
    }

    public Double getNewCasesPerMillion() {
        return newCasesPerMillion;
    }

    public void setNewCasesPerMillion(Double newCasesPerMillion) {
        this.newCasesPerMillion = newCasesPerMillion;
    }

    public Double getNewCasesSmoothedPerMillion() {
        return newCasesSmoothedPerMillion;
    }

    public void setNewCasesSmoothedPerMillion(Double newCasesSmoothedPerMillion) {
        this.newCasesSmoothedPerMillion = newCasesSmoothedPerMillion;
    }

    public Double getTotalDeathsPerMillion() {
        return totalDeathsPerMillion;
    }

    public void setTotalDeathsPerMillion(Double totalDeathsPerMillion) {
        this.totalDeathsPerMillion = totalDeathsPerMillion;
    }

    public Double getNewDeathsPerMillion() {
        return newDeathsPerMillion;
    }

    public void setNewDeathsPerMillion(Double newDeathsPerMillion) {
        this.newDeathsPerMillion = newDeathsPerMillion;
    }

    public Double getNewDeathsSmoothedPerMillion() {
        return newDeathsSmoothedPerMillion;
    }

    public void setNewDeathsSmoothedPerMillion(Double newDeathsSmoothedPerMillion) {
        this.newDeathsSmoothedPerMillion = newDeathsSmoothedPerMillion;
    }

    public Double getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(Double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public Integer getIcuPatients() {
        return icuPatients;
    }

    public void setIcuPatients(Integer icuPatients) {
        this.icuPatients = icuPatients;
    }

    public Double getIcuPatientsPerMillion() {
        return icuPatientsPerMillion;
    }

    public void setIcuPatientsPerMillion(Double icuPatientsPerMillion) {
        this.icuPatientsPerMillion = icuPatientsPerMillion;
    }

    public Integer getHospPatients() {
        return hospPatients;
    }

    public void setHospPatients(Integer hospPatients) {
        this.hospPatients = hospPatients;
    }

    public Double getHospPatientsPerMillion() {
        return hospPatientsPerMillion;
    }

    public void setHospPatientsPerMillion(Double hospPatientsPerMillion) {
        this.hospPatientsPerMillion = hospPatientsPerMillion;
    }

    public Integer getWeeklyIcuAdmissions() {
        return weeklyIcuAdmissions;
    }

    public void setWeeklyIcuAdmissions(Integer weeklyIcuAdmissions) {
        this.weeklyIcuAdmissions = weeklyIcuAdmissions;
    }

    public Double getWeeklyIcuAdmissionsPerMillion() {
        return weeklyIcuAdmissionsPerMillion;
    }

    public void setWeeklyIcuAdmissionsPerMillion(Double weeklyIcuAdmissionsPerMillion) {
        this.weeklyIcuAdmissionsPerMillion = weeklyIcuAdmissionsPerMillion;
    }

    public Integer getWeeklyHospAdmissions() {
        return weeklyHospAdmissions;
    }

    public void setWeeklyHospAdmissions(Integer weeklyHospAdmissions) {
        this.weeklyHospAdmissions = weeklyHospAdmissions;
    }

    public Double getWeeklyHospAdmissionsPerMillion() {
        return weeklyHospAdmissionsPerMillion;
    }

    public void setWeeklyHospAdmissionsPerMillion(Double weeklyHospAdmissionsPerMillion) {
        this.weeklyHospAdmissionsPerMillion = weeklyHospAdmissionsPerMillion;
    }

    public Long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(Long totalTests) {
        this.totalTests = totalTests;
    }

    public Integer getNewTests() {
        return newTests;
    }

    public void setNewTests(Integer newTests) {
        this.newTests = newTests;
    }

    public Double getTotalTestsPerThousand() {
        return totalTestsPerThousand;
    }

    public void setTotalTestsPerThousand(Double totalTestsPerThousand) {
        this.totalTestsPerThousand = totalTestsPerThousand;
    }

    public Double getNewTestsPerThousand() {
        return newTestsPerThousand;
    }

    public void setNewTestsPerThousand(Double newTestsPerThousand) {
        this.newTestsPerThousand = newTestsPerThousand;
    }

    public Integer getNewTestsSmoothed() {
        return newTestsSmoothed;
    }

    public void setNewTestsSmoothed(Integer newTestsSmoothed) {
        this.newTestsSmoothed = newTestsSmoothed;
    }

    public Double getNewTestsSmoothedPerThousand() {
        return newTestsSmoothedPerThousand;
    }

    public void setNewTestsSmoothedPerThousand(Double newTestsSmoothedPerThousand) {
        this.newTestsSmoothedPerThousand = newTestsSmoothedPerThousand;
    }

    public Double getPositiveRate() {
        return positiveRate;
    }

    public void setPositiveRate(Double positiveRate) {
        this.positiveRate = positiveRate;
    }

    public Double getTestsPerCase() {
        return testsPerCase;
    }

    public void setTestsPerCase(Double testsPerCase) {
        this.testsPerCase = testsPerCase;
    }

    public String getTestsUnits() {
        return testsUnits;
    }

    public void setTestsUnits(String testsUnits) {
        this.testsUnits = testsUnits;
    }

    public Long getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(Long totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }

    public Long getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public void setPeopleVaccinated(Long peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }

    public Long getPeopleFullyVaccinated() {
        return peopleFullyVaccinated;
    }

    public void setPeopleFullyVaccinated(Long peopleFullyVaccinated) {
        this.peopleFullyVaccinated = peopleFullyVaccinated;
    }

    public Long getTotalBoosters() {
        return totalBoosters;
    }

    public void setTotalBoosters(Long totalBoosters) {
        this.totalBoosters = totalBoosters;
    }

    public Integer getNewVaccinations() {
        return newVaccinations;
    }

    public void setNewVaccinations(Integer newVaccinations) {
        this.newVaccinations = newVaccinations;
    }

    public Integer getNewVaccinationsSmoothed() {
        return newVaccinationsSmoothed;
    }

    public void setNewVaccinationsSmoothed(Integer newVaccinationsSmoothed) {
        this.newVaccinationsSmoothed = newVaccinationsSmoothed;
    }

    public Double getTotalVaccinationsPerHundred() {
        return totalVaccinationsPerHundred;
    }

    public void setTotalVaccinationsPerHundred(Double totalVaccinationsPerHundred) {
        this.totalVaccinationsPerHundred = totalVaccinationsPerHundred;
    }

    public Double getPeopleVaccinatedPerHundred() {
        return peopleVaccinatedPerHundred;
    }

    public void setPeopleVaccinatedPerHundred(Double peopleVaccinatedPerHundred) {
        this.peopleVaccinatedPerHundred = peopleVaccinatedPerHundred;
    }

    public Double getPeopleFullyVaccinatedPerHundred() {
        return peopleFullyVaccinatedPerHundred;
    }

    public void setPeopleFullyVaccinatedPerHundred(Double peopleFullyVaccinatedPerHundred) {
        this.peopleFullyVaccinatedPerHundred = peopleFullyVaccinatedPerHundred;
    }

    public Double getTotalBoostersPerHundred() {
        return totalBoostersPerHundred;
    }

    public void setTotalBoostersPerHundred(Double totalBoostersPerHundred) {
        this.totalBoostersPerHundred = totalBoostersPerHundred;
    }

    public Integer getNewVaccinationsSmoothedPerMillion() {
        return newVaccinationsSmoothedPerMillion;
    }

    public void setNewVaccinationsSmoothedPerMillion(Integer newVaccinationsSmoothedPerMillion) {
        this.newVaccinationsSmoothedPerMillion = newVaccinationsSmoothedPerMillion;
    }

    public Integer getNewPeopleVaccinatedSmoothed() {
        return newPeopleVaccinatedSmoothed;
    }

    public void setNewPeopleVaccinatedSmoothed(Integer newPeopleVaccinatedSmoothed) {
        this.newPeopleVaccinatedSmoothed = newPeopleVaccinatedSmoothed;
    }

    public Double getNewPeopleVaccinatedSmoothedPerHundred() {
        return newPeopleVaccinatedSmoothedPerHundred;
    }

    public void setNewPeopleVaccinatedSmoothedPerHundred(Double newPeopleVaccinatedSmoothedPerHundred) {
        this.newPeopleVaccinatedSmoothedPerHundred = newPeopleVaccinatedSmoothedPerHundred;
    }

    public Double getStringencyIndex() {
        return stringencyIndex;
    }

    public void setStringencyIndex(Double stringencyIndex) {
        this.stringencyIndex = stringencyIndex;
    }

    public Double getExcessMortalityCumulativeAbsolute() {
        return excessMortalityCumulativeAbsolute;
    }

    public void setExcessMortalityCumulativeAbsolute(Double excessMortalityCumulativeAbsolute) {
        this.excessMortalityCumulativeAbsolute = excessMortalityCumulativeAbsolute;
    }

    public Double getExcessMortalityCumulative() {
        return excessMortalityCumulative;
    }

    public void setExcessMortalityCumulative(Double excessMortalityCumulative) {
        this.excessMortalityCumulative = excessMortalityCumulative;
    }

    public Double getExcessMortality() {
        return excessMortality;
    }

    public void setExcessMortality(Double excessMortality) {
        this.excessMortality = excessMortality;
    }

    public Double getExcessMortalityCumulativePerMillion() {
        return excessMortalityCumulativePerMillion;
    }

    public void setExcessMortalityCumulativePerMillion(Double excessMortalityCumulativePerMillion) {
        this.excessMortalityCumulativePerMillion = excessMortalityCumulativePerMillion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
