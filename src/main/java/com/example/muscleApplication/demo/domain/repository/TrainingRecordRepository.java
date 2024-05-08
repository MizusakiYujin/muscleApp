package com.example.muscleApplication.demo.domain.repository;

import com.example.muscleApplication.demo.domain.TrainingRecord;

import java.util.List;

public interface TrainingRecordRepository {
    List<TrainingRecord> findByTrainingName(String trainingName);
}
