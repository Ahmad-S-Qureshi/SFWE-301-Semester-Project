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
        ArrayList<Scholarship> AnnualRepoData = new ArrayList<Scholarship>();
        
        // Annual Report Test 1
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

        // Annual Report Test 2
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
    }
}
