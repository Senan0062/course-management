package org.example.course.erp.scores.repository;

import org.example.course.erp.scores.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT AVG(s.score) FROM Score s WHERE s.studentId = :studentId AND s.lessonId = :lessonId")
    Double findAverageScore(@Param("studentId") Long studentId, @Param("lessonId") Long lessonId);
}
