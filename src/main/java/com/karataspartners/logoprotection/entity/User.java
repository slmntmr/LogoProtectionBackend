package com.karataspartners.logoprotection.entity;
// `entity` paketinin altında, veritabanındaki kullanıcı tablosunu temsil eden `User` sınıfı oluşturuluyor.

import jakarta.persistence.*;
// JPA (Java Persistence API) anotasyonlarını kullanmak için gerekli kütüphaneleri içe aktarıyoruz.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// `Lombok` kütüphanesi ile `Data`, `NoArgsConstructor` ve `AllArgsConstructor` anotasyonlarını ekleyerek boilerplate kodlardan kurtuluyoruz.
// Bu anotasyonlar otomatik getter, setter, constructor gibi metodları oluşturur.

import java.util.Set;
// Kullanıcı ile logolar arasında bir ilişki tanımlamak için `Set` kullanacağız.

@Entity
@Table(name = "app_user") // Tablo adını değiştiriyoruz
// `@Entity` anotasyonu, bu sınıfın bir veritabanı tablosuna karşılık geldiğini belirtir.
@Data
// `@Data`, Lombok'un tüm getter, setter, toString, equals ve hashCode metodlarını otomatik oluşturmasını sağlar.
@NoArgsConstructor
// Parametresiz bir constructor oluşturur.
@AllArgsConstructor
// Tüm alanları içeren bir constructor oluşturur.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // `@Id`: Bu alan veritabanında birincil anahtar olduğunu belirtir.
    // `@GeneratedValue`: ID alanının otomatik olarak üretilmesini sağlar (AUTO_INCREMENT).
    private Long id;

    @Column(nullable = false)
    // Bu alanın boş olmaması gerektiğini belirtir.
    private String firstName;

    @Column(nullable = false)
    // Kullanıcının soyadı boş olmamalı.
    private String lastName;

    @Column(nullable = false, unique = true)
    // Email alanı benzersiz ve boş olamaz.
    private String email;

    @Column(nullable = false)
    // Kullanıcının şifre alanı boş olamaz.
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Bir kullanıcı birden fazla logoya sahip olabilir. `@OneToMany` ilişkisi tanımlanıyor.
    // `cascade = CascadeType.ALL`: Kullanıcı silindiğinde, ilişkili logolar da silinir.
    // `fetch = FetchType.LAZY`: Logolar yalnızca gerektiğinde yüklenir.
    private Set<Logo> logos; // Bir kullanıcının sahip olduğu logolar.
}
