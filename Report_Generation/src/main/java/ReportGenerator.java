package main.java;

public abstract class ReportGenerator {
    protected String filepath;
    static int reportNumber;
    abstract String parseData();
    protected String filePrefix;
    abstract void writeToFile();
    // Makes CSV report files
    // One function for each type of report
}
