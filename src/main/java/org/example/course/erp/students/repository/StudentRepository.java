package org.example.course.erp.students.repository;

import org.example.course.erp.students.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String>, JpaSpecificationExecutor<StudentEntity> {

    Optional<StudentEntity> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
