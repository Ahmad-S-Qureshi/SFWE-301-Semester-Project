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
        //MatchingData MatchingReport = new MatchingData();

        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest1.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    //MatchingReport.addPair(strings[0], strings[1]);
                    ScholarshipList1.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo1 = new MatchingReportGenerator(ScholarshipList1, Student1);
    }
}
