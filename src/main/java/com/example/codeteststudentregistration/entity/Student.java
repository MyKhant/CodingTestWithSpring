package com.example.codeteststudentregistration.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="studentRegistration")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    private Integer id;

    @Column
    @Nonnull
    private String name;

    @Column
    @Nonnull
    private int age;

    @Column
    @Nonnull
    private String course;

    @Column
    @Nonnull
    private String gender;

    @Column
    @Nonnull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column
    @Nonnull
    private String address;


}