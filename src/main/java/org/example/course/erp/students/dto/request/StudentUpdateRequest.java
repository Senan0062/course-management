package org.example.course.erp.students.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    LocalDate birthDate;
    Long age;
    Long phoneNumber;
    Long fkClassId;
    Long fkGroupId;
}
