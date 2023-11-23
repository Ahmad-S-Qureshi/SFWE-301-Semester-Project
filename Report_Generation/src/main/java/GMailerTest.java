import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.opencsv.CSVReader;

import org.apache.commons.codec.binary.Base64;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileReader;
import main.java.*;

import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import static javax.mail.Message.RecipientType.TO;

public class GMailerTest {
    
    private static List<String[]> readCSV(String filePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
        catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
        
        final String EmailAddress = "jorgedelrio@arizona.edu";
        
        // Used for Report Email Tests
        ArrayList<Scholarship> AnnualRepoData = new ArrayList<Scholarship>();
        ArrayList<Scholarship> ScholarshipList = new ArrayList<Scholarship>();
        ArrayList<Student> StudentData = new ArrayList<Student>(); //could be used to check student name and ID
        Scholarship Scholarship = new Scholarship();
        Student Student = new Student();
        ApplicationData ApplicationReport = new ApplicationData();

        //----------------------------------------------------------------------------------------------------------------------------------------------//

        // Annual Report Email Test 1
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/AnnualReportTest1.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                AnnualRepoData.add(new Scholarship(strings[0],Integer.parseInt(strings[1]),strings[2],strings[3],strings[4],strings[5]));    
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
            System.out.println(e.getMessage());
        }
         
        AnnualReportGenerator AnnualRepo1 = new AnnualReportGenerator(AnnualRepoData,2024);
        final String AnnualReportPath1 = AnnualRepo1.writeToFile();

        try {
            new GMailer().sendMail("Annual Report", "Here is the Annual Report", new File(AnnualReportPath1), EmailAddress);
            System.out.println("Annual Report Sent! Please check your email inbox");
            System.out.println("Test 1 passed");
        } catch (Exception a) {
            System.out.println("Annual Report NOT Sent.");
            System.out.println("Test 1 Failed");
            System.out.println(a.getMessage());
        }

        AnnualRepoData = new ArrayList<Scholarship>(); // reset for next test

        //----------------------------------------------------------------------------------------------------------------------------------------------//

        // Annual Report Email Test 2
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/AnnualReportTest2.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                AnnualRepoData.add(new Scholarship(strings[0],Integer.parseInt(strings[1]),strings[2],strings[3],strings[4],strings[5]));    
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
            System.out.println(e.getMessage());
        }
         
        AnnualReportGenerator AnnualRepo2 = new AnnualReportGenerator(AnnualRepoData,2023);
        final String AnnualReportPath2 = AnnualRepo2.writeToFile();

        try {
            new GMailer().sendMail("Annual Report", "Here is the Annual Report", new File(AnnualReportPath2), EmailAddress);
            System.out.println("Annual Report Sent! Please check your email inbox");
            System.out.println("Test 2 passed");
        } catch (Exception a) {
            System.out.println("Annual Report NOT Sent.");
            System.out.println("Test 2 Failed");
            System.out.println(a.getMessage());
        }

        AnnualRepoData = new ArrayList<Scholarship>(); // reset for next test
        
        //----------------------------------------------------------------------------------------------------------------------------------------------//
        
        // Application Report Email Test 1
        Student.setName("Jorge Del Rio");
        Scholarship.setScholarshipName("Hitting The Griddy Scholarship");
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/ApplicationInfo1.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                //Question, Answer
                ApplicationReport.addPair(strings[0],strings[1]);
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report " + e.getMessage());
        }
        
        ApplicationReportGenerator ApplicationRepo1 = new ApplicationReportGenerator(Scholarship,Student,ApplicationReport);
        final String ApplicationReportFile1 = ApplicationRepo1.writeToFile();
        
        try {
            new GMailer().sendMail("Applicant Report", "Here is the Applicant Report", new File(ApplicationReportFile1), EmailAddress);
            System.out.println("Applicant Report Sent! Please check your email inbox");
            System.out.println("Test 3 passed");
        } catch (Exception a) {
            System.out.println("Applicant Report NOT Sent.");
            System.out.println("Test 3 Failed");
            System.out.println(a.getMessage());
        }

        Scholarship = new Scholarship(); // reset for new test
        Student = new Student(); // reset for new test
        ApplicationReport = new ApplicationData(); // reset for new test

        //----------------------------------------------------------------------------------------------------------------------------------------------//

        // Application Report Email Test 2
        Student.setName("Jorge Del Rio");
        Scholarship.setScholarshipName("What in the Griddy?");
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/ApplicationInfo2.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                //Question, Answer
                ApplicationReport.addPair(strings[0],strings[1]);
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report " + e.getMessage());
        }
        
        ApplicationReportGenerator ApplicationRepo2 = new ApplicationReportGenerator(Scholarship,Student,ApplicationReport);
        final String ApplicationReportFile2 = ApplicationRepo2.writeToFile();
        
        try {
            new GMailer().sendMail("Applicant Report", "Here is the Applicant Report", new File(ApplicationReportFile2), EmailAddress);
            System.out.println("Applicant Report Sent! Please check your email inbox");
            System.out.println("Test 4 passed");
        } catch (Exception a) {
            System.out.println("Applicant Report NOT Sent.");
            System.out.println("Test 4 Failed");
            System.out.println(a.getMessage());
        }

        Scholarship = new Scholarship(); // reset for new test
        Student = new Student(); // reset for new test
        ApplicationReport = new ApplicationData(); // reset for new test

        //----------------------------------------------------------------------------------------------------------------------------------------------//

        //Disbursement Report Email Test 1  
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/DisbursementTest1.csv");
            for (int i = 1; i < 2; i++) {
                String[] strings = ReportData.get(i);
                Scholarship.setScholarshipName(strings[0]);
                Student.setStudentID(strings[1]);
                Scholarship.setPayout(Integer.parseInt(strings[2]));
                Scholarship.setDisbursementDate(strings[3]);
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report " + e.getMessage());
        }
         
        DisbursementReportGenerator DisbursementRepo1 = new DisbursementReportGenerator(Student,Scholarship);
        final String DisbursementReportFileGen1 = DisbursementRepo1.writeToFile();
        
        try {
            new GMailer().sendMail("Disbursement Report", "Here is the Disbursement Report", new File(DisbursementReportFileGen1), EmailAddress);
            System.out.println("Disbursement Report Sent! Please check your email inbox");
            System.out.println("Test 5 passed");
        } catch (Exception a) {
            System.out.println("Disbursement Report NOT Sent.");
            System.out.println("Test 5 Failed");
            System.out.println(a.getMessage());
        }

        Scholarship = new Scholarship(); // reset for new test
        Student = new Student(); // reset for new test

        //----------------------------------------------------------------------------------------------------------------------------------------------//
        
        //Disbursement Report Email Test 2  
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/DisbursementTest2.csv");
            for (int i = 1; i < 2; i++) {
                String[] strings = ReportData.get(i);
                Scholarship.setScholarshipName(strings[0]);
                Student.setStudentID(strings[1]);
                Scholarship.setPayout(Integer.parseInt(strings[2]));
                Scholarship.setDisbursementDate(strings[3]);
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report " + e.getMessage());
        }
         
        DisbursementReportGenerator DisbursementRepo2 = new DisbursementReportGenerator(Student,Scholarship);
        final String DisbursementReportFileGen2 = DisbursementRepo2.writeToFile();
        
        try {
            new GMailer().sendMail("Disbursement Report", "Here is the Disbursement Report", new File(DisbursementReportFileGen2), EmailAddress);
            System.out.println("Disbursement Report Sent! Please check your email inbox");
            System.out.println("Test 6 passed");
        } catch (Exception a) {
            System.out.println("Disbursement Report NOT Sent.");
            System.out.println("Test 6 Failed");
            System.out.println(a.getMessage());
        }

        Scholarship = new Scholarship(); // reset for new test
        Student = new Student(); // reset for new test
        
        //----------------------------------------------------------------------------------------------------------------------------------------------//
        
        //Disbursement Report Email Test 3  
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/DisbursementTest3.csv");
            for (int i = 1; i < 2; i++) {
                String[] strings = ReportData.get(i);
                Scholarship.setScholarshipName(strings[0]);
                Student.setStudentID(strings[1]);
                Scholarship.setPayout(Integer.parseInt(strings[2]));
                Scholarship.setDisbursementDate(strings[3]);
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report " + e.getMessage());
        }
         
        DisbursementReportGenerator DisbursementRepo3 = new DisbursementReportGenerator(Student,Scholarship);
        final String DisbursementReportFileGen3 = DisbursementRepo3.writeToFile();
        
        try {
            new GMailer().sendMail("Disbursement Report", "Here is the Disbursement Report", new File(DisbursementReportFileGen3), EmailAddress);
            System.out.println("Disbursement Report Sent! Please check your email inbox");
            System.out.println("Test 7 passed");
        } catch (Exception a) {
            System.out.println("Disbursement Report NOT Sent.");
            System.out.println("Test 7 Failed");
            System.out.println(a.getMessage());
        }

        Scholarship = new Scholarship(); // reset for new test
        Student = new Student(); // reset for new test
        
        //----------------------------------------------------------------------------------------------------------------------------------------------//
 
        // Matching Report Email Test 1
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest1.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    ScholarshipList.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo1 = new MatchingReportGenerator(ScholarshipList, StudentData);
        final String MatchingRepoFile1 = MatchingRepo1.writeToFile();

        try {
            new GMailer().sendMail("Matching Report", "Here is the Matching Report", new File(MatchingRepoFile1), EmailAddress);
            System.out.println("Matching Report Sent! Please check your email inbox");
            System.out.println("Test 8 passed");
        } catch (Exception a) {
            System.out.println("Matching Report NOT Sent.");
            System.out.println("Test 8 Failed");
            System.out.println(a.getMessage());
        }

        ScholarshipList = new ArrayList<Scholarship>(); // reset for new test

        //----------------------------------------------------------------------------------------------------------------------------------------------/

        // Matching Report Email Test 2
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest2.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    ScholarshipList.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo2 = new MatchingReportGenerator(ScholarshipList, StudentData);
        final String MatchingRepoFile2 = MatchingRepo2.writeToFile();

        try {
            new GMailer().sendMail("Matching Report", "Here is the Matching Report", new File(MatchingRepoFile2), EmailAddress);
            System.out.println("Matching Report Sent! Please check your email inbox");
            System.out.println("Test 9 passed");
        } catch (Exception a) {
            System.out.println("Matching Report NOT Sent.");
            System.out.println("Test 9 Failed");
            System.out.println(a.getMessage());
        }

        ScholarshipList = new ArrayList<Scholarship>(); // reset for new test

        //----------------------------------------------------------------------------------------------------------------------------------------------/

        // Matching Report Email Test 3
        try {
            List<String[]> ReportData = readCSV("src/Test-Reports/MatchingReportTest3.csv");
            for (int i = 1; i < ReportData.size(); i++) {
                String[] strings = ReportData.get(i);
                if (strings[2].equalsIgnoreCase("Yes")) {
                    ScholarshipList.add(new Scholarship(strings[0],Integer.parseInt(strings[1])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Could not read Report");
        }

        MatchingReportGenerator MatchingRepo3 = new MatchingReportGenerator(ScholarshipList, StudentData);
        final String MatchingRepoFile3 = MatchingRepo3.writeToFile();

        try {
            new GMailer().sendMail("Matching Report", "Here is the Matching Report", new File(MatchingRepoFile3), EmailAddress);
            System.out.println("Matching Report Sent! Please check your email inbox");
            System.out.println("Test 10 passed");
        } catch (Exception a) {
            System.out.println("Matching Report NOT Sent.");
            System.out.println("Test 10 Failed");
            System.out.println(a.getMessage());
        }

        ScholarshipList = new ArrayList<Scholarship>(); // reset for new test

        //----------------------------------------------------------------------------------------------------------------------------------------------/
    
        
    }
}
