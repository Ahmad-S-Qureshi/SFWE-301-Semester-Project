package main.java;

public class Student {
    private long ID;
    private double GPA;
    private boolean financialNeed;
    private String gender;
    private String major;
    private String ethnicity;

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

        this.ID = ID;
        this.GPA = GPA;
        this.financialNeed = financialNeed;
        this.gender = gender;
        this.major = major;
        this.ethnicity = ethnicity;
    }

    // Getters
    public long getID() {return ID;}

    public double getGPA() {return GPA;}

    public boolean hasFinancialNeed() {return financialNeed;}

    public String getGender() {return gender;}

    public String getMajor() {return major;}

    public String getEthnicity() {return ethnicity;}
}
