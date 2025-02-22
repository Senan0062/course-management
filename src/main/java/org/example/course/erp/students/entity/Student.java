package org.example.course.erp.students.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
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
    @Column(name = "birth_date")
    LocalDate birthDate;
    @Column(name = "email")
    String email;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "status")
    String status;
    @Column(name = "age")
    Long age;
    @Column(name = "fk_class_id")
    Long fkClassId;
    @Column(name = "fk_group_id")
    Long fkGroupId;

}
