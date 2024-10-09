package com.karataspartners.logoprotection.service;
// `service` paketi içinde kullanıcı işlemlerini yönetecek olan servis sınıfını tanımlıyoruz.


// Kullanıcı işlemlerinde kullanılacak olan `User` entity'sini içe aktarıyoruz.


// Veritabanı işlemleri için `UserRepository`'yi içe aktarıyoruz.

import com.karataspartners.logoprotection.entity.User;
import com.karataspartners.logoprotection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Spring'in `Service` ve `Autowired` anotasyonlarını kullanarak bağımlılık enjeksiyonu yapıyoruz.

@Service
// `@Service` anotasyonu, bu sınıfın bir servis bileşeni olduğunu belirtir.
public class UserService {

    private final UserRepository userRepository;
    // Kullanıcı işlemleri için gerekli olan repository'nin bir örneği.

    @Autowired
    // `@Autowired`: Spring, `UserRepository`'yi otomatik olarak enjekte eder.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Kullanıcıyı kaydetmek için bir metod. Veritabanına kaydedilen kullanıcıyı döner.
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        // Email adresi ile kullanıcıyı bulmak için bir metod.
        return userRepository.findByEmail(email);
    }
}
