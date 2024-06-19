package com.example.muscleApplication.demo.infrastructure.mapper;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface MybatisSQLBuilderTrainingRecord {

    // 検索
    @SelectProvider(type = SqlProvider.class, method = "findByTrainingName")
    List<TrainingRecordEntity> findByTrainingName(String trainingName);

    @InsertProvider(type = SqlProvider.class, method = "insertTrainingRecord")
    int insertTrainingRecord(TrainingRecordEntity trainingRecordEntity);

    @InsertProvider(type = SqlProvider.class, method = "bulkInsertTrainingRecordList")
    Integer bulkInsertTrainingRecordList(List<TrainingRecordEntity> trainingRecordList);

    class SqlProvider {
        public String bulkInsertTrainingRecordList(List<TrainingRecordEntity> trainingRecordList) {
            SQL sql = new SQL() {
                {
                    INSERT_INTO("training_recode");
                    INTO_COLUMNS("part_name", "training_name", "weight", "rep", "create_date");
                    for (int i = 0; i < trainingRecordList.size(); i++) {
                        INTO_VALUES(
                                "#{trainingRecordList[" + i + "].partName}",
                                "#{trainingRecordList[" + i + "].trainingName}",
                                "#{trainingRecordList[" + i + "].weight}",
                                "#{trainingRecordList[" + i + "].rep}",
                                "#{trainingRecordList[" + i + "].createDate}"
                        );
                        ADD_ROW();
                    }
                }
            };
            return sql.toString();
        }

        public String findByTrainingName(String trainingName) {
            SQL sql = new SQL() {
                {
                    SELECT("part_name", "training_name", "weight", "rep", "create_date");
                    FROM("training_recode");
                    WHERE("training_name = #{trainingName}");
                }
            };
            return sql.toString();
        }

        public String insertTrainingRecord(TrainingRecordEntity trainingRecordEntity) {
            SQL sql = new SQL() {
                {
                    INSERT_INTO("training_recode");
                    INTO_COLUMNS("part_name", "training_name", "weight", "rep", "create_date");
                    INTO_VALUES(
                            "#{partName}",
                            "#{trainingName}",
                            "#{weight}",
                            "#{rep}",
                            "#{createDate}"
                    );
                }
            };
            return sql.toString();
        }
    }
}
