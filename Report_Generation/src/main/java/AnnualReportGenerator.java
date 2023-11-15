package main.java;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class AnnualReportGenerator extends ReportGenerator {
    // private static ArrayList<Scholarship> annualData;
    static int reportNumber = 0;
    private int year;
    protected String filepath;
    protected String filePrefix;
    //pass in data as arraylist 
    public AnnualReportGenerator(ArrayList<Scholarship> annualD, int year) {
        this.filepath = "src/main/AnnualReports/";
        AnnualReportGenerator.scholarships = annualD;
        this.year = year;
        this.filePrefix = "AnnualReport";
    }

    public void writeToFile(){
        try {
            String completeFilePath = this.filepath + filePrefix + "_" + year + ".csv";
            File newAnnualReport = new File(completeFilePath);
            System.out.println(newAnnualReport.createNewFile());
            FileWriter ReportWriter = new FileWriter(completeFilePath);
            ReportWriter.write(parseData());
            ReportWriter.close();
            System.out.println("Report Generated");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String parseData() {
        //TODO -- Fix this thing so it works with the static members.
        String reportString = "Scholarship,Amount Rewarded, Amount Disbursed, Date of Disbursement\n";
        for (Scholarship data : AnnualReportGenerator.scholarships){
            reportString = reportString + data.getName() + "," + Integer.toString(data.getAmount()) + "," + Integer.toString(data.getAmountDisbursed()) 
                    + "," + data.getDateAwarded() + "\n";
        }
        return reportString;
    }
    
    
}
