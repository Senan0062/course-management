package org.example.course.erp.scores.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
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

    public ScoreResponse addScore(ScoreCreateRequest request) {
        Score score = scoreMapper.toEntity(request);
        return scoreMapper.toResponse(scoreRepository.save(score));
    }

    public List<ScoreResponse> getAllScores() {
        return scoreRepository.findAll()
                .stream()
                .map(scoreMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ScoreResponse getScoreById(Long id) {
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Score not found"));
        return scoreMapper.toResponse(score);
    }

    public Double getAverageScore(Long studentId, Long lessonId) {
        return scoreRepository.findAverageScore(studentId, lessonId);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

}
