package com.unipi.postgraduate_jkarageorgos.covidapi.scheduled;

import com.unipi.postgraduate_jkarageorgos.covidapi.map.MapsBuilder;
import com.unipi.postgraduate_jkarageorgos.covidapi.reader.CSVReader;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.AreaService;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledTasks {
    private final AreaService areaService;
    private final DataService dataService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    public ScheduledTasks(AreaService areaService, DataService dataService) {
        this.areaService = areaService;
        this.dataService = dataService;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void job() {

        log.info("Updating data at: "+new Date());

        String csvUrl = "https://github.com/owid/covid-19-data/raw/master/public/data/latest/owid-covid-latest.csv";

        CSVReader csvReader = new CSVReader(csvUrl);

        csvReader.BufferedReaderFromUrl();

        BufferedReader bufferedReader = csvReader.getBufferedReader();

        MapsBuilder mapsBuilder = new MapsBuilder(bufferedReader);

        mapsBuilder.generateMaps();

        List<Map<String, String>> maps = mapsBuilder.getMaps();

        for (Map<String, String> map : maps) {
            areaService.updateAreaFromMap(map);
            dataService.updateDataFromMap(map);
        }

        log.info("Data update completed at: "+new Date());
    }
}
