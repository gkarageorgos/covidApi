package com.unipi.postgraduate_jkarageorgos.covidapi.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CSVReader {
    private final String csvUrl;
    private BufferedReader bufferedReader;

    public CSVReader(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    public void BufferedReaderFromUrl() {
        try {
            // Define the URL address of the CSV file
            URL url = new URL(csvUrl);

            // Create a BufferedReader to read the file
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
