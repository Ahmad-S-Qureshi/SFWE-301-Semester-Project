import main.java.AnnualReportGenerator;
import main.java.Scholarship;
import main.java.Student;

public class Main {
    // Runs Generator Tests and will serve as demo
    // Each test will have a set of students and a related file in a separate folder
    // The program will pass the test if the generated report matches the report in the folder
    public static void main(String[] args) {
        AnnualReportGenerator generator = new AnnualReportGenerator(new Student(), new Scholarship());
        generator.writeToFile();
        generator.writeToFile();
    }
}
