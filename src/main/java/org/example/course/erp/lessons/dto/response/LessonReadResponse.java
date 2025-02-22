package org.example.course.erp.lessons.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class LessonReadResponse {
    Long id;
    String title;
    String description;
    String fkTeacherId;
}
