package com.example.muscleApplication.demo.domain.parts;

public record Shoulder(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {

}
