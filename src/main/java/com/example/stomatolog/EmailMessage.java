package com.example.stomatolog;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailMessage extends Thread   {
     private static String from = "380637541873.a.9@gmail.com";
     private static String to = "aaaaaandrej3@gmail.com";
     private static String host = "smtp.gmail.com";
     private static String port = "587";
    public void message (String name, String number) {


        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "rlewpdzpjheaurtr");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(name);
            message.setText(number);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }




    }
}

