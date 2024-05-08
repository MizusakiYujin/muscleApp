package com.example.muscleApplication.demo.application;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.repository.TrainingRecordRepository;
import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingRecordService {
    private final TrainingRecordRepository trainingRecordRepository;
    public TrainingRecordService(
            TrainingRecordRepository trainingRecordRepository) {
        this.trainingRecordRepository = trainingRecordRepository;
    }

    public List<TrainingRecord> findByTrainingName(String trainingName) {
        return trainingRecordRepository.findByTrainingName(trainingName);
    }
}
