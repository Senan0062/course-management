package org.example.course.erp.students.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.request.StudentCreateRequest;
import org.example.course.erp.students.entity.StudentEntity;
import org.example.course.erp.students.mapper.StudentMapper;
import org.example.course.erp.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Transactional
public class StudentCreateService {
    StudentRepository repository;
    StudentMapper mapper;

    public EntityById create(StudentCreateRequest request) {
        StudentEntity entity = mapper.toEntity(request);
        entity.setStatus("A");
        entity.setCreatedDate(LocalDateTime.now());
        repository.save(entity);

        return mapper.toEntityById(entity);
    }
}
