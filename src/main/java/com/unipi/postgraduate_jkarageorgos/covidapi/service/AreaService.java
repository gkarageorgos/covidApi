package com.unipi.postgraduate_jkarageorgos.covidapi.service;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.AreaDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.model.DeleteResponse;

import java.util.List;
import java.util.Map;

public interface AreaService {
    AreaDto createArea(AreaDto areaDto);
    List<AreaDto> getAllArea();
    AreaDto getAreaById(int id);
    AreaDto updateArea(AreaDto areaDto, int id);
    DeleteResponse deleteArea(int id);
    void createAreaFromMap(Map<String, String> map);
    void updateAreaFromMap(Map<String, String> map);
}
