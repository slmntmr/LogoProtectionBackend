package com.karataspartners.logoprotection.service;
// `service` paketi içinde logo işlemlerini yönetecek olan servis sınıfını tanımlıyoruz.


// Logo işlemlerinde kullanılacak olan `Logo` entity'sini içe aktarıyoruz.


// Veritabanı işlemleri için `LogoRepository`'yi içe aktarıyoruz.

import com.karataspartners.logoprotection.entity.Logo;
import com.karataspartners.logoprotection.repository.LogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Spring'in `Service` ve `Autowired` anotasyonlarını kullanarak bağımlılık enjeksiyonu yapıyoruz.

import java.util.List;
// Kullanıcının logolarını listelemek için `List` sınıfını içe aktarıyoruz.

@Service
// `@Service` anotasyonu, bu sınıfın bir servis bileşeni olduğunu belirtir.
public class LogoService {

    private final LogoRepository logoRepository;
    // Logo işlemleri için gerekli olan repository'nin bir örneği.

    @Autowired
    // `@Autowired`: Spring, `LogoRepository`'yi otomatik olarak enjekte eder.
    public LogoService(LogoRepository logoRepository) {
        this.logoRepository = logoRepository;
    }

    public Logo uploadLogo(Logo logo) {
        // Logoyu yüklemek için bir metod. Veritabanına kaydedilen logoyu döner.
        return logoRepository.save(logo);
    }

    public List<Logo> findLogosByUserId(Long userId) {
        // Kullanıcının logolarını bulmak için bir metod.
        return logoRepository.findByUserId(userId);
    }
}
