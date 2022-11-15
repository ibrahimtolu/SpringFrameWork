package com.ibrahim.test.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DbUsers")
public class User extends BaseEntity {
     @Id
     @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_seq")
     @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "user_seq_gen")

     @Column(name = "ID",unique = true)
    private  Long id;
     @Column(name="firstname")

     private String ad;
     @Column(name="lastname")
    private  String soyad;
     @Column(name = "yas")
    private  String yas;

}
