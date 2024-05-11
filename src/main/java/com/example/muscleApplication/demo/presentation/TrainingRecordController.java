package com.example.muscleApplication.demo.presentation;

import com.example.muscleApplication.demo.application.TrainingRecordService;
import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.presentation.response.TrainingRecordResponseList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrainingRecordController {
    private final TrainingRecordService trainingRecordService;

    @GetMapping("/{trainingName:[ァ-ヺ]+}")
    @ResponseStatus(HttpStatus.OK)
    public TrainingRecordResponseList getByTrainingName(
            @PathVariable("trainingName")
            String trainingName
    ) {
        return TrainingRecordResponseList.of(trainingRecordService.execute(trainingName));
    }

    @PostMapping
    public ResponseEntity<Void> postTrainingRecord(
    ){

        return new ResponseEntity<>(
                null,
                null,
                HttpStatus.OK
        );
    }

    @GetMapping("/test")
    public String getByTrainingName() {
        return "test";
    }
}
