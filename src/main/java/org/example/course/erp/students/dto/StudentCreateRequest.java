package org.example.course.erp.students.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class StudentCreateRequest {
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;
    LocalDate birthDate;
    String status;
    Long age;
    Long fkClassId;
    Long fkGroupId;
}
