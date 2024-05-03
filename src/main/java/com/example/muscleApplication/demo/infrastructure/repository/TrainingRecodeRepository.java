package com.example.muscleapplication.demo.infrastructure.repository;

import com.example.muscleapplication.demo.infrastructure.TrainingRecodeEntity;

import java.util.List;

public interface TrainingRecodeRepository {
    List<TrainingRecodeEntity> findByTrainingName(String trainingName);
}
