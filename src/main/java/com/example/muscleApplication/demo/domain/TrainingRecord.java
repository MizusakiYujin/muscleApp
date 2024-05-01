package com.example.muscleapplication.demo.domain;

import com.example.muscleapplication.demo.domain.parts.*;

import java.util.Date;

public record TrainingRecord(
        Part part,
        Date createDate
) { }
