package com.example.muscleApplication.demo.infrastructure;

import com.example.muscleApplication.demo.domain.repository.TrainingRecordRepository;
import com.example.muscleApplication.demo.infrastructure.mapper.TrainingRecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingRecordRepositoryImpl implements TrainingRecordRepository {
    private final TrainingRecordMapper trainingRecordMapper;

    public TrainingRecordRepositoryImpl(
            TrainingRecordMapper trainingRecordMapper) {
        this.trainingRecordMapper = trainingRecordMapper;
    }

    @Override
    public List<TrainingRecordEntity> findByTrainingName(String trainingName) {
        return trainingRecordMapper.findByTrainingName(trainingName);
    }
}
