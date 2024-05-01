package com.example.muscleapplication.demo.infrastructure.mapper;

import com.example.muscleapplication.demo.infrastructure.TrainingRecodeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainingRecodeMapper {
    @Select("SELECT * FROM training_recode WHERE training_name = #{trainingName}")
    List<TrainingRecodeEntity> findByTrainingName(String trainingName);
}
