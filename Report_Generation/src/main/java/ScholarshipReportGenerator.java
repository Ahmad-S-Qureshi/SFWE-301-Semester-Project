package main.java;

import java.time.LocalDate;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScholarshipReportGenerator extends ReportGenerator {
    private ArrayList<Scholarship> scholarshipData;
    protected String filepath;
    protected String filePrefix;
    public static int reportNumber = 0;

    public ScholarshipReportGenerator(ArrayList<Scholarship> scholarship) {
        this.filepath = "src/Reports/ScholarshipReports/";
        this.scholarshipData = scholarship;
        this.filePrefix = "ScholarshipReport";
    }

    public void writeToFile() {
        try {
            String completeFilePath = this.filepath + filePrefix + reportNumber + ".csv";
            File newAnnualReport = new File(completeFilePath);
            System.out.println(newAnnualReport.createNewFile());
            FileWriter ReportWriter = new FileWriter(completeFilePath);
            ReportWriter.write(parseData());
            ReportWriter.close();
            reportNumber++;
            System.out.println("Report Generated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String parseData() {
        String reportString = "Scholarship name, Amount Rewarded, Deadline, Disbursment Date, Required Info, Preferred Majors\n";
        LocalDate currentDate = LocalDate.now();

        for (Scholarship data : AnnualReportGenerator.scholarships) {
            LocalDate disbursementDate = LocalDate.parse(data.getDisbursementDate());

            if (disbursementDate.isAfter(currentDate)) {
                reportString += data.getScholarshipName() + "," + data.getPayout() + "," +
                        data.getDeadline() + "," + data.getDisbursementDate() + ", " +
                        data.getCustomRequiredInfo() + ", " + data.getPreferedMajors() + "\n";
            }
        }
        return reportString;
    }

}
