package org.example.course.erp.lessons.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.course.erp.lessons.dto.request.LessonCreateRequest;
import org.example.course.erp.lessons.dto.request.LessonUpdateRequest;
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

    public LessonResponse createLesson(LessonCreateRequest request) {
        Lesson lesson = lessonMapper.toEntity(request);
        return lessonMapper.toResponse(lessonRepository.save(lesson));
    }

    public List<LessonResponse> getAllLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(lessonMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LessonResponse getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        return lessonMapper.toResponse(lesson);
    }

    public LessonResponse updateLesson(Long id, LessonUpdateRequest request) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        lessonMapper.updateEntity(lesson, request);
        return lessonMapper.toResponse(lessonRepository.save(lesson));
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
