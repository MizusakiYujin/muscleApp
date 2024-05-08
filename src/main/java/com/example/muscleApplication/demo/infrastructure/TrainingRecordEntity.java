package com.example.muscleApplication.demo.infrastructure;

public record TrainingRecordEntity(
        Integer id,
        String trainingName,
        String weight,
        String rep,
        String createDate
) {
}
