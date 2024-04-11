package com.unipi.postgraduate_jkarageorgos.covidapi.services.impl;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.AreaDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.dto.DataDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.AreaNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.DataNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.models.Area;
import com.unipi.postgraduate_jkarageorgos.covidapi.models.Data;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.AreaRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.DataRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
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

        Data data = dtoToEntity(dataDto);

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

        Data updateData = dataRepository.save(data);

        return entityToDto(updateData);
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

    private DataDto entityToDto(Data data){
        DataDto dataDto = new DataDto();

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

    private Data dtoToEntity(DataDto dataDto){
        Data data = new Data();

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
}
