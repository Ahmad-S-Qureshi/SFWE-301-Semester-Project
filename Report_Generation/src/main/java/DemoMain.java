import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.JTextFieldWithPlaceholder;
import main.java.Scholarship;
import main.java.ScholarshipReportGenerator;
import main.java.Student;
import main.java.AnnualReportGenerator;
import main.java.DisbursementReportGenerator;
import main.java.GMailer;


public class DemoMain extends JFrame {

    private JTextField emailField;
    private JTextField nameField;
    private JTextField scholarshipsField;
    private JTextField studentsField;
    public ArrayList<Scholarship> scholarshipData;

    public DemoMain() {
        super("Scholarship Report Generator Demo Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Email Address
        JLabel emailLabel = new JLabel("Email Address:");
        emailField = new JTextFieldWithPlaceholder("Enter your email");

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextFieldWithPlaceholder("Enter your name");

        // Number of Scholarships
        JLabel scholarshipsLabel = new JLabel("Number of Scholarships:");
        scholarshipsField = new JTextFieldWithPlaceholder("Enter the number of scholarships");

        // Number of Students
        JLabel studentsLabel = new JLabel("Number of Students:");
        studentsField = new JTextFieldWithPlaceholder("Enter the number of students");

        // Add components to the panel
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(scholarshipsLabel);
        panel.add(scholarshipsField);
        panel.add(studentsLabel);
        panel.add(studentsField);


        // Submit Button
        JButton annualReportButton = new JButton("Generate Annual Report");
        annualReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        AnnualReportGenerator generator = new AnnualReportGenerator(scholarshipData, 2022);
                        String path = generator.writeToFile();
                        System.out.println("Generated " + scholarshipData.size() + " Scholarships");
                        try {
                            new GMailer().sendMail("Annual Report", "We are the best Report Team!", new File(path), emailField.getText());
                        } catch (Exception a) {

                        }
                    }
                });

        // Submit Button
        JButton disbursementButton = new JButton("Generate Disbursement Report");
        disbursementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                Student tempStudent = new Student("unknown", 0, "" + rand.nextInt(scholarshipData.size()));
                DisbursementReportGenerator generator = new DisbursementReportGenerator(tempStudent, scholarshipData.get(rand.nextInt(scholarshipData.size())));
                String path = generator.writeToFile();
                System.out.println("Generated " + scholarshipData.size() + " Scholarships");
                try {
                    new GMailer().sendMail("Disbursement Report", "We are the best Report Team!", new File(path), emailField.getText());
                } catch (Exception a) {

                }
            }
        });

        // Submit Button
        JButton scholarshipButton = new JButton("Generate Scholarship Report");
        scholarshipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScholarshipReportGenerator generator = new ScholarshipReportGenerator(scholarshipData);
                String path = generator.writeToFile();
                try {
                    new GMailer().sendMail("Scholarship Report", "We are the best Report Team!", new File(path), emailField.getText());
                } catch (Exception a) {

                }

            }
        });

        // Submit Button
        JButton applicationButton = new JButton("Generate Application Report");
        applicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission logic here
                String email = emailField.getText();
                String name = nameField.getText();
                String scholarships = scholarshipsField.getText();

                // Print or process the data as needed
                System.out.println("Email: " + email);
                System.out.println("Name: " + name);
                System.out.println("Number of Scholarships: " + scholarships);
            }
        });
        
        JButton generateDataButton = new JButton("Generate Data");
        generateDataButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                
                        // Create an ArrayList to store dummy scholarships
                        scholarshipData = new ArrayList<>();

                        // Generate a specified number of random scholarships and add them to the ArrayList
                        generateRandomScholarships(scholarshipData, 3150);

            }
        });

        // Add buttons to the panel
        panel.add(disbursementButton);
        panel.add(scholarshipButton);
        panel.add(annualReportButton);
        panel.add(applicationButton);
        panel.add(generateDataButton);

        // Set up the frame
        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

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
        Random Rand = new Random();
        int payout = Rand.nextInt(2000) + 500; // Random payout between 500 and 2500
        String deadline = getRandomDate();
        ArrayList<String> majorChoices = new ArrayList<String>(List.of("Computer Science", "Software Engineering", "Electrical and Computer Engineering", "Computer Science and Engineering", "Systems Engineering", "Industrial Engineering"));
        ArrayList<String> InfoChoices = new ArrayList<String>(List.of("Transcript", "Essay", "Resume"));
        
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
                String customRequiredInfo = InfoChoices.get(Rand.nextInt(InfoChoices.size())); // You can customize this
                String preferedMajors = majorChoices.get(Rand.nextInt(majorChoices.size())); // You can customize this
    
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoMain();
            }
        });
    }



}
