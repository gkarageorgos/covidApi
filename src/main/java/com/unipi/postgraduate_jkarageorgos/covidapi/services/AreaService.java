package com.unipi.postgraduate_jkarageorgos.covidapi.services;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.AreaDto;

import java.util.List;
import java.util.Map;

public interface AreaService {
    void createAreaFromMap(Map<String, String> map);
    AreaDto createArea(AreaDto areaDto);
    List<AreaDto> getAllArea();
    AreaDto getAreaById(int id);
    AreaDto updateArea(AreaDto areaDto, int id);
    void deleteArea(int id);
}
