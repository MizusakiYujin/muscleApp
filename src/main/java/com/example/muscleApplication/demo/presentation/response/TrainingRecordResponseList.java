package com.example.muscleApplication.demo.presentation.response;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TrainingRecordResponseList(
        @JsonProperty("trainingRecords")
        List<TrainingRecordResponse> trainingRecords
) {
    public static TrainingRecordResponseList of(List<TrainingRecord> trainingRecordList) {
        return new TrainingRecordResponseList(
                trainingRecordList
                    .stream()
                    .map(TrainingRecordResponse::of)
                    .toList()
        );
    }
}
