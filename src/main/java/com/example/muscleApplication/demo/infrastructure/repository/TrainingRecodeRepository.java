package com.example.muscleApplication.demo.infrastructure.repository;

import com.example.muscleApplication.demo.infrastructure.TrainingRecodeEntity;

import java.util.List;

public interface TrainingRecodeRepository {
    List<TrainingRecodeEntity> findByTrainingName(String trainingName);
}
