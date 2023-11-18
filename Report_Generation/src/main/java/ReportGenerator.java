package main.java;

import java.util.ArrayList;

/**
 * The ReportGenerator class is responsible for generating reports based on
 * scholarship and student data.
 * It provides methods to parse data, write reports to files, and create CSV
 * report files for different report types.
 */
public class ReportGenerator {
    /** The file path where the reports will be saved. */
    protected String filepath;

    /** The list of scholarships to be used in report generation. */
    protected static ArrayList<Scholarship> scholarships;

    /** The list of students to be used in report generation. */
    protected static ArrayList<Student> students;

    /**
     * Parses the data for report generation.
     *
     * @return A string indicating that the parseData method is to be implemented.
     */
    public String parseData() {
        return "parseData TO BE IMPLEMENTED";
    }

    /** The prefix to be used for report file names. */
    protected String filePrefix;

    /**
     * Writes the generated reports to files.
     * This method currently prints a message indicating that it is not yet
     * implemented.
     */
    public void writeToFile() {
        System.out.println("writeToFile not yet implemented");
    }

    /**
     * Makes CSV report files for different types of reports.
     * There should be one function for each type of report.
     */
    // TODO: Add specific report-generating methods here.
}
