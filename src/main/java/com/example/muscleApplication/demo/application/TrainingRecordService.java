package com.example.muscleapplication.demo.application;

import com.example.muscleapplication.demo.infrastructure.TrainingRecordEntity;
import com.example.muscleapplication.demo.domain.repository.TrainingRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingRecordService {
    private final TrainingRecordRepository trainingRecordRepository;
    public TrainingRecordService(
            TrainingRecordRepository trainingRecordRepository) {
        this.trainingRecordRepository = trainingRecordRepository;
    }

    public List<TrainingRecordEntity> findByTrainingName(String trainingName) {
        return trainingRecordRepository.findByTrainingName(trainingName);
    }
}
