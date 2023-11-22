import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.List;
import main.java.*;

public class MatchingReportTest {

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

        ArrayList<Scholarship> ScholarshipList1 = new ArrayList<Scholarship>();
        ArrayList<Student> Student1 = new ArrayList<Student>(); //could be used to check student name and ID

        // Matching Report Test 1
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest1.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    ScholarshipList1.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo1 = new MatchingReportGenerator(ScholarshipList1, Student1);
        final String MatchingRepoFile1 = MatchingRepo1.writeToFile();
        final String MatchingRepoTestFile1 = "src/Test-Reports/MatchReportTest1Compare.csv";

        try {
            // Read data from CSV files
            List<String[]> DataRead = readCSV(MatchingRepoFile1);
            List<String[]> DataCompare = readCSV(MatchingRepoTestFile1);

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

        ArrayList<Scholarship> ScholarshipList2 = new ArrayList<Scholarship>();
        ArrayList<Student> Student2 = new ArrayList<Student>(); //could be used to check student name and ID
        
        // Matching Report Test 2
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest2.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    ScholarshipList2.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo2 = new MatchingReportGenerator(ScholarshipList2, Student2);
        final String MatchingRepoFile2 = MatchingRepo2.writeToFile();
        final String MatchingRepoTestFile2 = "src/Test-Reports/MatchReportTest2Compare.csv";

        try {
            // Read data from CSV files
            List<String[]> DataRead = readCSV(MatchingRepoFile2);
            List<String[]> DataCompare = readCSV(MatchingRepoTestFile2);

            // Compare data
            if (compareCSVData(DataRead, DataCompare)) {
                System.out.println("Test 2 Passed");
            } 
            else {
                System.out.println("Test 2 Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Scholarship> ScholarshipList3 = new ArrayList<Scholarship>();
        ArrayList<Student> Student3 = new ArrayList<Student>(); //could be used to check student name and ID

        // Matching Report Test 3
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest3.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    ScholarshipList3.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo3 = new MatchingReportGenerator(ScholarshipList3, Student3);
        final String MatchingRepoFile3 = MatchingRepo3.writeToFile();
        final String MatchingRepoTestFile3 = "src/Test-Reports/MatchReportTest3Compare.csv";

        try {
            // Read data from CSV files
            List<String[]> DataRead = readCSV(MatchingRepoFile3);
            List<String[]> DataCompare = readCSV(MatchingRepoTestFile3);

            // Compare data
            if (compareCSVData(DataRead, DataCompare)) {
                System.out.println("Test 3 Passed");
            } 
            else {
                System.out.println("Test 3 Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
