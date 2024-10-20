package com.example.EmailSender.services;

import jakarta.mail.MessagingException;
import java.io.File;

public interface EmailServices {


    // send email to single user
     public void sendEmail(String to,String subject,String message);


     // send email to multiple user
     public  void sendEmail(String to[],String subject,String content);

     // sending email  using html template


    public  void sendEmailWithHtml(String to,String subject, String htmlContent) throws MessagingException;

    // sending emails with files

    public  void sendEmailWithFiles(String to,String subject,String message, File file);
}
