package com.unipi.postgraduate_jkarageorgos.covidapi.reader;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadCSV {
    private final BufferedReader bufferedReader;

    public ReadCSV(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void readCSV() {
        try {
            // Read the file line by line and print it
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
