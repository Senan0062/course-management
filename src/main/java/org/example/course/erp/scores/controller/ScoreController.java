package org.example.course.erp.scores.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.course.erp.scores.dto.request.ScoreCreateRequest;
import org.example.course.erp.scores.dto.response.ScoreResponse;
import org.example.course.erp.scores.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/scores")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ScoreController {
    ScoreService scoreService;


    @PostMapping
    public ResponseEntity<ScoreResponse> addScore(@RequestBody ScoreCreateRequest request) {
        return ResponseEntity.ok(scoreService.addScore(request));
    }

    @GetMapping
    public ResponseEntity<List<ScoreResponse>> getAllScores() {
        return ResponseEntity.ok(scoreService.getAllScores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreResponse> getScoreById(@PathVariable Long id) {
        return ResponseEntity.ok(scoreService.getScoreById(id));
    }

    @GetMapping("/student/{studentId}/lesson/{lessonId}")
    public ResponseEntity<Double> getAverageScore(@PathVariable Long studentId, @PathVariable Long lessonId) {
        return ResponseEntity.ok(scoreService.getAverageScore(studentId, lessonId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
