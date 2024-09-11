/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email;

import domen.Dobavljac;
import domen.Porudzbenica;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Mina
 */
public class Sender {

    private static Sender instanca;
    public Session session;

    private Sender() {
        Properties prop = new Properties();

        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("softverimina@gmail.com", "xftfvqvhqlwmvxxe");

            }

        });
    }

    public static Sender getInstanca() {
        if (instanca == null) {
            instanca = new Sender();
        }
        return instanca;
    }

    public void posaljiEmail(Porudzbenica p, File file) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        String poruka = this.generisiHtmlPoruku(p);
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("no-reply@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(p.getDobavljac().getEmailDobavljaca()));
        message.setSubject("Porudzbenica-"+p.getSifraPorudzbenice());
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(poruka, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile(file);

        multipart.addBodyPart(attachPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Email poruka poslata korisniku: " + p.getDobavljac().getEmailDobavljaca());

    }

    private String generisiHtmlPoruku(Porudzbenica p) {
        Dobavljac d = p.getDobavljac();
        return "Postovani " + d.toString() + " <br/> U prilogu Vam saljemo porudzbenicu sa rednim brojem " + p.getSifraPorudzbenice() + " ciji je status konacan. <hr/> Pozdrav, <br/> Vasa Palada";
    }

}
