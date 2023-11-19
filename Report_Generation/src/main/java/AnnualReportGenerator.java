package main.java;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * The AnnualReportGenerator class extends ReportGenerator and is specifically
 * designed
 * for generating annual reports based on scholarship data.
 */
public class AnnualReportGenerator extends ReportGenerator {

    /** The year for which the annual report is generated. */
    private int year;

    /**
     * Constructs an AnnualReportGenerator with the provided scholarship data and
     * year.
     *
     * @param annualD The ArrayList of scholarships for the annual report.
     * @param year    The year for which the annual report is generated.
     */
    public AnnualReportGenerator(ArrayList<Scholarship> annualD, int year) {
        this.filepath = "src/Reports/AnnualReports/";
        AnnualReportGenerator.scholarships = annualD;
        this.year = year;
        this.filePrefix = "AnnualReport";
    }

    /**
     * Writes the annual report to a CSV file.
     * Overrides the method in the superclass.
     */
    @Override
    public void writeToFile() {
        try {
            String completeFilePath = this.filepath + filePrefix + "_" + year + ".csv";
            File newAnnualReport = new File(completeFilePath);
            System.out.println(newAnnualReport.createNewFile());
            FileWriter ReportWriter = new FileWriter(completeFilePath);
            ReportWriter.write(parseData());
            ReportWriter.close();
            System.out.println("Report Generated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        String reportString = "Scholarship name, Amount Rewarded, Deadline, Disbursment Date, Required Info, Preffered Majors\n";
        for (Scholarship data : AnnualReportGenerator.scholarships) {
            if (data.getDisbursementDate().substring(0,4).equals(Integer.toString(year))){
            reportString = reportString + data.getScholarshipName() + "," + Integer.toString(data.getPayout()) + "," +
                    data.getDeadline() + "," + data.getDisbursementDate() + ", " + data.getCustomRequiredInfo() + ", " + data.getPreferedMajors() + "\n";
            }
        }
        return reportString;
    }
}
