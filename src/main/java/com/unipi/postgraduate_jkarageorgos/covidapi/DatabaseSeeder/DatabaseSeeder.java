package com.unipi.postgraduate_jkarageorgos.covidapi.DatabaseSeeder;

import com.unipi.postgraduate_jkarageorgos.covidapi.models.Area;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.AreaRepository;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final DataRepository dataRepository;

    @Autowired
    public DatabaseSeeder(AreaRepository areaRepository, DataRepository dataRepository) {
        this.areaRepository = areaRepository;
        this.dataRepository = dataRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String csvUrl = "https://github.com/owid/covid-19-data/raw/master/public/data/owid-covid-data.csv";

        BufferedReader bufferedReader = new CSVFileReaderFromURL(csvUrl).getBufferedReader();

        String firstLine = bufferedReader.readLine();

        String[] fields = firstLine.split(",");

        String line;

        String iso_code = "";

        while ((line = bufferedReader.readLine()) != null) {

            String[] values = line.split(",");

            Map<String, String> map = new HashMap<>();

            for (int i = 0; i < fields.length; i++) {
                String key = fields[i];
                String value = null;
                if (i < values.length && !values[i].isEmpty()) {
                    value = values[i];
                }
                map.put(key, value);
            }

            // Checking if the country code has already been added
            if (iso_code.equals(map.get("iso_code")))
                continue;

            // Updating the country code for the check in the next iteration
            iso_code = values[0];

            Area area = createArea(map);

            areaRepository.save(area);
        }
    }

    private static Double getDoubleValueFromMap(Map<String, String> map, String key){
        String valueStr = map.get(key);
        Double value = null;
        if (valueStr != null)
            value = Double.valueOf(valueStr);
        return value;
    }

    private Area createArea(Map<String, String> map){

        String isoCode = map.get("iso_code");

        String continent = map.get("continent");

        String location = map.get("location");

        Double populationDensity = getDoubleValueFromMap(map, "population_density");

        Double medianAge = getDoubleValueFromMap(map, "median_age");

        Double aged65Older = getDoubleValueFromMap(map, "aged_65_older");

        Double aged70Older = getDoubleValueFromMap(map, "aged_70_older");

        Double gdpPerCapita = getDoubleValueFromMap(map, "gdp_per_capita");

        Double extremePoverty = getDoubleValueFromMap(map, "extreme_poverty");

        Double cardiovascDeathRate = getDoubleValueFromMap(map, "cardiovasc_death_rate");

        Double diabetesPrevalence = getDoubleValueFromMap(map, "diabetes_prevalence");

        Double femaleSmokers = getDoubleValueFromMap(map, "female_smokers");

        Double maleSmokers = getDoubleValueFromMap(map, "male_smokers");

        Double handwashingFacilities = getDoubleValueFromMap(map, "handwashing_facilities");

        Double hospitalBedsPerThousand = getDoubleValueFromMap(map, "hospital_beds_per_thousand");

        Double lifeExpectancy = getDoubleValueFromMap(map, "life_expectancy");

        Double humanDevelopmentIndex= getDoubleValueFromMap(map, "human_development_index");

        long population = Double.valueOf(map.get("population")).longValue();

        return new Area(isoCode,
                continent,
                location,
                populationDensity,
                medianAge,
                aged65Older,
                aged70Older,
                gdpPerCapita,
                extremePoverty,
                cardiovascDeathRate,
                diabetesPrevalence,
                femaleSmokers,
                maleSmokers,
                handwashingFacilities,
                hospitalBedsPerThousand,
                lifeExpectancy,
                humanDevelopmentIndex,
                population
        );
    }
}
