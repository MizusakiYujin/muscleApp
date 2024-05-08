package com.example.muscleApplication.demo.application;

import com.example.muscleApplication.demo.infrastructure.TrainingRecodeEntity;
import com.example.muscleApplication.demo.infrastructure.repository.TrainingRecodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingRecodeApplicationService {
    private final TrainingRecodeRepository trainingRecodeRepository;
    public TrainingRecodeApplicationService(
            TrainingRecodeRepository trainingRecodeRepository) {
        this.trainingRecodeRepository = trainingRecodeRepository;
    }

    public List<TrainingRecodeEntity> findByTrainingName(String trainingName) {
        return trainingRecodeRepository.findByTrainingName(trainingName);
    }
}
