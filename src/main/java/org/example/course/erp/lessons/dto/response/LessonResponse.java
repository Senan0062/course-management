package org.example.course.erp.lessons.dto.response;

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
public class LessonResponse {
    private Long id;
    private String title;
    private String description;
    private Long teacherId;
}
