package com.unipi.postgraduate_jkarageorgos.covidapi.controller;

import com.unipi.postgraduate_jkarageorgos.covidapi.dto.AreaDto;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("area/create")
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto areaDto) {
        return new ResponseEntity<>(areaService.createArea(areaDto), HttpStatus.CREATED);
    }

    @GetMapping("area")
    public ResponseEntity<List<AreaDto>> getAreas() {
        return new ResponseEntity<>(areaService.getAllArea(), HttpStatus.OK);
    }

    @GetMapping("area/{id}")
    public ResponseEntity<AreaDto> areaDetail(@PathVariable("id") int id) {
        return new ResponseEntity<>(areaService.getAreaById(id), HttpStatus.OK);
    }

    @PutMapping("area/{id}/update")
    public ResponseEntity<AreaDto> updateArea(@RequestBody AreaDto areaDto, @PathVariable("id") int id) {
        AreaDto response = areaService.updateArea(areaDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("area/{id}/delete")
    public ResponseEntity<String> deleteArea(@PathVariable("id") int id) {
        areaService.deleteArea(id);
        return new ResponseEntity<>("Area deleted successfully", HttpStatus.OK);
    }
}
