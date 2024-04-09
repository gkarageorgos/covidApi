package com.unipi.postgraduate_jkarageorgos.covidapi.dto;

public class AreaDto {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(Double populationDensity) {
        this.populationDensity = populationDensity;
    }

    public Double getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(Double medianAge) {
        this.medianAge = medianAge;
    }

    public Double getAged65Older() {
        return aged65Older;
    }

    public void setAged65Older(Double aged65Older) {
        this.aged65Older = aged65Older;
    }

    public Double getAged70Older() {
        return aged70Older;
    }

    public void setAged70Older(Double aged70Older) {
        this.aged70Older = aged70Older;
    }

    public Double getGdpPerCapita() {
        return gdpPerCapita;
    }

    public void setGdpPerCapita(Double gdpPerCapita) {
        this.gdpPerCapita = gdpPerCapita;
    }

    public Double getExtremePoverty() {
        return extremePoverty;
    }

    public void setExtremePoverty(Double extremePoverty) {
        this.extremePoverty = extremePoverty;
    }

    public Double getCardiovascDeathRate() {
        return cardiovascDeathRate;
    }

    public void setCardiovascDeathRate(Double cardiovascDeathRate) {
        this.cardiovascDeathRate = cardiovascDeathRate;
    }

    public Double getDiabetesPrevalence() {
        return diabetesPrevalence;
    }

    public void setDiabetesPrevalence(Double diabetesPrevalence) {
        this.diabetesPrevalence = diabetesPrevalence;
    }

    public Double getFemaleSmokers() {
        return femaleSmokers;
    }

    public void setFemaleSmokers(Double femaleSmokers) {
        this.femaleSmokers = femaleSmokers;
    }

    public Double getMaleSmokers() {
        return maleSmokers;
    }

    public void setMaleSmokers(Double maleSmokers) {
        this.maleSmokers = maleSmokers;
    }

    public Double getHandwashingFacilities() {
        return handwashingFacilities;
    }

    public void setHandwashingFacilities(Double handwashingFacilities) {
        this.handwashingFacilities = handwashingFacilities;
    }

    public Double getHospitalBedsPerThousand() {
        return hospitalBedsPerThousand;
    }

    public void setHospitalBedsPerThousand(Double hospitalBedsPerThousand) {
        this.hospitalBedsPerThousand = hospitalBedsPerThousand;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getHumanDevelopmentIndex() {
        return humanDevelopmentIndex;
    }

    public void setHumanDevelopmentIndex(Double humanDevelopmentIndex) {
        this.humanDevelopmentIndex = humanDevelopmentIndex;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public AreaDto(int id, String isoCode, String continent, String location, Double populationDensity, Double medianAge, Double aged65Older, Double aged70Older, Double gdpPerCapita, Double extremePoverty, Double cardiovascDeathRate, Double diabetesPrevalence, Double femaleSmokers, Double maleSmokers, Double handwashingFacilities, Double hospitalBedsPerThousand, Double lifeExpectancy, Double humanDevelopmentIndex, long population) {
        this.id = id;
        this.isoCode = isoCode;
        this.continent = continent;
        this.location = location;
        this.populationDensity = populationDensity;
        this.medianAge = medianAge;
        this.aged65Older = aged65Older;
        this.aged70Older = aged70Older;
        this.gdpPerCapita = gdpPerCapita;
        this.extremePoverty = extremePoverty;
        this.cardiovascDeathRate = cardiovascDeathRate;
        this.diabetesPrevalence = diabetesPrevalence;
        this.femaleSmokers = femaleSmokers;
        this.maleSmokers = maleSmokers;
        this.handwashingFacilities = handwashingFacilities;
        this.hospitalBedsPerThousand = hospitalBedsPerThousand;
        this.lifeExpectancy = lifeExpectancy;
        this.humanDevelopmentIndex = humanDevelopmentIndex;
        this.population = population;
    }
}
