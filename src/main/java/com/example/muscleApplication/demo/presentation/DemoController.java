package com.example.muscleapplication.demo.presentation;

import com.example.muscleapplication.demo.application.TrainingRecodeApplicationService;
import com.example.muscleapplication.demo.infrastructure.TrainingRecodeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trainingRecode")
public class DemoController {
    private final TrainingRecodeApplicationService trainingRecodeApplication;
    public DemoController(TrainingRecodeApplicationService trainingRecodeApplication) {
        this.trainingRecodeApplication = trainingRecodeApplication;
    }

    @GetMapping("/{trainingName:[a-zA-Z]{1,50}}")
    public List<TrainingRecodeEntity> getByTrainingName(
            @PathVariable("trainingName")
            String trainingName){
        return trainingRecodeApplication.findByTrainingName(trainingName);
    }
}
