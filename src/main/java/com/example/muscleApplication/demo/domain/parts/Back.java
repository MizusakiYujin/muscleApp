package com.example.muscleapplication.demo.domain.parts;

public record Back(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {

}
