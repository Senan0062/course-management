package org.example.course.erp.students.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.entity.Student;
import org.example.course.erp.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class StudentDeleteService {
    StudentRepository repository;

    public boolean delete(EntityById dto) {
        Student entity = repository.findByIdAndStatus(dto.getId(), "A");
        if (entity == null) {
//            throw new ResourceNotFoundException("Student not found");
            return false;
        } else {
            entity.setStatus("D");
            repository.save(entity);
        }
        return true;
    }
}
