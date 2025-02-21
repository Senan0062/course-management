package org.example.course.erp.students.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StudentUpdateRequest {
    @NotNull(message = "id is required")
    Long id;
    String firstName;
    String lastName;
    String email;
    String birthDate;
    Long age;
    Long phoneNumber;
    Long fkClassId;
    Long fkGroupId;
}
