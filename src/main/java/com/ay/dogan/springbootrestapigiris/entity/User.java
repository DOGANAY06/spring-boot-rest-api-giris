package com.ay.dogan.springbootrestapigiris.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="kullanicilar")
@Data //ile getter setter direk kendiliğinden oluşuyor
public class User extends BaseEntity{ //user tablomuz veritabanında ki
    @Id   //anatotaions
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 1)
    //100 den başlasın 1 er 1 er arsın
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen") //artırma özelliği
    @Column(name = "ID")
    private  Long id;
    @Column(name = "ISIM",length = 100)
    private  String firstName;
    @Column(name = "SOYISIM",length = 100)

    private String lastName;
}