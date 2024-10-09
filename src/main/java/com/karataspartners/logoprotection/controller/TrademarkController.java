package com.karataspartners.logoprotection.controller;

import com.karataspartners.logoprotection.dto.TrademarkApplicationRequest;
import com.karataspartners.logoprotection.service.EmailService;
import com.karataspartners.logoprotection.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/trademark")
public class TrademarkController {

    private final EmailService emailService;
    private final FileStorageService fileStorageService;

    @Autowired
    public TrademarkController(EmailService emailService, FileStorageService fileStorageService) {
        this.emailService = emailService;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(value = "/apply", consumes = {"multipart/form-data"})
    public ResponseEntity<String> applyForTrademark(
            @RequestPart("file") MultipartFile file,
            @RequestPart("application") TrademarkApplicationRequest request) {
        try {
            // Logoyu kaydet
            String filePath = fileStorageService.saveFile(file);
            request.setLogoName(filePath);

            // E-postayı gönder
            emailService.sendTrademarkApplicationEmail(request);

            return ResponseEntity.ok("Başvurunuz başarıyla alındı.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Başvuru sırasında bir hata oluştu: " + e.getMessage());
        }
    }
}
