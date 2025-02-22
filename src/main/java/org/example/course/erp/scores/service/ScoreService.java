package org.example.course.erp.scores.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.course.core.dto.user.EntityById;
import org.example.course.erp.scores.dto.request.ScoreCreateRequest;
import org.example.course.erp.scores.dto.response.ScoreResponse;
import org.example.course.erp.scores.entity.Score;
import org.example.course.erp.scores.mapper.ScoreMapper;
import org.example.course.erp.scores.repository.ScoreRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final ScoreMapper scoreMapper;

    public EntityById addScore(ScoreCreateRequest request) {
        Score score = scoreMapper.toEntity(request);
        return EntityById.builder().id(scoreRepository.save(score).getId()).build();
    }

    public List<ScoreResponse> getAllScores() {
        List<Score> scores = scoreRepository.findAll();
        List<ScoreResponse> responses = scoreMapper.entityToReadResponse(scores);
        return responses != null ? responses : Collections.emptyList();
    }

    public ScoreResponse getScoreById(Long id) {
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Score not found"));
        return scoreMapper.toReadResponse(score);
    }

    public Double getAverageScore(Long studentId, Long lessonId) {
        return scoreRepository.findAverageScore(studentId, lessonId);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

}
