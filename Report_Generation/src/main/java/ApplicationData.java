package main.java;

import java.util.ArrayList;

public class ApplicationData {
    // Static member representing a 2D ArrayList with pairs of questions and answers
    private ArrayList<ArrayList<String>> applicationDataSet = new ArrayList<>();

    // Pair adder
    public void addPair(String question, String answer) {
        ArrayList<String> pair = new ArrayList<>();
        pair.add(question);
        pair.add(answer);
        applicationDataSet.add(pair);
    }

    // Getter for accessing the static data
    public ArrayList<ArrayList<String>> getApplicationDataSet() {
        return applicationDataSet;
    }
}
