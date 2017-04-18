/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.waterdistributionsystem.model;

/**
 * @author Andre Luis Sabino
 * @version 1.2
 * @since 12/04/2017
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/* Classe e Construtor criados para envio de e-mail a partir de template base de código encontrado no stackoverflow
http://stackoverflow.com/questions/3649014/send-email-using-java by Gayathri Rajan
*/
public class MailSender {

    final String senderEmailID = "sabinoandreluis@gmail.com";
    final String senderPassword = "Moroni2015";
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "465";
    private String receiverEmailID = null;
    private String emailSubject = "";
    private String emailBody = "";

    public MailSender(String receiverEmailID, String emailSubject, String emailBody) {
        this.receiverEmailID = receiverEmailID;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        Properties props = new Properties();
        props.put("mail.smtp.user", senderEmailID);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SecurityManager security = System.getSecurityManager();
        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(emailBody);
            msg.setSubject(emailSubject);
            msg.setFrom(new InternetAddress(senderEmailID));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiverEmailID));
            Transport.send(msg);
            System.out.println("Message send Successfully:)");
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

    public class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailID, senderPassword);
        }
    }

    public String getReceiverEmailID() {
        return receiverEmailID;
    }

    public void setReceiverEmailID(String receiverEmailID) {
        this.receiverEmailID = receiverEmailID;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

}
