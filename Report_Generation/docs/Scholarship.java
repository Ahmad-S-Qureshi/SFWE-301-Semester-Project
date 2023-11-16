package main.java;
public class Scholarship {
    private String donorContact;
    private String name;
    private int amount;
    private int amountDisbursed;
    private String deadline;
    private String dateAwarded;
    
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

        this.donorContact = donorContact;
        this.name = name;
        this.amount = amount;
        this.amountDisbursed = amountDisbursed;
        this.deadline = deadline;
        this.dateAwarded = dateAwarded;
    }

    public String getDonorContact() { return donorContact; }
    public String getName() { return name; }
    public int getAmount() { return amount; }
    public int getAmountDisbursed() { return amountDisbursed; }
    public String getDeadline() { return deadline; }
    public String getDateAwarded() { return dateAwarded; }

    
}
