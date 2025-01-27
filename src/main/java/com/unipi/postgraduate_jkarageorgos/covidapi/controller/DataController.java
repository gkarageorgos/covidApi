package com.unipi.postgraduate_jkarageorgos.covidapi.controller;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.DataDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.model.DeleteResponse;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/area/{areaId}/data")
    public ResponseEntity<DataDto> createData(@PathVariable(value = "areaId") int areaId, @RequestBody DataDto dataDto) {
        return new ResponseEntity<>(dataService.createData(areaId, dataDto), HttpStatus.CREATED);
    }

    @GetMapping("area/{areaId}/data")
    public ResponseEntity<List<DataDto>> getDataByAreaId(@PathVariable(value = "areaId") int areaId) {
        return new ResponseEntity<>(dataService.getDataByAreaId(areaId), HttpStatus.OK);
    }

    @GetMapping("area/{areaId}/data/{dataId}")
    public ResponseEntity<DataDto> getDataById(@PathVariable(value = "areaId") int areaId, @PathVariable(value = "dataId") int dataId) {
        return new ResponseEntity<>(dataService.getDataById(areaId, dataId), HttpStatus.OK);
    }

    @PutMapping("area/{areaId}/data/{dataId}")
    public ResponseEntity<DataDto> updateData(@PathVariable(value = "areaId") int areaId,
                                              @PathVariable(value = "dataId") int dataId,
                                              @RequestBody DataDto dataDto) {
        return new ResponseEntity<>(dataService.updateData(areaId, dataId, dataDto), HttpStatus.OK);
    }

    @DeleteMapping("area/{areaId}/data/{dataId}")
    public ResponseEntity<DeleteResponse> deleteData(@PathVariable(value = "areaId") int areaId, @PathVariable(value = "dataId") int dataId) {
        return new ResponseEntity<>(dataService.deleteData(areaId, dataId), HttpStatus.OK);
    }
}
