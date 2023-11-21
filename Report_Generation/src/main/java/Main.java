
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import main.java.AnnualReportGenerator;
import main.java.ScholarshipReportGenerator;
import main.java.Scholarship;

public class Main {
    /**
     * The main method is the entry point of the program.
     * It creates dummy scholarships, adds them to an ArrayList, and generates an
     * annual report.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {

        // Create an ArrayList to store dummy scholarships
        ArrayList<Scholarship> scholarships = new ArrayList<>();

        // Generate a specified number of random scholarships and add them to the ArrayList
        generateRandomScholarships(scholarships, 3140);

        // Create an instance of AnnualReportGenerator with the scholarships and year
        for (int year = 2015; year < 2025; year++){
            AnnualReportGenerator generator = new AnnualReportGenerator(scholarships, year);
            // Generate the annual report and write it to a file
            generator.writeToFile();
        }

        ScholarshipReportGenerator generator = new ScholarshipReportGenerator(scholarships);
        generator.writeToFile();
    }

    /**
     * Generates a specified number of random scholarships and adds them to the ArrayList.
     *
     * @param scholarships       The ArrayList to which scholarships will be added.
     * @param numberOfScholarships The number of scholarships to generate.
     */
    private static void generateRandomScholarships(ArrayList<Scholarship> scholarships, int numberOfScholarships) {
        for (int i = 0; i < numberOfScholarships; i++) {
            scholarships.add(generateRandomScholarship(scholarships));
        }
    }

    /**
     * Generates a single random scholarship.
     *
     * @return A randomly generated Scholarship object.
     */
    private static Scholarship generateRandomScholarship(ArrayList<Scholarship> scholarships) {
        // You can customize the parameters of the generated scholarship here
        String scholarshipName = "Scholarship" + (scholarships.size() + 1);
        int payout = new Random().nextInt(2000) + 500; // Random payout between 500 and 2500
        String deadline = getRandomDate();
        
        // Ensure disbursement date is greater than the deadline
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date deadlineDate = null;
        Date disbursementDate = null;
    
        try {
            deadlineDate = dateFormat.parse(deadline);
    
            // Generate a random disbursement date that is after the deadline
            do {
                String disbursementDateString = getRandomDate();
                disbursementDate = dateFormat.parse(disbursementDateString);
    
                if (disbursementDate.compareTo(deadlineDate) <= 0) {
                    // If disbursement date is not after the deadline, generate a new one
                    continue;
                }
    
                // If we reach here, the disbursement date is valid
                String customRequiredInfo = "Info"; // You can customize this
                String preferedMajors = "Major"; // You can customize this
    
                // Create and return a new Scholarship object
                return new Scholarship(scholarshipName, payout, deadline, disbursementDateString, customRequiredInfo, preferedMajors);
    
            } while (true);
    
        } catch (Exception e) {
            e.printStackTrace(); // Handle parsing exceptions if needed
            return null;
        }
    }
    

    /**
     * Generates a random date within a specific range.
     *
     * @return A string representation of the random date.
     */
    private static String getRandomDate() {
        // Set the range of years for the random date
        int startYear = 2014;
        int endYear = 2024;

        // Generate a random year within the specified range
        int randomYear = startYear + new Random().nextInt(endYear - startYear + 1);

        // Generate a random month (1-12)
        int randomMonth = 1 + new Random().nextInt(12);

        // Generate a random day (1-28 for simplicity)
        int randomDay = 1 + new Random().nextInt(28);

        // Format the random date as "YYYY-MM-DD"
        return String.format("%04d-%02d-%02d", randomYear, randomMonth, randomDay);
    }
}
