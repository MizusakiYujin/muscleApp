package com.example.muscleApplication.demo.presentation.response;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TrainingRecordResponse(
        @JsonProperty("trainingName")
        String trainingName,
        @JsonProperty("weight")
        String weight,
        @JsonProperty("rep")
        String rep
) {
    public static TrainingRecordResponse of(TrainingRecord trainingRecord) {
        return new TrainingRecordResponse(
                trainingRecord.part().trainingName(),
                trainingRecord.part().weight(),
                trainingRecord.part().rep()
        );
    }
}
