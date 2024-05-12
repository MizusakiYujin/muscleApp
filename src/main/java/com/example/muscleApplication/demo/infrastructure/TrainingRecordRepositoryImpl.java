package com.example.muscleApplication.demo.infrastructure;

import com.example.muscleApplication.demo.domain.TrainingRecord;
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
    public List<TrainingRecord> findByTrainingName(String trainingName) {
        return trainingRecordMapper.findByTrainingName(trainingName)
                .stream()
                .map(TrainingRecordEntity::toModel)
                .toList();
    }

    @Override
    public Integer insertTrainingRecordList(List<TrainingRecord> trainingRecordList) {
        return trainingRecordList
                .stream()
                .map(TrainingRecord::toModel)
                .map(trainingRecordMapper::insertTrainingRecord)
                .reduce(0, Integer::sum);
    }


}
