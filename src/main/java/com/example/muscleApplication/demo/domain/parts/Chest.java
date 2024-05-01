package com.example.muscleapplication.demo.domain.parts;

public record Chest(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {

}
