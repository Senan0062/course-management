package org.example.course.erp.teachers.repository;

import org.example.course.erp.teachers.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, String>, JpaSpecificationExecutor<TeacherEntity> {

    TeacherEntity findByIdAndStatus(Long id, String status);

}
