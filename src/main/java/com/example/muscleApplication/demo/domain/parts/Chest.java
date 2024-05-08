package com.example.muscleApplication.demo.domain.parts;

public record Chest(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {

}
