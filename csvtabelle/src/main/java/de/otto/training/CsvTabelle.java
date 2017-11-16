package de.otto.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CsvTabelle {

    List<String> getCSVLine(String csvLine) {

        String[] listedCSVLine = csvLine.split(";");
        return Arrays.asList(listedCSVLine);
    }

    List<List<String>> getValueMatrix(String csvFile) {
        List<List<String>> csvMatrix = new ArrayList<List<String>>();

        String[] csvFileAsArray = csvFile.split("\n");
        for (String csvLine : csvFileAsArray) {
            csvMatrix.add(getCSVLine(csvLine));
        }
        return csvMatrix;
    }

    int[] getColumnWidth(List<List<String>> expectCsvMatrix) {

        return new int[0];
    }
}
