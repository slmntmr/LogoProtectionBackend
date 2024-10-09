package com.karataspartners.logoprotection.service;

import com.karataspartners.logoprotection.dto.TrademarkApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendTrademarkApplicationEmail(TrademarkApplicationRequest request) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("slmn1905tmr@gmail.com");
        message.setSubject("Yeni Marka Başvurusu");

        // E-posta içeriği
        String mailContent = "İsim: " + request.getFirstName() + " " + request.getLastName() + "\n" +
                "E-posta: " + request.getEmail() + "\n" +
                "Logo: " + request.getLogoName() + "\n" +
                "Başvuru Detayları: " + request.getApplicationDetails();
        message.setText(mailContent);

        // E-postayı gönder
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new Exception("E-posta gönderilirken bir hata oluştu: " + e.getMessage());
        }
    }
}
