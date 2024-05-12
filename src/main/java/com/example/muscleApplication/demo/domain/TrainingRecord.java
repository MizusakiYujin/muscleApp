package com.example.muscleApplication.demo.domain;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;

public record TrainingRecord(
        Part part,
        String createDate
) {
    public TrainingRecordEntity toModel() {
        return new TrainingRecordEntity(
                part.partName(), part.trainingName(), part().weight(), part().rep(), createDate
        );
    }
}
