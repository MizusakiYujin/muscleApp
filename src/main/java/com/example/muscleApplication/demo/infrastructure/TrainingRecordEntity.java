package com.example.muscleApplication.demo.infrastructure;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.Part;

public record TrainingRecordEntity(
        String partName,
        String trainingName,
        String weight,
        String rep,
        String createDate
) {
    public TrainingRecord toModel() {
        return new TrainingRecord(
                new Part(partName, trainingName, weight, rep),
                createDate
        );
    }
}
