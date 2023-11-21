import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.List;
import main.java.*;

public class AnnualReportTest {

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

        
        AnnualReportGenerator AnnualRepo = new AnnualReportGenerator(null, 0);
        
        final String AnnualReportFileGen = AnnualRepo.writeToFile();
        final String AnnualReportTestFile1 = "src/Test-Reports/AnnualReportTest1.csv";

        //Annual Report Test 1        
         try {
            // Read data from CSV files
            List<String[]> DataRead = readCSV(AnnualReportFileGen);
            List<String[]> DataCompare = readCSV(AnnualReportTestFile1);

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
    }
}