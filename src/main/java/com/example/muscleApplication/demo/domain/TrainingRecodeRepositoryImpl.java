package com.example.muscleapplication.demo.domain;

import com.example.muscleapplication.demo.infrastructure.TrainingRecodeEntity;
import com.example.muscleapplication.demo.infrastructure.mapper.TrainingRecodeMapper;
import com.example.muscleapplication.demo.infrastructure.repository.TrainingRecodeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingRecodeRepositoryImpl implements TrainingRecodeRepository {
    private final TrainingRecodeMapper trainingRecodeMapper;

    public TrainingRecodeRepositoryImpl(
            TrainingRecodeMapper trainingRecodeMapper) {
        this.trainingRecodeMapper = trainingRecodeMapper;
    }

    @Override
    public List<TrainingRecodeEntity> findByTrainingName(String trainingName) {
        return trainingRecodeMapper.findByTrainingName(trainingName);
    }
}
