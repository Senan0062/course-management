package org.example.course.erp.lessons.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LessonReadResponse {
    Long id;
    String title;
    String description;
    String fkTeacherId;
}
