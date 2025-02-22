package org.example.course.erp.lessons.repository;

import org.example.course.erp.lessons.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}

