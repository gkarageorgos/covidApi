package com.unipi.postgraduate_jkarageorgos.covidapi.DatabaseSeeder;

import com.unipi.postgraduate_jkarageorgos.covidapi.services.AreaService;
import com.unipi.postgraduate_jkarageorgos.covidapi.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final AreaService areaService;
    private final DataService dataService;

    @Autowired
    public DatabaseSeeder(AreaService areaService, DataService dataService) {
        this.areaService = areaService;
        this.dataService = dataService;
    }

    @Override
    public void run(String... args) throws Exception {
        String csvUrl = "https://github.com/owid/covid-19-data/raw/master/public/data/owid-covid-data.csv";

        BufferedReader bufferedReader = new CSVFileReaderFromURL(csvUrl).getBufferedReader();

        String firstLine = bufferedReader.readLine();

        String[] fields = firstLine.split(",");

        String line;

        //String iso_code = "";

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

            /*// Check if the country code has not been added yet
            if (!iso_code.equals(map.get("iso_code"))) {

                // Updating the country code for the check in the next iteration
                iso_code = map.get("iso_code");

                areaService.createAreaFromMap(map);
            }*/

            dataService.createDataFromMap(map);

        }

        bufferedReader.close();
    }

}
