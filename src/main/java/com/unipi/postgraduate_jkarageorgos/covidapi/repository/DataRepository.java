package com.unipi.postgraduate_jkarageorgos.covidapi.repository;

import com.unipi.postgraduate_jkarageorgos.covidapi.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface DataRepository extends JpaRepository<Data, Integer> {
    Optional<Data> findByAreaLocationAndDate(String location, Date date);
}
