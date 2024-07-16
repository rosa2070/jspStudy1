package com.exam.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
   private String fromEmail;
   private String fromPassword;
   
   public MailSender() {
      this.fromEmail = "rosa207061@gmail.com"; //지메일 주소
      this.fromPassword = "msmtglbwhnlprfyt"; // 앱 비밀번호(16)
   }
   
   public void sendMail(String toEmail, String toName, String subject, String content) {
      
      try {
      Properties props = new Properties();
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "465");
      props.put("mail.smtp.auth", "true");
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      
      MyAuthenticator authenicator = new MyAuthenticator(fromEmail, fromPassword);
      Session session = Session.getDefaultInstance(props, authenicator);
      
      // 메세지
      MimeMessage msg = new MimeMessage(session);
      
      
         msg.setHeader("Content-Type", "text/html;charset=utf-8");
         msg.addRecipient(Message.RecipientType.TO , new InternetAddress(toEmail, toName, "utf-8" ) ) ;
         msg.setSubject(subject);
         msg.setContent(content,"text/html;charset=utf-8");
         
         msg.setSentDate(new java.util.Date());
         
         Transport.send(msg);
         
         System.out.println("메일 전송 완료");
      } catch (UnsupportedEncodingException e) {
         // TODO Auto-generated catch block
         System.out.println("[에러]" + e.getMessage());
      } catch (MessagingException e) {
         // TODO Auto-generated catch block
         System.out.println("[에러]" + e.getMessage());
      }
      
   }
}
