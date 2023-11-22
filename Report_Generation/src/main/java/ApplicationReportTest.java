import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.List;
import main.java.*;

public class ApplicationReportTest {
    
    private static List<String[]> readCSV(String filePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
        catch (Exception e) {
            return null;
        }
    }

    private static boolean compareCSVData(List<String[]> data1, List<String[]> data2) {
        if (data1.size() != data2.size()) {
            return false; // Different number of rows
        }

        for (int i = 0; i < data1.size(); i++) {
            String[] row1 = data1.get(i);
            String[] row2 = data2.get(i);

            if (!Arrays.equals(row1, row2)) {
                return false; // Rows are different
            }
        }

        return true; // All rows are identical
    }
    public static void main(String[] args) {
        
        Scholarship Scholarship1 = new Scholarship();
        ApplicationData ApplicationReport1 = new ApplicationData();
        Student Student1 = new Student();
         
        // Test 1
        try {
            Student1.setName("Jorge Del Rio");
            Scholarship1.setScholarshipName("Hitting The Griddy Scholarship");

            List<String[]> ReportData = readCSV("src/Test-Reports/ApplicationInfo1.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                //Question, Answer
                ApplicationReport1.addPair(strings[0], strings[1]);
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report " + e.getMessage());
        }
        
        ApplicationReportGenerator ApplicationRepo1 = new ApplicationReportGenerator(Scholarship1,Student1,ApplicationReport1);
        final String ApplicationReportFile1 = ApplicationRepo1.writeToFile();
        final String ApplicationReportTestFile1 = "src/Test-Reports/ApplicationInfo1.csv";

        try {
            // Read data from CSV files
            List<String[]> DataRead = readCSV(ApplicationReportFile1);
            List<String[]> DataCompare = readCSV(ApplicationReportTestFile1);

            // Compare data
            if (compareCSVData(DataRead, DataCompare)) {
                System.out.println("Test 1 Passed");
            } 
            else {
                System.out.println("Test 1 Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Scholarship1 = new Scholarship();
        ApplicationReport1 = new ApplicationData();
        Student1 = new Student();
        
    }
}
