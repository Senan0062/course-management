package org.example.course.core.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@FieldDefaults(makeFinal = true ,level = lombok.AccessLevel.PRIVATE)
public class EntityById {
    @NotNull(message = "Id cannot be null")
    Long id;
}
