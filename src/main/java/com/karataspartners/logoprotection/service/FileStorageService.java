package com.karataspartners.logoprotection.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final String UPLOAD_DIR = "uploaded-logos/";  // Dosya kaydedilecek dizin

    public String saveFile(MultipartFile file) throws IOException {
        try {
            // Proje kök dizininde dosya yolunu oluştur
            String filePath = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR, file.getOriginalFilename()).toString();
            File dest = new File(filePath);

            // Klasör mevcut değilse oluştur
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            // Dosyayı kaydet
            file.transferTo(dest);
            return filePath;

        } catch (IOException e) {
            throw new IOException("Dosya kaydedilirken bir hata oluştu: " + e.getMessage());
        }
    }
}
