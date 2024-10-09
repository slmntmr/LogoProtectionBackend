package com.karataspartners.logoprotection.repository;
// `repository` paketi içinde logolarla ilgili veritabanı işlemlerini yönetecek olan repository sınıfını tanımlıyoruz.


// `Logo` entity'sini içe aktarıyoruz, çünkü bu sınıf veritabanı işlemlerinde kullanılacak.

import com.karataspartners.logoprotection.entity.Logo;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA repository sınıfını kullanarak veritabanı işlemlerini otomatik hale getiriyoruz.

import java.util.List;
// Kullanıcıların sahip olduğu logoları listelemek için `List` sınıfını içe aktarıyoruz.

public interface LogoRepository extends JpaRepository<Logo, Long> {
    // `JpaRepository`'yi genişleterek `Logo` entity'si için CRUD işlemlerini sağlıyoruz.

    List<Logo> findByUserId(Long userId);
    // Belirli bir kullanıcıya ait logoları bulmak için özel bir metod tanımlıyoruz.
    // Bu metod, kullanıcı ID'sine göre logoları döndürecek.
}
