package main.java;

public class Student {
    private static long ID;
    private static double GPA;
    private static boolean financialNeed;
    private static String gender;
    private static String major;
    private static String ethnicity;

    // Constructor without parameters
    public Student() {
        ID = 0;
        GPA = 0.0;
        financialNeed = false;
        gender = "Unknown";
        major = "Undeclared";
        ethnicity = "Unspecified";
    }

    // Additional constructor with parameters
    public Student(
        long ID,
        double GPA,
        boolean financialNeed,
        String gender,
        String major,
        String ethnicity) {

        Student.ID = ID;
        Student.GPA = GPA;
        Student.financialNeed = financialNeed;
        Student.gender = gender;
        Student.major = major;
        Student.ethnicity = ethnicity;
    }

    // Getters
    public static long getID() {return ID;}

    public static double getGPA() {return GPA;}

    public static boolean hasFinancialNeed() {return financialNeed;}

    public static String getGender() {return gender;}

    public static String getMajor() {return major;}

    public static String getEthnicity() {return ethnicity;}
}
