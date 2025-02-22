package org.example.course.erp.scores.mapper;

import org.example.course.erp.scores.dto.request.ScoreCreateRequest;
import org.example.course.erp.scores.dto.response.ScoreResponse;
import org.example.course.erp.scores.entity.Score;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScoreMapper {

    Score toEntity(ScoreCreateRequest request);

    ScoreResponse toReadResponse(Score score);

    List<ScoreResponse> entityToReadResponse(List<Score> score);
}
