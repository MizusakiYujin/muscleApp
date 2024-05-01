package com.example.muscleapplication.demo.domain.parts;

public record Reg(
        String trainingName,
        Integer weight,
        Integer rep
) implements Part {

}
