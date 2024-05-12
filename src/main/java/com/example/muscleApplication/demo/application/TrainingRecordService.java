package com.example.muscleApplication.demo.application;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.repository.TrainingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TrainingRecordService {
    private final TrainingRecordRepository trainingRecordRepository;

    public List<TrainingRecord> execute(String trainingName) {
        return trainingRecordRepository.findByTrainingName(trainingName);
    }

    public Integer execute(List<TrainingRecord> trainingRecordList) {
        return trainingRecordRepository.insertTrainingRecordList(trainingRecordList);
    }
}
