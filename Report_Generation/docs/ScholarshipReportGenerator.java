package main.java;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class ScholarshipReportGenerator extends ReportGenerator {
    private ArrayList <Scholarship> scholarshipData;
    protected String filepath;
    protected String filePrefix;
    public static int reportNumber = 0;
    public ScholarshipReportGenerator(ArrayList<Scholarship> scholarship) {
        this.filepath = "src/main/AnnualReports/";
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
        String reportString = "";
        for (Scholarship data : scholarshipData){
            reportString = reportString + data + "\n";
        }
        return reportString;
    }
    
    
}
