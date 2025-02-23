package org.example.course.erp.scores.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCreateRequest {
    Long studentId;
    Long lessonId;
    String examType;
    Double score;
    LocalDateTime examDate;
}
