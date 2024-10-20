package com.example.EmailSender.controller;


import com.example.EmailSender.dto.EmailDetails;
import com.example.EmailSender.services.EmailServices;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmailController {



   private EmailServices services



   @PostMapping("/sendHtmlEmail")
     public ResponseEntity<?> sendEmailWithHtml(@RequestBody EmailDetails details){
     try {
        this.services.sendEmailWithHtml(details.getTo(),details.getSubject(),details.getMessage());
       return new ResponseEntity.ok();
     } catch (MessagingException e) {
       throw new RuntimeException(e);
     }
     }
}
