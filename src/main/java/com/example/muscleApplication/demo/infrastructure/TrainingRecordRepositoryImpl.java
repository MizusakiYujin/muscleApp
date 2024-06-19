package com.example.muscleApplication.demo.infrastructure;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.repository.TrainingRecordRepository;
import com.example.muscleApplication.demo.infrastructure.mapper.MybatisAnnotationTrainingRecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingRecordRepositoryImpl implements TrainingRecordRepository {
    private final MybatisAnnotationTrainingRecordMapper mybatisAnnotationTrainingRecordMapper;

    public TrainingRecordRepositoryImpl(
            MybatisAnnotationTrainingRecordMapper mybatisAnnotationTrainingRecordMapper) {
        this.mybatisAnnotationTrainingRecordMapper = mybatisAnnotationTrainingRecordMapper;
    }

    @Override
    public List<TrainingRecord> findByTrainingName(String trainingName) {
//        return mybatisAnnotationTrainingRecordMapper.findByTrainingName(trainingName)
//                .stream()
//                .map(TrainingRecordEntity::toModel)
//                .toList();
        return null;
    }

    @Override
    public Integer insertTrainingRecordList(List<TrainingRecord> trainingRecordList) {
        return trainingRecordList
                .stream()
                .map(TrainingRecord::toEntity)
                .map(mybatisAnnotationTrainingRecordMapper::insertTrainingRecord)
                .reduce(0, Integer::sum);
    }
}
