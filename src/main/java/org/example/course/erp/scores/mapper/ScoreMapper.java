package org.example.course.erp.scores.mapper;

import org.example.course.erp.scores.dto.request.ScoreCreateRequest;
import org.example.course.erp.scores.dto.response.ScoreResponse;
import org.example.course.erp.scores.entity.Score;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoreMapper {
    Score toEntity(ScoreCreateRequest request);

    ScoreResponse toResponse(Score entity);
}
