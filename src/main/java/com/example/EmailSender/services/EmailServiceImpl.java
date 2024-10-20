package com.example.EmailSender.services;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;



@Service
public class EmailServiceImpl implements  EmailServices{

  private JavaMailSender mailSender;


  public EmailServiceImpl(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void sendEmail(String to, String subject, String message) {

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(to);
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(message);
     this.mailSender.send(simpleMailMessage);
    System.out.println("message  has been send");

  }

  @Override
  public void sendEmail(String[] to, String subject, String content) {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(to);
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(content);
     this.mailSender.send(simpleMailMessage);
    System.out.println("message has beeen send");
  }

  @Override
  public void sendEmailWithHtml(String to, String subject, String htmlContent) throws MessagingException {
    MimeMessage mimeMessage = this.mailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
    mimeMessageHelper.setTo(to);
    mimeMessageHelper.setSubject(subject);
    mimeMessageHelper.setText(htmlContent,true);
    this.mailSender.send(mimeMessage);
    System.out.println("message send sucessfully");
  }

  @Override
  public void sendEmailWithFiles(String to, String subject, String message, File file) {
    MimeMessage mimeMessage = this.mailSender.createMimeMessage();
    try {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
      mimeMessageHelper.setTo(to);
      mimeMessageHelper.setSubject(subject);
      mimeMessageHelper.setText(message);
      FileSystemResource fileSystemResource = new FileSystemResource(file);
      mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),file);
      this.mailSender.send(mimeMessage);
      System.out.println("file send successfully");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }
}
