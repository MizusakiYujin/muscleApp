package com.example.muscleapplication.demo.domain.parts;

public record Shoulder(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {

}
