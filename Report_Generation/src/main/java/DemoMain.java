import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoMain extends JFrame {

    private JTextField emailField;
    private JTextField nameField;
    private JTextField scholarshipsField;
    private JTextField studentsField;

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

        // Submit Button
        JButton disbursementButton = new JButton("Generate Disbursement Report");
        disbursementButton.addActionListener(new ActionListener() {
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

        // Submit Button
        JButton scholarshipButton = new JButton("Generate Scholarship Report");
        scholarshipButton.addActionListener(new ActionListener() {
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

        // Add buttons to the panel
        panel.add(disbursementButton);
        panel.add(scholarshipButton);
        panel.add(annualReportButton);
        panel.add(applicationButton);

        // Set up the frame
        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
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
