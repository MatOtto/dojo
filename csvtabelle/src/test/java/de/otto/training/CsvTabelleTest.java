package de.otto.training;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CsvTabelleTest {

    CsvTabelle csvTabelle = new CsvTabelle();
    List<String> expectCsvLine = new ArrayList<String>();
    List<List<String>> expectCsvMatrix = new ArrayList<List<String>>();

    @Test
    public void testGetCsvLine() {
        expectCsvLine.add("Name");
        expectCsvLine.add("Strasse");
        expectCsvLine.add("Ort");
        expectCsvLine.add("Alter");

        String csvLine = "Name;Strasse;Ort;Alter";
        List<String> actual = csvTabelle.getCSVLine(csvLine);

        assertEquals(expectCsvLine, actual);
    }

    @Test
    public void testGetValueMatrix() {
        expectCsvMatrix.add(Arrays.asList("Name", "Strasse", "Ort", "Alter"));
        expectCsvMatrix.add(Arrays.asList("Peter Pan", "Am Hang 5", "12345 Einsam", "42"));
        expectCsvMatrix.add(Arrays.asList("Maria Schmitz", "Kölner Straße 45", "50123 Köln", "43"));
        expectCsvMatrix.add(Arrays.asList("Paul Meier", "Münchener Weg 1", "87654 München", "65"));

        String csvFile = "Name;Strasse;Ort;Alter\n" +
                "Peter Pan;Am Hang 5;12345 Einsam;42\n" +
                "Maria Schmitz;Kölner Straße 45;50123 Köln;43\n" +
                "Paul Meier;Münchener Weg 1;87654 München;65";

        List<List<String>> actualCsvMatrix = csvTabelle.getValueMatrix(csvFile);

        assertEquals(expectCsvMatrix, actualCsvMatrix);
    }

    @Test
    public void testGetColumnWidth() {
        int[] expectColWidth = {13, 16, 13, 5};
        int[] actualColWidth = csvTabelle.getColumnWidth(expectCsvMatrix);


        assertArrayEquals(expectColWidth, actualColWidth);
    }
}
