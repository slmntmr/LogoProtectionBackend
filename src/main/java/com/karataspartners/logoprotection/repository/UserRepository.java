package com.karataspartners.logoprotection.repository;
// `repository` paketi içinde kullanıcılarla ilgili veritabanı işlemlerini yönetecek olan repository sınıfını tanımlıyoruz.


// `User` entity'sini içe aktarıyoruz, çünkü bu sınıf veritabanı işlemlerinde kullanılacak.

import com.karataspartners.logoprotection.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA repository sınıfını kullanarak veritabanı işlemlerini otomatik hale getiriyoruz.

public interface UserRepository extends JpaRepository<User, Long> {
    // `JpaRepository`'yi genişleterek `User` entity'si için CRUD işlemlerini sağlıyoruz.
    // `Long` veri tipi, `User` entity'sindeki ID alanının veri tipi.

    User findByEmail(String email);
    // Email ile kullanıcıyı bulmak için özel bir metod tanımlıyoruz.
    // Bu metod, kullanıcının email adresine göre bir kullanıcı döndürecek.
}
