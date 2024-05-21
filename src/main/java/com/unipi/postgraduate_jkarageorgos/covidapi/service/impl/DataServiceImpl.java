package com.unipi.postgraduate_jkarageorgos.covidapi.service.impl;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.DataDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.AreaNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.DataNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.model.Area;
import com.unipi.postgraduate_jkarageorgos.covidapi.model.Data;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.AreaRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.DataRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;
    private final AreaRepository areaRepository;

    @Autowired
    public DataServiceImpl(DataRepository dataRepository, AreaRepository areaRepository) {
        this.dataRepository = dataRepository;
        this.areaRepository = areaRepository;
    }

    @Override
    public DataDto createData(int areaId, DataDto dataDto) {
        Area area = areaRepository.findById(areaId).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));

        Data data = dtoToEntity(dataDto, new Data());

        data.setArea(area);

        return entityToDto(dataRepository.save(data));
    }

    @Override
    public List<DataDto> getDataByAreaId(int areaId) {
        List<Data> dataList = dataRepository.findByAreaId(areaId);

        return dataList.stream().map(data -> entityToDto(data)).collect(Collectors.toList());
    }

    @Override
    public DataDto getDataById(int areaId, int dataId) {
        Area area = areaRepository.findById(areaId).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));

        Data data = dataRepository.findById(dataId).orElseThrow(() -> new DataNotFoundException("Data with associate area not found"));

        if (data.getArea().getId() != area.getId()) {
            throw new DataNotFoundException("This data does not belong to a area");
        }

        return entityToDto(data);
    }

    @Override
    public DataDto updateData(int areaId, int dataId, DataDto dataDto) {
        Area area = areaRepository.findById(areaId).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));

        Data data = dataRepository.findById(dataId).orElseThrow(() -> new DataNotFoundException("Data with associate area not found"));

        if (data.getArea().getId() != area.getId()) {
            throw new DataNotFoundException("This data does not belong to a area");
        }

        Data updatedData = dataRepository.save(dtoToEntity(dataDto, data));

        return entityToDto(updatedData);
    }

    @Override
    public void deleteData(int areaId, int dataId) {
        Area area = areaRepository.findById(areaId).orElseThrow(() -> new AreaNotFoundException("Area could not be found by id"));

        Data data = dataRepository.findById(dataId).orElseThrow(() -> new DataNotFoundException("Data with associate area not found"));

        if (data.getArea().getId() != area.getId()) {
            throw new DataNotFoundException("This data does not belong to a area");
        }

        dataRepository.delete(data);
    }

    @Override
    public void updateDataFromMap(Map<String, String> map) {
        String location = map.get("location");

        Date lastUpdatedDate = Date.valueOf(map.get("last_updated_date"));

        Optional<Data> optional = dataRepository.findByAreaLocationAndDate(location, lastUpdatedDate);

        if (optional.isPresent()) {
            Data data = optional.get();

            dataRepository.save(mapToEntity(map, data));
        } else {
            createDataFromMap(map);
        }
    }

    @Override
    public void createDataFromMap(Map<String, String> map) {
        String location = map.get("location");

        Area area = areaRepository.findAreaByLocation(location).orElseThrow(() -> new AreaNotFoundException("Area could not be found by location"));

        Data data = mapToEntity(map, new Data());

        data.setArea(area);

        dataRepository.save(data);
    }

    private static <T> T getValueFromMap(Map<String, String> map, String key, Class<T> type){
        String valueStr = map.get(key);
        if (valueStr != null){
            try {
                if (type.equals(Double.class)) {
                    Double doubleValue = Double.valueOf(valueStr);
                    return type.cast(doubleValue);
                } else if (type.equals(Integer.class)) {
                    Integer integerValue = Double.valueOf(valueStr).intValue();
                    return type.cast(integerValue);
                } else if (type.equals(Long.class)) {
                    Long longValue = Double.valueOf(valueStr).longValue();
                    return type.cast(longValue);
                } else if (type.equals(Date.class)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedDate = dateFormat.parse(valueStr);
                    return type.cast(new Date(parsedDate.getTime()));
                }
            }catch (NumberFormatException | ParseException e){
                System.err.println("Error converting value '" + valueStr + "' to data type " + type.getSimpleName() + " for key '" + key + "': " + e.getMessage());
            }
        }
        return null;
    }

    private Data mapToEntity(Map<String, String> map, Data data) {
        data.setDate(getValueFromMap(map, "last_updated_date", Date.class));
        data.setTotalCases(getValueFromMap(map, "total_cases", Integer.class));
        data.setNewCases(getValueFromMap(map, "new_cases", Integer.class));
        data.setNewCasesSmoothed(getValueFromMap(map, "new_cases_smoothed", Double.class));
        data.setTotalDeaths(getValueFromMap(map, "total_deaths", Integer.class));
        data.setNewDeaths(getValueFromMap(map, "new_deaths", Integer.class));
        data.setNewDeathsSmoothed(getValueFromMap(map, "new_deaths_smoothed", Double.class));
        data.setTotalCasesPerMillion(getValueFromMap(map, "total_cases_per_million", Double.class));
        data.setNewCasesPerMillion(getValueFromMap(map, "new_cases_per_million", Double.class));
        data.setNewCasesSmoothedPerMillion(getValueFromMap(map, "new_cases_smoothed_per_million", Double.class));
        data.setTotalDeathsPerMillion(getValueFromMap(map, "total_deaths_per_million", Double.class));
        data.setNewDeathsPerMillion(getValueFromMap(map, "new_deaths_per_million", Double.class));
        data.setNewDeathsSmoothedPerMillion(getValueFromMap(map, "new_deaths_smoothed_per_million", Double.class));
        data.setReproductionRate(getValueFromMap(map, "reproduction_rate", Double.class));
        data.setIcuPatients(getValueFromMap(map, "icu_patients", Integer.class));
        data.setIcuPatientsPerMillion(getValueFromMap(map, "icu_patients_per_million", Double.class));
        data.setHospPatients(getValueFromMap(map, "hosp_patients", Integer.class));
        data.setHospPatientsPerMillion(getValueFromMap(map, "hosp_patients_per_million", Double.class));
        data.setWeeklyIcuAdmissions(getValueFromMap(map, "weekly_icu_admissions", Integer.class));
        data.setWeeklyIcuAdmissionsPerMillion(getValueFromMap(map, "weekly_icu_admissions_per_million", Double.class));
        data.setWeeklyHospAdmissions(getValueFromMap(map, "weekly_hosp_admissions", Integer.class));
        data.setWeeklyHospAdmissionsPerMillion(getValueFromMap(map, "weekly_hosp_admissions_per_million", Double.class));
        data.setTotalTests(getValueFromMap(map, "total_tests", Long.class));
        data.setNewTests(getValueFromMap(map, "new_tests", Integer.class));
        data.setTotalTestsPerThousand(getValueFromMap(map, "total_tests_per_thousand", Double.class));
        data.setNewTestsPerThousand(getValueFromMap(map, "new_tests_per_thousand", Double.class));
        data.setNewTestsSmoothed(getValueFromMap(map, "new_tests_smoothed", Integer.class));
        data.setNewTestsSmoothedPerThousand(getValueFromMap(map, "new_tests_smoothed_per_thousand", Double.class));
        data.setPositiveRate(getValueFromMap(map, "positive_rate", Double.class));
        data.setTestsPerCase(getValueFromMap(map, "tests_per_case", Double.class));
        data.setTestsUnits(map.get("tests_units"));
        data.setTotalVaccinations(getValueFromMap(map, "total_vaccinations", Long.class));
        data.setPeopleVaccinated(getValueFromMap(map, "people_vaccinated", Long.class));
        data.setPeopleFullyVaccinated(getValueFromMap(map, "people_fully_vaccinated", Long.class));
        data.setTotalBoosters(getValueFromMap(map, "total_boosters", Long.class));
        data.setNewVaccinations(getValueFromMap(map, "new_vaccinations", Integer.class));
        data.setNewVaccinationsSmoothed(getValueFromMap(map, "new_vaccinations_smoothed", Integer.class));
        data.setTotalVaccinationsPerHundred(getValueFromMap(map, "total_vaccinations_per_hundred", Double.class));
        data.setPeopleVaccinatedPerHundred(getValueFromMap(map, "people_vaccinated_per_hundred", Double.class));
        data.setPeopleFullyVaccinatedPerHundred(getValueFromMap(map, "people_fully_vaccinated_per_hundred", Double.class));
        data.setTotalBoostersPerHundred(getValueFromMap(map, "total_boosters_per_hundred", Double.class));
        data.setNewVaccinationsSmoothedPerMillion(getValueFromMap(map, "new_vaccinations_smoothed_per_million", Integer.class));
        data.setNewPeopleVaccinatedSmoothed(getValueFromMap(map, "new_people_vaccinated_smoothed", Integer.class));
        data.setNewPeopleVaccinatedSmoothedPerHundred(getValueFromMap(map, "new_people_vaccinated_smoothed_per_hundred", Double.class));
        data.setStringencyIndex(getValueFromMap(map, "stringency_index", Double.class));
        data.setExcessMortalityCumulativeAbsolute(getValueFromMap(map, "excess_mortality_cumulative_absolute", Double.class));
        data.setExcessMortalityCumulative(getValueFromMap(map, "excess_mortality_cumulative", Double.class));
        data.setExcessMortality(getValueFromMap(map, "excess_mortality", Double.class));
        data.setExcessMortalityCumulativePerMillion(getValueFromMap(map, "excess_mortality_cumulative_per_million", Double.class));

        return data;
    }

    private Data dtoToEntity(DataDto dataDto, Data data){
        data.setDate(dataDto.getDate());
        data.setTotalCases(dataDto.getTotalCases());
        data.setNewCases(dataDto.getNewCases());
        data.setNewCasesSmoothed(dataDto.getNewCasesSmoothed());
        data.setTotalDeaths(dataDto.getTotalDeaths());
        data.setNewDeaths(dataDto.getNewDeaths());
        data.setNewDeathsSmoothed(dataDto.getNewDeathsSmoothed());
        data.setTotalCasesPerMillion(dataDto.getTotalCasesPerMillion());
        data.setNewCasesPerMillion(dataDto.getNewCasesPerMillion());
        data.setNewCasesSmoothedPerMillion(dataDto.getNewCasesSmoothedPerMillion());
        data.setTotalDeathsPerMillion(dataDto.getTotalDeathsPerMillion());
        data.setNewDeathsPerMillion(dataDto.getNewDeathsPerMillion());
        data.setNewDeathsSmoothedPerMillion(dataDto.getNewDeathsSmoothedPerMillion());
        data.setReproductionRate(dataDto.getReproductionRate());
        data.setIcuPatients(dataDto.getIcuPatients());
        data.setIcuPatientsPerMillion(dataDto.getIcuPatientsPerMillion());
        data.setHospPatients(dataDto.getHospPatients());
        data.setHospPatientsPerMillion(dataDto.getHospPatientsPerMillion());
        data.setWeeklyIcuAdmissions(dataDto.getWeeklyIcuAdmissions());
        data.setWeeklyIcuAdmissionsPerMillion(dataDto.getWeeklyIcuAdmissionsPerMillion());
        data.setWeeklyHospAdmissions(dataDto.getWeeklyHospAdmissions());
        data.setWeeklyHospAdmissionsPerMillion(dataDto.getWeeklyHospAdmissionsPerMillion());
        data.setTotalTests(dataDto.getTotalTests());
        data.setNewTests(dataDto.getNewTests());
        data.setTotalTestsPerThousand(dataDto.getTotalTestsPerThousand());
        data.setNewTestsPerThousand(dataDto.getNewTestsPerThousand());
        data.setNewTestsSmoothed(dataDto.getNewTestsSmoothed());
        data.setNewTestsSmoothedPerThousand(dataDto.getNewTestsSmoothedPerThousand());
        data.setPositiveRate(dataDto.getPositiveRate());
        data.setTestsPerCase(dataDto.getTestsPerCase());
        data.setTestsUnits(dataDto.getTestsUnits());
        data.setTotalVaccinations(dataDto.getTotalVaccinations());
        data.setPeopleVaccinated(dataDto.getPeopleVaccinated());
        data.setPeopleFullyVaccinated(dataDto.getPeopleFullyVaccinated());
        data.setTotalBoosters(dataDto.getTotalBoosters());
        data.setNewVaccinations(dataDto.getNewVaccinations());
        data.setNewVaccinationsSmoothed(dataDto.getNewVaccinationsSmoothed());
        data.setTotalVaccinationsPerHundred(dataDto.getTotalVaccinationsPerHundred());
        data.setPeopleVaccinatedPerHundred(dataDto.getPeopleVaccinatedPerHundred());
        data.setPeopleFullyVaccinatedPerHundred(dataDto.getPeopleFullyVaccinatedPerHundred());
        data.setTotalBoostersPerHundred(dataDto.getTotalBoostersPerHundred());
        data.setNewVaccinationsSmoothedPerMillion(dataDto.getNewVaccinationsSmoothedPerMillion());
        data.setNewPeopleVaccinatedSmoothed(dataDto.getNewPeopleVaccinatedSmoothed());
        data.setNewPeopleVaccinatedSmoothedPerHundred(dataDto.getNewPeopleVaccinatedSmoothedPerHundred());
        data.setStringencyIndex(dataDto.getStringencyIndex());
        data.setExcessMortalityCumulativeAbsolute(dataDto.getExcessMortalityCumulativeAbsolute());
        data.setExcessMortalityCumulative(dataDto.getExcessMortalityCumulative());
        data.setExcessMortality(dataDto.getExcessMortality());
        data.setExcessMortalityCumulativePerMillion(dataDto.getExcessMortalityCumulativePerMillion());

        return data;
    }

    private DataDto entityToDto(Data data){
        DataDto dataDto = new DataDto();

        dataDto.setId(data.getId());
        dataDto.setDate(data.getDate());
        dataDto.setTotalCases(data.getTotalCases());
        dataDto.setNewCases(data.getNewCases());
        dataDto.setNewCasesSmoothed(data.getNewCasesSmoothed());
        dataDto.setTotalDeaths(data.getTotalDeaths());
        dataDto.setNewDeaths(data.getNewDeaths());
        dataDto.setNewDeathsSmoothed(data.getNewDeathsSmoothed());
        dataDto.setTotalCasesPerMillion(data.getTotalCasesPerMillion());
        dataDto.setNewCasesPerMillion(data.getNewCasesPerMillion());
        dataDto.setNewCasesSmoothedPerMillion(data.getNewCasesSmoothedPerMillion());
        dataDto.setTotalDeathsPerMillion(data.getTotalDeathsPerMillion());
        dataDto.setNewDeathsPerMillion(data.getNewDeathsPerMillion());
        dataDto.setNewDeathsSmoothedPerMillion(data.getNewDeathsSmoothedPerMillion());
        dataDto.setReproductionRate(data.getReproductionRate());
        dataDto.setIcuPatients(data.getIcuPatients());
        dataDto.setIcuPatientsPerMillion(data.getIcuPatientsPerMillion());
        dataDto.setHospPatients(data.getHospPatients());
        dataDto.setHospPatientsPerMillion(data.getHospPatientsPerMillion());
        dataDto.setWeeklyIcuAdmissions(data.getWeeklyIcuAdmissions());
        dataDto.setWeeklyIcuAdmissionsPerMillion(data.getWeeklyIcuAdmissionsPerMillion());
        dataDto.setWeeklyHospAdmissions(data.getWeeklyHospAdmissions());
        dataDto.setWeeklyHospAdmissionsPerMillion(data.getWeeklyHospAdmissionsPerMillion());
        dataDto.setTotalTests(data.getTotalTests());
        dataDto.setNewTests(data.getNewTests());
        dataDto.setTotalTestsPerThousand(data.getTotalTestsPerThousand());
        dataDto.setNewTestsPerThousand(data.getNewTestsPerThousand());
        dataDto.setNewTestsSmoothed(data.getNewTestsSmoothed());
        dataDto.setNewTestsSmoothedPerThousand(data.getNewTestsSmoothedPerThousand());
        dataDto.setPositiveRate(data.getPositiveRate());
        dataDto.setTestsPerCase(data.getTestsPerCase());
        dataDto.setTestsUnits(data.getTestsUnits());
        dataDto.setTotalVaccinations(data.getTotalVaccinations());
        dataDto.setPeopleVaccinated(data.getPeopleVaccinated());
        dataDto.setPeopleFullyVaccinated(data.getPeopleFullyVaccinated());
        dataDto.setTotalBoosters(data.getTotalBoosters());
        dataDto.setNewVaccinations(data.getNewVaccinations());
        dataDto.setNewVaccinationsSmoothed(data.getNewVaccinationsSmoothed());
        dataDto.setTotalVaccinationsPerHundred(data.getTotalVaccinationsPerHundred());
        dataDto.setPeopleVaccinatedPerHundred(data.getPeopleVaccinatedPerHundred());
        dataDto.setPeopleFullyVaccinatedPerHundred(data.getPeopleFullyVaccinatedPerHundred());
        dataDto.setTotalBoostersPerHundred(data.getTotalBoostersPerHundred());
        dataDto.setNewVaccinationsSmoothedPerMillion(data.getNewVaccinationsSmoothedPerMillion());
        dataDto.setNewPeopleVaccinatedSmoothed(data.getNewPeopleVaccinatedSmoothed());
        dataDto.setNewPeopleVaccinatedSmoothedPerHundred(data.getNewPeopleVaccinatedSmoothedPerHundred());
        dataDto.setStringencyIndex(data.getStringencyIndex());
        dataDto.setExcessMortalityCumulativeAbsolute(data.getExcessMortalityCumulativeAbsolute());
        dataDto.setExcessMortalityCumulative(data.getExcessMortalityCumulative());
        dataDto.setExcessMortality(data.getExcessMortality());
        dataDto.setExcessMortalityCumulativePerMillion(data.getExcessMortalityCumulativePerMillion());

        return dataDto;
    }
}
