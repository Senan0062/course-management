package org.example.course.erp.lessons.repository;

import org.example.course.erp.lessons.dto.response.LessonReadResponse;
import org.example.course.erp.lessons.dto.response.LessonResponse;
import org.example.course.erp.lessons.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("""
            select new org.example.course.erp.lessons.dto.response.LessonReadResponse(
                l.id,
                l.title,
                l.description,
                t.firstName || ' ' || t.lastName)
                from Lesson l
                join Teacher t on l.fkTeacherId = t.id
                where l.id = :id
            """)
    LessonReadResponse findTeacher(Long id);

    @Query("""
            select new org.example.course.erp.lessons.dto.response.LessonReadResponse(
                l.id,
                l.title,
                l.description,
                t.firstName || ' ' || t.lastName)
                from Lesson l
                join Teacher t on l.fkTeacherId = t.id
            """)
    List<LessonReadResponse> findLessons();
}

