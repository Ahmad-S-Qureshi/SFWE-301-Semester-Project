package main.java;
public class Scholarship {
    private static String donorContact;
    private static String name;
    private static int amount;
    private static int amountDisbursed;
    private static String deadline;
    private static String dateAwarded;
    
    public Scholarship() {
        //Has scholarship name, amount, amound disbursed, deadline, donor, date awarded, and amount.
        donorContact = "(000)-000-0000";
        name = "Dummy Scholarship";
        amount = 0;
        amountDisbursed = 0;
        deadline = "0/0/0000";
        dateAwarded = "0/0/0000";
        // date posted for the scholarship report will be updated in real-time 
    }

    public Scholarship(
        //TODO: Fix constructor so it actually works with static members
        String donorContact,
        String name,
        int amount,
        int amountDisbursed,
        String deadline,
        String dateAwarded) {

        Scholarship.donorContact = donorContact;
        Scholarship.name = name;
        Scholarship.amount = amount;
        Scholarship.amountDisbursed = amountDisbursed;
        Scholarship.deadline = deadline;
        Scholarship.dateAwarded = dateAwarded;
    }

    public static String getDonorContact() { return donorContact; }
    public static String getName() { return name; }
    public static int getAmount() { return amount; }
    public static int getAmountDisbursed() { return amountDisbursed; }
    public static String getDeadline() { return deadline; }
    public static String getDateAwarded() { return dateAwarded; }

    
}
