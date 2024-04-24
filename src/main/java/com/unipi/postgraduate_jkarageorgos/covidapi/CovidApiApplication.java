package com.unipi.postgraduate_jkarageorgos.covidapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidApiApplication.class, args);
    }

}
