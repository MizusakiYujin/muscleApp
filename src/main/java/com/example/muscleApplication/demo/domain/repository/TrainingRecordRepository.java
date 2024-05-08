package com.example.muscleapplication.demo.domain.repository;

import com.example.muscleapplication.demo.infrastructure.TrainingRecordEntity;

import java.util.List;

public interface TrainingRecordRepository {
    List<TrainingRecordEntity> findByTrainingName(String trainingName);
}
