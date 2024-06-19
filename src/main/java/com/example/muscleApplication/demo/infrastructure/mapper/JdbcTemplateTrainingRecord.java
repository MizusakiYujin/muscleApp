package com.example.muscleApplication.demo.infrastructure.mapper;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JdbcTemplateTrainingRecord {
    private final NamedParameterJdbcOperations jdbcOps;

    public JdbcTemplateTrainingRecord(NamedParameterJdbcOperations jdbcOps) {
        this.jdbcOps = jdbcOps;
    }

    // 検索
    List<TrainingRecordEntity> findByTrainingName(String trainingName) {
        return jdbcOps.query(
                """
                           SELECT 
                               part_name,
                               training_name,
                               weight,
                               rep,
                               create_date
                           FROM 
                               training_recode
                           WHERE 
                               training_name = :trainingName
                        """,
                new MapSqlParameterSource()
                        .addValue("trainingName", trainingName),
                (rs, rowNum) -> new TrainingRecordEntity(
                        rs.getString("part_name"),
                        rs.getString("training_name"),
                        rs.getString("weight"),
                        rs.getString("rep"),
                        rs.getString("create_date")
                )
        );
    }

    // 一件登録
    int insertTrainingRecord(TrainingRecordEntity trainingRecord) {
        return jdbcOps.update(
                """
                           INSERT INTO training_recode 
                               (
                                   part_name,
                                   training_name,
                                   weight,
                                   rep,
                                   create_date
                               ) 
                           VALUES 
                               (
                                   :partName,
                                   :trainingName,
                                   :weight,
                                   :rep,
                                   :createDate
                               )
                        """,
                new MapSqlParameterSource()
                        .addValue("partName", trainingRecord.partName())
                        .addValue("trainingName", trainingRecord.trainingName())
                        .addValue("weight", trainingRecord.weight())
                        .addValue("rep", trainingRecord.rep())
                        .addValue("createDate", trainingRecord.createDate())
        );
    }

    // 複数件(リスト)登録
    int bulkInsertTrainingRecordList(List<TrainingRecordEntity> trainingRecordList) {
        int[] updateCounts = jdbcOps.batchUpdate(
                """
                           INSERT INTO training_recode
                               (
                                   part_name,
                                   training_name,
                                   weight,
                                   rep,
                                   create_date
                               )
                           VALUES
                               (
                                   :partName,
                                   :trainingName,
                                   :weight,
                                   :rep,
                                   :createDate
                               )
                        """,
                trainingRecordList
                        .stream()
                        .map(trainingRecord -> new MapSqlParameterSource()
                                .addValue("partName", trainingRecord.partName())
                                .addValue("trainingName", trainingRecord.trainingName())
                                .addValue("weight", trainingRecord.weight())
                                .addValue("rep", trainingRecord.rep())
                                .addValue("createDate", trainingRecord.createDate())
                        )
                        .toArray(SqlParameterSource[]::new)
        );
        return Arrays.stream(updateCounts).sum();
    }
}
