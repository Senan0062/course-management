package org.example.course.erp.lessons.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.lessons.dto.request.LessonCreateRequest;
import org.example.course.erp.lessons.dto.request.LessonUpdateRequest;
import org.example.course.erp.lessons.dto.response.LessonReadResponse;
import org.example.course.erp.lessons.dto.response.LessonResponse;
import org.example.course.erp.lessons.entity.Lesson;
import org.example.course.erp.lessons.mapper.LessonMapper;
import org.example.course.erp.lessons.repository.LessonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    public EntityById createLesson(LessonCreateRequest request) {
        Lesson lesson = lessonMapper.toEntity(request);
        lesson.setCreatedDate(LocalDateTime.now());
        return EntityById.builder()
                .id(lessonRepository.save(lesson).getId())
                .build();
    }

    public List<LessonReadResponse> getAllLessons() {
        return lessonRepository.findLessons()
                .stream()
                .toList();
    }

    public LessonReadResponse getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        return lessonRepository.findTeacher(id);
    }

    public EntityById updateLesson(Long id, LessonUpdateRequest request) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        lessonMapper.updateEntity(lesson, request);
        return EntityById.builder()
                .id(lessonRepository.save(lesson).getId())
                .build();
    }

    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Lesson not found");
        }
        lessonRepository.deleteById(id);
    }
}
