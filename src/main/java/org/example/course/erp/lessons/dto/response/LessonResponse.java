package org.example.course.erp.lessons.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LessonResponse {
    private Long id;
    private String title;
    private String description;
    private Long fkTeacherId;
}
