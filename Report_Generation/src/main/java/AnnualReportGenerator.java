package main.java;
import java.io.File;
import java.io.FileWriter;


public class AnnualReportGenerator extends ReportGenerator {
    private Student studentData;
    private Scholarship scholarshipData;
    protected String filepath;
    public static int reportNumber = 0;
    public AnnualReportGenerator(Student student, Scholarship scholarship) {
        this.filepath = "src/main/AnnualReports/";
        this.studentData = student;
        this.scholarshipData = scholarship;
    }
    public String parseData() {
        return "ANNUAL REPORT PARSING TO BE IMPLEMENTED";
    }
    public void writeToFile() {
        try {
            String completeFilePath = this.filepath + "AnnualReportNumber" + reportNumber + ".txt";
            File newAnnualReport = new File(completeFilePath);
            newAnnualReport.createNewFile();
            
            FileWriter ReportWriter = new FileWriter(completeFilePath);
            ReportWriter.write(parseData());
            ReportWriter.close();
            reportNumber++;
            System.out.println("Annual Report Generated");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
