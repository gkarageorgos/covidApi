package com.unipi.postgraduate_jkarageorgos.covidapi.repository;

import com.unipi.postgraduate_jkarageorgos.covidapi.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Integer> {
    List<Data> findByAreaId(int id);
}
