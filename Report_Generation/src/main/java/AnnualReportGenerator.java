package main.java;
import java.io.File;
import java.io.FileWriter;


public class AnnualReportGenerator extends ReportGenerator {
    private Student studentData;
    private Scholarship scholarshipData;
    protected String filepath;
    protected String filePrefix;
    public static int reportNumber = 0;
    public AnnualReportGenerator(Student student, Scholarship scholarship) {
        this.filepath = "src/main/AnnualReports/";
        this.studentData = student;
        this.scholarshipData = scholarship;
        this.filePrefix = "AnnualReport";
    }
    public void writeToFile(){
        try {
            String completeFilePath = this.filepath + filePrefix + reportNumber + ".txt";
            File newAnnualReport = new File(completeFilePath);
            System.out.println(newAnnualReport.createNewFile());
            FileWriter ReportWriter = new FileWriter(completeFilePath);
            ReportWriter.write(parseData());
            ReportWriter.close();
            reportNumber++;
            System.out.println("Report Generated");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String parseData() {
        return "ANNUAL REPORT PARSING TO BE IMPLEMENTED";
    }
    
    
}
