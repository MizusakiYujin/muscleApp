package com.example.muscleApplication.demo.domain;

import com.example.muscleApplication.demo.domain.parts.*;

import java.util.Date;

public record TrainingRecord(
        Part part,
        Date createDate
) { }
