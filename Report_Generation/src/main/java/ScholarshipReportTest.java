import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class ScholarshipReportTest{

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

        // Test 1
        
    }
}