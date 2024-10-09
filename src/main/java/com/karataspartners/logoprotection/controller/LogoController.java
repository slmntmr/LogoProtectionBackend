package com.karataspartners.logoprotection.controller;
// `controller` paketi içinde logo işlemlerini yönetecek olan REST API controller sınıfını tanımlıyoruz.


// Logo işlemlerinde kullanılacak olan `Logo` entity'sini içe aktarıyoruz.


// Logo işlemleri için `LogoService`'i içe aktarıyoruz.

import com.karataspartners.logoprotection.entity.Logo;
import com.karataspartners.logoprotection.service.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// REST API oluşturmak için Spring'in HTTP ve `RestController` anotasyonlarını içe aktarıyoruz.

import java.util.List;
// Kullanıcının logolarını listelemek için `List` sınıfını içe aktarıyoruz.

@RestController
@RequestMapping("/api/logos")
// `@RestController`: Bu sınıfın bir REST API olduğunu belirtir.
// `@RequestMapping("/api/logos")`: Tüm logo işlemleri `/api/logos` altında erişilebilir.
public class LogoController {

    private final LogoService logoService;
    // Logo işlemleri için gerekli olan servis sınıfının bir örneği.

    @Autowired
    // `@Autowired`: Spring, `LogoService`'i otomatik olarak enjekte eder.
    public LogoController(LogoService logoService) {
        this.logoService = logoService;
    }

    @PostMapping("/upload")
    // `@PostMapping`: HTTP POST isteği ile logo yükler.
    public ResponseEntity<Logo> uploadLogo(@RequestBody Logo logo) {
        // Logo kaydetmek için servis metodunu çağırıyoruz.
        Logo uploadedLogo = logoService.uploadLogo(logo);
        // Yüklenen logoyu geri döndürüyoruz.
        return ResponseEntity.ok(uploadedLogo);
    }

    @GetMapping("/user/{userId}")
    // `@GetMapping`: HTTP GET isteği ile bir kullanıcının tüm logolarını bulur.
    public ResponseEntity<List<Logo>> getLogosByUserId(@PathVariable Long userId) {
        // Kullanıcıya ait logoları bulmak için servis metodunu çağırıyoruz.
        List<Logo> logos = logoService.findLogosByUserId(userId);
        // Bulunan logoları geri döndürüyoruz.
        return ResponseEntity.ok(logos);
    }
}
