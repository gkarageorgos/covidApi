package com.unipi.postgraduate_jkarageorgos.covidapi.services;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.DataDto;

import java.util.List;
import java.util.Map;

public interface DataService {
    DataDto createData(int areaId, DataDto dataDto);
    List<DataDto> getDataByAreaId(int areaId);
    DataDto getDataById(int areaId, int dataId);
    DataDto updateData(int areaId, int dataId, DataDto dataDto);
    void deleteData(int areaId, int dataId);
    void createDataFromMap(Map<String, String> map);
    void updateDataFromMap(Map<String, String> map);
}