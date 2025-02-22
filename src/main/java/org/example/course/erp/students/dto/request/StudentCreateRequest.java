package org.example.course.erp.students.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;
    LocalDate birthDate;
    Long age;
    Long fkClassId;
    Long fkGroupId;
}
