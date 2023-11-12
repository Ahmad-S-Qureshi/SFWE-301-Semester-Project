package main.java;

public class AnnualQuicktest {
    public static void main(String[] args) {

        AnnualReportGenerator generator = new AnnualReportGenerator(new Student(), new Scholarship());
        generator.writeToFile();
        generator.writeToFile();
    }
}