package com.moon.trackingsystem.service;



import com.moon.trackingsystem.entity.SendEmailModel;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@Service
public class SendEmail {
    public void sendEmail( SendEmailModel email) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("projectmanagement747@gmail.com", "6230064227");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("projectmanagement747@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
        msg.setSubject(email.getSubject());
        msg.setContent(email.getDescription(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(email.getDescription(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();

        //attachPart.attachFile("/var/tmp/image19.png");
        //multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);

        System.out.println("sendnnnnnnnnnnnnnnnnnn");
    }

}
