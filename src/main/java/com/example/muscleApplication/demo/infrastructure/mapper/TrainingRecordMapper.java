package com.example.muscleApplication.demo.infrastructure.mapper;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainingRecordMapper {

    @Select("SELECT part_name, training_name, weight, rep, create_date FROM training_recode WHERE training_name = #{trainingName}")
    List<TrainingRecordEntity> findByTrainingName(String trainingName);

    @Insert("INSERT INTO training_recode (part_name, training_name, weight, rep, create_date) VALUES (#{partName}, #{trainingName}, #{weight}, #{rep}, #{createDate})")
    int insertTrainingRecord(TrainingRecordEntity trainingRecord);
}
