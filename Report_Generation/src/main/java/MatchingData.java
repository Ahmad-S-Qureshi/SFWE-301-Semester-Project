package main.java;

import java.util.ArrayList;

public class MatchingData {
    
    private ArrayList<ArrayList<String>> MatchDataSet = new ArrayList<>();
        
    public void addPair(String Scholarship, String Amount) {
        ArrayList<String> pair = new ArrayList<>();
        pair.add(Scholarship);
        pair.add(Amount);
        MatchDataSet.add(pair);
    }
    
    // Getter for accessing the static data
    public ArrayList<ArrayList<String>> getApplicationDataSet() {
        return MatchDataSet;
    }
    
}
