package com.example.muscleApplication.demo.infrastructure;

public record TrainingRecodeEntity(
        Integer id,
        String trainingName,
        String weight,
        String rep,
        String createDate
) {
}
