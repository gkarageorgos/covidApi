package com.unipi.postgraduate_jkarageorgos.covidapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Data> dataList = new ArrayList<Data>();

    public int getId() {
        return id;
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

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
