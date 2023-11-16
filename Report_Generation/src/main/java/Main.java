import java.util.ArrayList;

import main.java.AnnualReportGenerator;
import main.java.Scholarship;
import main.java.Student;

/**
 * The Main class serves as a demonstration of the AnnualReportGenerator.
 * It runs generator tests with a set of dummy scholarships and generates reports.
 * Each test has a set of students and a related file in a separate folder.
 * The program passes the test if the generated report matches the report in the folder.
 */

public class Main {
    /**
     * The main method is the entry point of the program.
     * It creates dummy scholarships, adds them to an ArrayList, and generates an annual report.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Sets dummy year to demo
        int year = 2000;

        // Create an ArrayList to store dummy scholarships
        ArrayList<Scholarship> scholarships = new ArrayList<>();

        // Create 10 dummy scholarships and add them to the ArrayList
        scholarships.add(new Scholarship("(111)-111-1111", "First Scholarship", 2000, 0, "12/31/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(222)-222-2222", "Second Scholarship", 1500, 0, "11/30/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(333)-333-3333", "Third Scholarship", 3000, 0, "10/31/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(444)-444-4444", "Fourth Scholarship", 2500, 0, "09/30/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(555)-555-5555", "Fifth Scholarship", 1800, 0, "08/31/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(666)-666-6666", "Sixth Scholarship", 2200, 0, "07/31/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(777)-777-7777", "Seventh Scholarship", 2700, 0, "06/30/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(888)-888-8888", "Eighth Scholarship", 1900, 0, "05/31/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(999)-999-9999", "Ninth Scholarship", 3200, 0, "04/30/2023", "0/0/0000"));
        scholarships.add(new Scholarship("(101)-101-1010", "Tenth Scholarship", 2800, 0, "03/31/2023", "0/0/0000"));

        // Create an instance of AnnualReportGenerator with the scholarships and year
        AnnualReportGenerator generator = new AnnualReportGenerator(scholarships, year);

        // Generate the annual report and write it to a file
        generator.writeToFile();
    }
}
