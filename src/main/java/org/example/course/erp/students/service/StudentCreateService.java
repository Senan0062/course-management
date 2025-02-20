package org.example.course.erp.students.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.students.dto.StudentCreateRequest;
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

        StudentEntity entity = new StudentEntity();
        entity.setCreatedAt(LocalDateTime.now());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setAge(request.getAge());
        entity.setBirthDate(request.getBirthDate());
        entity.setFkClassId(request.getFkClassId());
        entity.setFkGroupId(request.getFkGroupId());
        entity.setPhoneNumber(String.valueOf(request.getPhoneNumber()));
        entity.setStatus("A");
        repository.save(entity);

//        if (repository.findByFirstNameAndLastNameAndEmail(request.getFirstName(), request.getLastName(), request.getEmail()).isEmpty()) {
//            throw new RuntimeException("Student already exists");
//        }
//        StudentEntity entity = mapper.createRequestToEntity(request);
//        repository.save(entity);
//        return EntityById.builder()
//                .id(entity.getId())
//                .build();
        return EntityById.builder()
                .id(entity.getId())
                .build();
    }
}
