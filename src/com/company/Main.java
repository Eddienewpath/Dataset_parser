package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Police Department Incident Reports
 *
 * query 1: which location has the highest incident rate?
 *
 * query 2: how many incidents occurred during given month?
 **/

public class Main {

    public static void main(String[] args) {
        Set<Report> reports;
        reports = parse(); // creates the set of Report objects

        // answer query 1: which location has the highest incident rate?
        ReportOperation queryAnwser = new ReportOperation(reports);
        System.out.println(queryAnwser.highestIncidentRateDistrict());

        // answer query 2: how many incidents occurred during given month?
        System.out.println(queryAnwser.countIncidents("9"));


    }

    public static Set<Report> parse() {
        Set<Report> list = new HashSet<>();
        try (Scanner fileScan = new Scanner(
                new FileReader(new File("./src/com/company/Police_Department_Incident_Reports__2018_to_Present.csv")))) {
            fileScan.nextLine();

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();

                line = removeComma(line);
                String[] splitLine = line.split(",");
                for (int i = 0; i < splitLine.length; i++) {
                    if (splitLine[i].contains("`")) {
                        splitLine[i] = splitLine[i].replaceAll("`", ",");
                    }
                    if (splitLine[i].contains("\"")) {
                        splitLine[i] = splitLine[i].replaceAll("\"", "");
                    }
                }
                Report report;
                try {
                    report = new Report(splitLine[7], splitLine[1], splitLine[15], splitLine[21]);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    //System.out.println(splitLine[0]);
                    report = new Report(splitLine[7], splitLine[1], splitLine[15], "N/A");
                }
                list.add(report);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static String removeComma(String string) {
        boolean hasQuote = false;
        String result = "";
        for (char c : string.toCharArray()) {
            if (c == '\"')
                hasQuote = !hasQuote;
            if (c == ',' && hasQuote)
                c = '`';
            result += c; //if char is a comma, it turns it to a `
        }

        return result;
    }
}