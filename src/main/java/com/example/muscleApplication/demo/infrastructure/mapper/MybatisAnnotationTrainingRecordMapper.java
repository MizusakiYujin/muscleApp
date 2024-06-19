package com.example.muscleApplication.demo.infrastructure.mapper;

import com.example.muscleApplication.demo.infrastructure.TREntity;
import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MybatisAnnotationTrainingRecordMapper {

    // 検索
    @Select("SELECT part_name, training_name, weight, rep, create_date FROM training_recode WHERE training_name = #{trainingName}")
    List<TrainingRecordEntity> findByTrainingName(String trainingName);

    // 一件登録
    @Insert("INSERT INTO training_recode (part_name, training_name, weight, rep, create_date) VALUES (#{partName}, #{trainingName}, #{weight}, #{rep}, #{createDate})")
    int insertTrainingRecord(TrainingRecordEntity trainingRecord);

    // 複数件(リスト)登録
    @Insert({
            "<script>",
            "INSERT INTO training_recode (part_name, training_name, weight, rep, create_date)",
            "VALUES",
            "<foreach collection='list' item='item' index='index' separator=','>",
            "(#{item.partName}, #{item.trainingName}, #{item.weight}, #{item.rep}, #{item.createDate})",
            "</foreach>",
            "</script>"
    })
    int bulkInsertTrainingRecordList(List<TrainingRecordEntity> records);
}
