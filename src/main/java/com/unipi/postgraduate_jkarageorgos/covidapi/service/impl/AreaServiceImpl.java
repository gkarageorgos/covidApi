package com.unipi.postgraduate_jkarageorgos.covidapi.service.impl;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.AreaDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.AreaNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.model.Area;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.AreaRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public AreaDto createArea(AreaDto areaDto) {
        Area area = areaRepository.save(dtoToEntity(areaDto, new Area()));
        return entityToDto(area);
    }

    @Override
    public List<AreaDto> getAllArea() {
        List<Area> areas = areaRepository.findAll();
        return areas.stream().map(area -> entityToDto(area)).collect(Collectors.toList());
    }

    @Override
    public AreaDto getAreaById(int id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));
        return entityToDto(area);
    }

    @Override
    public AreaDto updateArea(AreaDto areaDto, int id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));

        Area updatedArea = areaRepository.save(dtoToEntity(areaDto, area));

        return entityToDto(updatedArea);
    }

    @Override
    public void deleteArea(int id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));
        areaRepository.delete(area);
    }

    @Override
    public void updateAreaFromMap(Map<String, String> map) {
        String location = map.get("location");

        Optional<Area> optional = areaRepository.findAreaByLocation(location);

        if (optional.isPresent()){
            Area area = optional.get();

            areaRepository.save(mapToEntity(map, area));
        }else {
            createAreaFromMap(map);
        }
    }

    @Override
    public void createAreaFromMap(Map<String, String> map) {
        areaRepository.save(mapToEntity(map, new Area()));
    }

    private static Double getDoubleValueFromMap(Map<String, String> map, String key){
        String valueStr = map.get(key);
        Double value = null;
        if (valueStr != null)
            value = Double.valueOf(valueStr);
        return value;
    }

    private Area mapToEntity(Map<String, String> map, Area area){
        area.setIsoCode(map.get("iso_code"));
        area.setContinent(map.get("continent"));
        area.setLocation(map.get("location"));
        area.setPopulationDensity(getDoubleValueFromMap(map, "population_density"));
        area.setMedianAge(getDoubleValueFromMap(map, "median_age"));
        area.setAged65Older(getDoubleValueFromMap(map, "aged_65_older"));
        area.setAged70Older(getDoubleValueFromMap(map, "aged_70_older"));
        area.setGdpPerCapita(getDoubleValueFromMap(map, "gdp_per_capita"));
        area.setExtremePoverty(getDoubleValueFromMap(map, "extreme_poverty"));
        area.setCardiovascDeathRate(getDoubleValueFromMap(map, "cardiovasc_death_rate"));
        area.setDiabetesPrevalence(getDoubleValueFromMap(map, "diabetes_prevalence"));
        area.setFemaleSmokers(getDoubleValueFromMap(map, "female_smokers"));
        area.setMaleSmokers(getDoubleValueFromMap(map, "male_smokers"));
        area.setHandwashingFacilities(getDoubleValueFromMap(map, "handwashing_facilities"));
        area.setHospitalBedsPerThousand(getDoubleValueFromMap(map, "hospital_beds_per_thousand"));
        area.setLifeExpectancy(getDoubleValueFromMap(map, "life_expectancy"));
        area.setHumanDevelopmentIndex(getDoubleValueFromMap(map, "human_development_index"));
        area.setPopulation(Double.valueOf(map.get("population")).longValue());

        return area;
    }

    private Area dtoToEntity(AreaDto areaDto, Area area){
        area.setIsoCode(areaDto.getIsoCode());
        area.setContinent(areaDto.getContinent());
        area.setLocation(areaDto.getLocation());
        area.setPopulationDensity(areaDto.getPopulationDensity());
        area.setMedianAge(areaDto.getMedianAge());
        area.setAged65Older(areaDto.getAged65Older());
        area.setAged70Older(areaDto.getAged70Older());
        area.setGdpPerCapita(areaDto.getGdpPerCapita());
        area.setExtremePoverty(areaDto.getExtremePoverty());
        area.setCardiovascDeathRate(areaDto.getCardiovascDeathRate());
        area.setDiabetesPrevalence(areaDto.getDiabetesPrevalence());
        area.setFemaleSmokers(areaDto.getFemaleSmokers());
        area.setMaleSmokers(areaDto.getMaleSmokers());
        area.setHandwashingFacilities(areaDto.getHandwashingFacilities());
        area.setHospitalBedsPerThousand(areaDto.getHospitalBedsPerThousand());
        area.setLifeExpectancy(areaDto.getLifeExpectancy());
        area.setHumanDevelopmentIndex(areaDto.getHumanDevelopmentIndex());
        area.setPopulation(areaDto.getPopulation());

        return area;
    }

    private AreaDto entityToDto(Area area) {
        int id = area.getId();
        String isoCode = area.getIsoCode();
        String continent = area.getContinent();
        String location = area.getLocation();
        Double populationDensity = area.getPopulationDensity();
        Double medianAge = area.getMedianAge();
        Double aged65Older = area.getAged65Older();
        Double aged70Older = area.getAged70Older();
        Double gdpPerCapita = area.getGdpPerCapita();
        Double extremePoverty = area.getExtremePoverty();
        Double cardiovascDeathRate = area.getCardiovascDeathRate();
        Double diabetesPrevalence = area.getDiabetesPrevalence();
        Double femaleSmokers = area.getFemaleSmokers();
        Double maleSmokers = area.getMaleSmokers();
        Double handwashingFacilities = area.getHandwashingFacilities();
        Double hospitalBedsPerThousand = area.getHospitalBedsPerThousand();
        Double lifeExpectancy = area.getLifeExpectancy();
        Double humanDevelopmentIndex= area.getHumanDevelopmentIndex();
        long population = area.getPopulation();

        return new AreaDto(id,
                isoCode,
                continent,
                location,
                populationDensity,
                medianAge,
                aged65Older,
                aged70Older,
                gdpPerCapita,
                extremePoverty,
                cardiovascDeathRate,
                diabetesPrevalence,
                femaleSmokers,
                maleSmokers,
                handwashingFacilities,
                hospitalBedsPerThousand,
                lifeExpectancy,
                humanDevelopmentIndex,
                population
        );
    }
}
