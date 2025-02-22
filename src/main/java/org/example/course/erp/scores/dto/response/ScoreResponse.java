package org.example.course.erp.scores.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ScoreResponse {
    private Long id;
    private Long studentId;
    private Long lessonId;
    private String examType;
    private Double score;
}
