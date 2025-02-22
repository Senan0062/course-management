package org.example.course.erp.teachers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TeacherCreateRequest {
    @NotBlank(message = "Ad boş ola bilməz!")
    String firstName;
    @NotBlank(message = "Soyad boş ola bilməz!")
    String lastName;
    @NotBlank(message = "Email boş ola bilməz!")
    String email;
    @NotNull(message = "Əlaqə nömrəsi boş ola bilməz!")
    Long phoneNumber;
    @NotNull(message = "Doğum tarixi boş ola bilməz!")
    LocalDate birthDate;
    @NotBlank(message = "Status boş ola bilməz!")
    String speciality;
    @NotNull(message = "Dərs saatı ola bilməz!")
    Long teachingHours;
    @NotBlank(message = "Cins boş ola bilməz!")
    String gender;
}
