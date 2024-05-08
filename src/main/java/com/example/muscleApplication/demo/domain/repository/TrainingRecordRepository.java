package com.example.muscleApplication.demo.domain.repository;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;

import java.util.List;

public interface TrainingRecordRepository {
    List<TrainingRecordEntity> findByTrainingName(String trainingName);
}
