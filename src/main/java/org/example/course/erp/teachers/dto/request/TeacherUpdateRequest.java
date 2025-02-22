package org.example.course.erp.teachers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
public class TeacherUpdateRequest {
    @NotNull(message = "Id boş ola bilməz!")
    Long id;
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;
    String speciality;
    Long teachingHours;
}
