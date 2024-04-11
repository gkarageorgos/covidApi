package com.unipi.postgraduate_jkarageorgos.covidapi.services.impl;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.AreaDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.AreaNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.models.Area;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.AreaRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Area area = areaRepository.save(dtoToEntity(areaDto));
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

        Area updateArea = areaRepository.save(area);

        return entityToDto(updateArea);
    }

    @Override
    public void deleteArea(int id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));
        areaRepository.delete(area);
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

    private Area dtoToEntity(AreaDto areaDto){
        String isoCode = areaDto.getIsoCode();
        String continent = areaDto.getContinent();
        String location = areaDto.getLocation();
        Double populationDensity = areaDto.getPopulationDensity();
        Double medianAge = areaDto.getMedianAge();
        Double aged65Older = areaDto.getAged65Older();
        Double aged70Older = areaDto.getAged70Older();
        Double gdpPerCapita = areaDto.getGdpPerCapita();
        Double extremePoverty = areaDto.getExtremePoverty();
        Double cardiovascDeathRate = areaDto.getCardiovascDeathRate();
        Double diabetesPrevalence = areaDto.getDiabetesPrevalence();
        Double femaleSmokers = areaDto.getFemaleSmokers();
        Double maleSmokers = areaDto.getMaleSmokers();
        Double handwashingFacilities = areaDto.getHandwashingFacilities();
        Double hospitalBedsPerThousand = areaDto.getHospitalBedsPerThousand();
        Double lifeExpectancy = areaDto.getLifeExpectancy();
        Double humanDevelopmentIndex= areaDto.getHumanDevelopmentIndex();
        long population = areaDto.getPopulation();

        return new Area(isoCode,
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
