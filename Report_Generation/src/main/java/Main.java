import java.util.ArrayList;

import main.java.AnnualReportGenerator;
import main.java.Scholarship;
import main.java.Student;

/**
 * The Main class serves as a demonstration of the AnnualReportGenerator.
 * It runs generator tests with a set of dummy scholarships and generates
 * reports.
 * Each test has a set of students and a related file in a separate folder.
 * The program passes the test if the generated report matches the report in the
 * folder.
 */

public class Main {
    /**
     * The main method is the entry point of the program.
     * It creates dummy scholarships, adds them to an ArrayList, and generates an
     * annual report.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Sets dummy year to demo
        int year = 2000;

        // Create an ArrayList to store dummy scholarships
        ArrayList<Scholarship> scholarships = new ArrayList<>();

        // Create 10 dummy scholarships and add them to the ArrayList
        scholarships.add(new Scholarship("Scholarship1", 1000, "2023-01-01", "Essay required", "Computer Science"));
        scholarships.add(
                new Scholarship("Scholarship2", 1500, "2023-02-15", "Recommendation letters required", "Engineering"));
        scholarships.add(new Scholarship("Scholarship3", 1200, "2023-03-30", "Transcript required", "Mathematics"));
        scholarships.add(new Scholarship("Scholarship4", 800, "2023-04-15", "Interview required", "Biology"));
        scholarships.add(new Scholarship("Scholarship5", 2000, "2023-05-20", "Portfolio required", "Fine Arts"));
        scholarships.add(new Scholarship("Scholarship6", 1300, "2023-06-10", "Project samples required",
                "Business Administration"));
        scholarships
                .add(new Scholarship("Scholarship7", 1800, "2023-07-05", "Coding test required", "Computer Science"));
        scholarships.add(
                new Scholarship("Scholarship8", 1600, "2023-08-25", "Presentation required", "Communication Studies"));
        scholarships.add(new Scholarship("Scholarship9", 1400, "2023-09-12", "Volunteer experience required",
                "Social Sciences"));
        scholarships.add(new Scholarship("Scholarship10", 1700, "2023-10-08", "Research paper required", "Psychology"));

        // Create an instance of AnnualReportGenerator with the scholarships and year
        AnnualReportGenerator generator = new AnnualReportGenerator(scholarships, year);

        // Generate the annual report and write it to a file
        generator.writeToFile();
    }
}
