package main.java;

import java.util.ArrayList;

public class ApplicationData {
    // Static member representing a 2D ArrayList with pairs of questions and answers
    private static ArrayList<ArrayList<String>> applicationDataSet = new ArrayList<>();

    // Static initializer block to populate the data
    static {
        ArrayList<String> firstPair = new ArrayList<>();
        firstPair.add("Question");
        firstPair.add("Answer");
        applicationDataSet.add(firstPair);
    }

    // Pair adder
    public static void addPair(String question, String answer) {
        ArrayList<String> pair = new ArrayList<>();
        pair.add(question);
        pair.add(answer);
        applicationDataSet.add(pair);
    }

    // Getter for accessing the static data
    public static ArrayList<ArrayList<String>> getApplicationDataSet() {
        return applicationDataSet;
    }
}
