package com.unipi.postgraduate_jkarageorgos.covidapi.services;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.DataDto;

import java.util.List;

public interface DataService {
    DataDto createData(int areaId, DataDto dataDto);
    List<DataDto> getDataByAreaId(int areaId);
    DataDto getDataById(int areaId, int dataId);
    DataDto updateData(int areaId, int dataId, DataDto dataDto);
    void deleteData(int areaId, int dataId);
}
