package main.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  // Import DateTimeFormatter
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScholarshipReportGenerator extends ReportGenerator {
    private ArrayList<Scholarship> scholarshipData;
    protected String filepath;
    protected String filePrefix;
    protected String reportDate;

    public ScholarshipReportGenerator(ArrayList<Scholarship> scholarship) {
        this.filepath = "src/Reports/ScholarshipReports/";
        this.scholarshipData = scholarship;
        this.filePrefix = "ScholarshipReport";
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDate.format(formatter);
        this.reportDate = formattedString;
    }

    public String writeToFile() {
        try {
            String completeFilePath = this.filepath + filePrefix + reportDate + ".csv";
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

    public String parseData() {
        String reportString = "Scholarship name, Amount Rewarded, Deadline, Disbursement Date, Required Info, Preferred Majors\n";
        LocalDate currentDate = LocalDate.now();

        for (Scholarship data : scholarshipData) {  // Use the instance variable
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
