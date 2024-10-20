package com.example.EmailSender.test;


import com.example.EmailSender.services.EmailServices;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EmailSenderTest {


  @Autowired
  private EmailServices services;


//   @Test
//    public  void sendEmail(){
//     services.sendEmail("dasrobert11@gmail.com","dummy message","this is message is for the testing purpose");
//      System.out.println("email send sucessfully");
//    }


  // sending mail to multiple user

//  @Test
//  public void sendEmail() {
//    String[] to = {"dasrobert11@gmail.com,", "teresadipti@gmail.com"};
//    this.services.sendEmail(to, "dummy message", "this is a dummy message");
//    System.out.println("message send sucessfully");
//  }




  // sending html content through email


//  @Test
//   public  void sendEmail() throws MessagingException {
//       String html = "<html>" +
//         "<body>" +
//         "<h1>This is the heading tag</h1>" +
//         "" +
//         "</body>" +
//         "</html>";
//
//
//       this.services.sendEmailWithHtml("dasrobert11@gmail.com","html content",html);
//     System.out.println("message send successfully");
//   }



   // sending attachment with email

   @Test
   public  void sendEmail(){
      this.services.sendEmailWithFiles("dasrobert11@gmail.com",
        "attachment data",
        "this is the attchment send by the email sender application",
        new File("D:\\EmailSender\\EmailSender\\EmailSender\\src\\main\\resources\\static\\images\\StudentService.PNG"));
   }


}
