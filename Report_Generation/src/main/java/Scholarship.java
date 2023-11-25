package main.java;

public class Scholarship {
    private String scholarshipName;
    private int payout;
    private String deadline;
    private String disbursmentDate;
    private String customRequiredInfo;
    private String preferedMajors;
    private String donorContact;
    private String eligible;

    public Scholarship() { // This is the constructor
        this.scholarshipName = "No Name";
        this.payout = 0;
        this.deadline = "N/A";
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
        this.donorContact = "Unknown";
    }

    ///// Start Overloaded constructors for the scholarship class /////
    public Scholarship(String scholarshipName) {
        this.scholarshipName = scholarshipName;
        this.payout = 0;
        this.deadline = "N/A";
        this.disbursmentDate = "N/A";
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
        this.donorContact = "Unknown";
    }

    public Scholarship(String scholarshipName, int payout) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = "N/A";
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
        this.donorContact = "Unknown";
    }

    public Scholarship(String scholarshipName, int payout, String deadline) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.customRequiredInfo = "None";
        this.preferedMajors = "None";
        this.donorContact = "Unknown";
    }

    public Scholarship(String scholarshipName, int payout, String deadline, String customRequiredInfo) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = "None";
        this.donorContact = "Unknown";
    }

    public Scholarship(String scholarshipName, int payout, String deadline, String customRequiredInfo,
            String preferedMajors) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = preferedMajors;
        this.donorContact = "Unknown";
    }

    public Scholarship(String scholarshipName, int payout, String deadline, String disbursmentDate, String customRequiredInfo,
            String preferedMajors) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.disbursmentDate = disbursmentDate;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = preferedMajors;
        this.donorContact = "Unknown";
    }
    public Scholarship(String scholarshipName, int payout, String deadline, String disbursmentDate, String customRequiredInfo,
            String preferedMajors, String donorContact) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.disbursmentDate = disbursmentDate;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = preferedMajors;
        this.donorContact = donorContact;
    }
    public Scholarship(String scholarshipName, int payout, String deadline, String disbursmentDate, String customRequiredInfo,
            String preferedMajors, String donorContact, String eligible) {
        this.scholarshipName = scholarshipName;
        this.payout = payout;
        this.deadline = deadline;
        this.disbursmentDate = disbursmentDate;
        this.customRequiredInfo = customRequiredInfo;
        this.preferedMajors = preferedMajors;
        this.donorContact = donorContact;
        this.eligible = eligible;
    }
    ///// End Overloaded constructors for the scholarship class /////

    ///////// Start mutators and accessors /////////

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDisbursementDate() {
        return disbursmentDate;
    }

    public void setDisbursementDate(String disbursmentDate) {
        this.disbursmentDate = disbursmentDate;
    }

    public String getCustomRequiredInfo() {
        return customRequiredInfo;
    }

    public String getDonorContact() {
        return donorContact;
    }

    public void setCustomRequiredInfo(String customRequiredInfo) {
        this.customRequiredInfo = customRequiredInfo;
    }

    public String getPreferedMajors() {
        return preferedMajors;
    }

    public void setPreferedMajors(String preferedMajors) {
        this.preferedMajors = preferedMajors;
    }
    ///////// End mutators and accessors /////////

}