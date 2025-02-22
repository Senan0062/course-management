package org.example.course.erp.teachers.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "created_date")
    LocalDateTime createdDate;
    @Column(name = "modification_date")
    LocalDateTime modificationDate;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email")
    String email;
    @Column(name = "birth_date")
    LocalDate birthDate;
    @Column(name = "status")
    String status;
    @Column(name = "speciality")
    String speciality;
    @Column(name = "teaching_hours")
    Long teachingHours;
    @Column(name = "gender")
    String gender;
    @Column(name = "phone_number")
    Long phoneNumber;
}
