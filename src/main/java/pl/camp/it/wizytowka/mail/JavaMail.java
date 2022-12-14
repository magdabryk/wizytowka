package pl.camp.it.wizytowka.mail;

import org.springframework.stereotype.Component;
import pl.camp.it.wizytowka.model.Mail;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class JavaMail {


   public void sendMail(Mail mail) throws MessagingException {
       Properties properties = new Properties();
       properties.setProperty("mail.transport.protocol", "smtp");
       properties.setProperty("mail.host", "smtp.poczta.onet.pl");
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.smtp.starttls", "true");
       properties.put("mail.smtp.host", "smtp.poczta.onet.pl");
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.ssl.trust", "*");



       String myAccountEmail = "javabryk@op.pl";
       String password = "Ad123456";

       Session session = Session.getInstance(properties,
               new javax.mail.Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(myAccountEmail, password);
                   }
               });

       Message message = prepareMessage(session, myAccountEmail, mail);
       Transport.send(message);
       System.out.println("wiadomosc wyslana");
   }
   private  Message prepareMessage(Session session, String myAccountEmail, Mail mail)  {
       Message message = new MimeMessage(session);
       try {
           message.setFrom(new InternetAddress(myAccountEmail));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(myAccountEmail));
           message.setSubject("Wiadomość ze strony od " + mail.getName() + " " + mail.getSurname());
           message.setText(mail.getMailContent());
           return message;
       } catch (MessagingException e) {
           throw new RuntimeException(e);
       }

   }
}
