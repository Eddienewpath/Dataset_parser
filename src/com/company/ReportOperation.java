package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReportOperation {

    private Set<Report> reports;
    private HashMap<String, Integer> districtFrequency = new HashMap<>();

    public ReportOperation(Set<Report> reports){
        this.reports = reports;
    }


    // query 1: which location has the highest incident rate ?
    public Map.Entry<String, Integer> highestIncidentRateDistrict(){
        // record frequencies of each location.
        for(Report r : reports){
            districtFrequency.put(r.getDistrict(),
                    districtFrequency.getOrDefault(r.getDistrict(), 0) + 1);
        }

        // find the max key-value entry.
        Map.Entry<String, Integer> maxFreqEntry = null;
        for(Map.Entry<String, Integer> entry: districtFrequency.entrySet()){
            if(maxFreqEntry == null || maxFreqEntry.getValue().compareTo(entry.getValue()) < 0)
                maxFreqEntry = entry;
        }

        return maxFreqEntry;
    } // end of highestIncidentRateDistrict().


    // query 2: how many incidents occurred for given month?
    public int countIncidents(String month){
        int count = 0;

        try{
            int m = Integer.parseInt(month);

            for(Report r : reports){
                if(r.getDate().getMonth() == m)
                    count++;
            }

        }catch (Exception e){
            System.out.println("Wrong format!! pls enter digit month inside quotation");
        }
        return count;
    }
}
