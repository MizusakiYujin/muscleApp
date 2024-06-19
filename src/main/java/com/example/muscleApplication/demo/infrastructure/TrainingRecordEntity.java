package com.example.muscleApplication.demo.infrastructure;

public record TrainingRecordEntity(
        String partName,
        String trainingName,
        String weight,
        String rep,
        String createDate
) {
}
