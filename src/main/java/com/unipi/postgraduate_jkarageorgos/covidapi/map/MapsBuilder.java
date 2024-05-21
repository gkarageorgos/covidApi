package com.unipi.postgraduate_jkarageorgos.covidapi.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsBuilder {
    private final BufferedReader bufferedReader;
    private final List<Map<String, String>> maps = new ArrayList<Map<String, String>>();

    public MapsBuilder(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void generateMaps() {
        try {
            String firstLine = bufferedReader.readLine();

            String[] fields = firstLine.split(",");

            String line;

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

                maps.add(map);
            }

            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Map<String, String>> getMaps() {
        return maps;
    }
}



