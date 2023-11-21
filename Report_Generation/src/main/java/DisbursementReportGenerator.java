package main.java;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * The AnnualReportGenerator class extends ReportGenerator and is specifically
 * designed
 * for generating annual reports based on scholarship data.
 */
public class DisbursementReportGenerator extends ReportGenerator {

    /** The year for which the annual report is generated. */
    private Student student;
    private Scholarship scholarship;

    /**
     * Constructs an AnnualReportGenerator with the provided scholarship data and
     * year.
     *
     * @param annualD The ArrayList of scholarships for the annual report.
     * @param year    The year for which the annual report is generated.
     */
    public DisbursementReportGenerator(Student student, Scholarship scholarship) {
        this.filepath = "src/Reports/DisbursementReports/";
        this.student = student;
        this.scholarship = scholarship;
        this.filePrefix = "DisbursementReport";
    }

    /**
     * Writes the annual report to a CSV file.
     * Overrides the method in the superclass.
     */
    @Override
    public String writeToFile() {
        try {
            String completeFilePath = this.filepath + filePrefix + "_" + scholarship.getScholarshipName() + ".csv";
            File newAnnualReport = new File(completeFilePath);
            System.out.println(newAnnualReport.createNewFile());
            FileWriter ReportWriter = new FileWriter(completeFilePath);
            ReportWriter.write(parseData());
            ReportWriter.close();
            System.out.println("Report Generated");
            return completeFilePath;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Parses scholarship data for the annual report.
     * Overrides the method in the superclass.
     *
     * @return A string representation of the scholarship data in CSV format.
     */
    @Override
    public String parseData() {
        // TODO -- Fix this thing so it works with the static members.
        String reportString = "Scholarship Name, Student ID, Amount Rewarded, Disbursment Date\n";
        reportString = reportString + scholarship.getScholarshipName() + "," + student.getStudentID() + ", " + Integer.toString(scholarship.getPayout()) + "," +
                scholarship.getDisbursementDate() + "\n";
        return reportString;
    }
}
