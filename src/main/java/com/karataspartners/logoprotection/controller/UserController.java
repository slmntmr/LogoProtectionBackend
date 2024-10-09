package com.karataspartners.logoprotection.controller;
// `controller` paketi içinde kullanıcı işlemlerini yönetecek olan REST API controller sınıfını tanımlıyoruz.


// Kullanıcı işlemlerinde kullanılacak olan `User` entity'sini içe aktarıyoruz.


// Kullanıcı işlemleri için `UserService`'i içe aktarıyoruz.

import com.karataspartners.logoprotection.entity.User;
import com.karataspartners.logoprotection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// REST API oluşturmak için Spring'in HTTP ve `RestController` anotasyonlarını içe aktarıyoruz.

@RestController
@RequestMapping("/api/users")
// `@RestController`: Bu sınıfın bir REST API olduğunu belirtir.
// `@RequestMapping("/api/users")`: Tüm kullanıcı işlemleri `/api/users` altında erişilebilir.

public class UserController {

    private final UserService userService;
    // Kullanıcı işlemleri için gerekli olan servis sınıfının bir örneği.

    @Autowired
    // `@Autowired`: Spring, `UserService`'i otomatik olarak enjekte eder.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    // `@PostMapping`: HTTP POST isteği ile kullanıcı kaydı oluşturur.
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Kullanıcı kaydetmek için servis metodunu çağırıyoruz.
        User registeredUser = userService.registerUser(user);
        // Kaydedilen kullanıcı bilgilerini geri döndürüyoruz.
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/{email}")
    // `@GetMapping`: HTTP GET isteği ile email'e göre kullanıcıyı bulur.
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        // Email adresi ile kullanıcıyı bulmak için servis metodunu çağırıyoruz.
        User user = userService.findByEmail(email);
        // Bulunan kullanıcıyı geri döndürüyoruz.
        return ResponseEntity.ok(user);
    }
}
