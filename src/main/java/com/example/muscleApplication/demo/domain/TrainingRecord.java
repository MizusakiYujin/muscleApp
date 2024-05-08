package com.example.muscleApplication.demo.domain;

import com.example.muscleApplication.demo.domain.parts.Part;

public record TrainingRecord(
        Part part,
        String createDate
) { }
