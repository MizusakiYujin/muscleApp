package com.example.muscleapplication.demo.domain.parts;

public record Arm(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {
}
