package com.example.muscleApplication.demo.infrastructure.mapper;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainingRecordMapper {
    @Select("SELECT * FROM training_recode WHERE training_name = #{trainingName}")
    List<TrainingRecordEntity> findByTrainingName(String trainingName);
}
