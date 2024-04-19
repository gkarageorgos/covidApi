package com.unipi.postgraduate_jkarageorgos.covidapi.DatabaseSeeder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CSVFileReaderFromURL {
    private final String csvUrl;

    public CSVFileReaderFromURL(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    public BufferedReader getBufferedReader() {
        try {
            // Define the URL address of the CSV file
            URL url = new URL(csvUrl);

            // Create a BufferedReader to read the file
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            return bufferedReader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void readCSV() {
        try {
            BufferedReader reader = getBufferedReader();

            // Read the file line by line and print it
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
