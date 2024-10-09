package com.karataspartners.logoprotection.entity;
// `entity` paketine ait bir sınıf olan `Logo`, logoları temsil eden veritabanı tablosunu tanımlar.

import jakarta.persistence.*;
// JPA kütüphanelerini kullanarak veritabanı ilişkilerini tanımlamak için gerekli import işlemleri.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Lombok kütüphanesini kullanarak `Logo` sınıfına gerekli constructor, getter ve setter metodlarını ekleriz.

@Entity
// `@Entity` anotasyonu, bu sınıfın bir veritabanı tablosuna karşılık geldiğini belirtir.
@Data
// Lombok'un tüm getter, setter, toString gibi metodlarını otomatik oluşturmasını sağlar.
@NoArgsConstructor
// Parametresiz constructor sağlar.
@AllArgsConstructor
// Tüm alanları içeren bir constructor sağlar.
public class Logo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Bu alan, veritabanında birincil anahtar (ID) olarak kullanılacak ve otomatik olarak artırılacak.
    private Long id;

    @Column(nullable = false)
    // Logonun adı boş olamaz.
    private String logoName;

    @Column(nullable = false)
    // Logonun URL'si boş olamaz. Bu URL logonun nerede saklandığını gösterir.
    private String logoUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    // Her bir logo bir kullanıcıya ait olur. `@ManyToOne` ilişkisi tanımlanıyor.
    // `@JoinColumn(name = "user_id")`: Bu ilişki, `user_id` adlı bir dış anahtar (foreign key) ile bağlanır.
    private User user; // Logo bir kullanıcıya ait olmalıdır.
}
