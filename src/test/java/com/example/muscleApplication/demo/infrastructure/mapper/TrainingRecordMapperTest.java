package com.example.muscleApplication.demo.infrastructure.mapper;

import com.example.muscleApplication.demo.infrastructure.TrainingRecordEntity;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@DBUnit
@DBRider
class TrainingRecordMapperTest {
    private static final String DB_URL = "jdbc:h2:mem:test;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";

    private static final ConnectionHolder connectionHolder = () -> DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    @Autowired
    private TrainingRecordMapper sut;

    @BeforeAll
    static void setUp() {
        Flyway.configure().dataSource(DB_URL, DB_USER, DB_PASSWORD).load().migrate();
    }

    @Nested
    class トレーニング名検索 {
        @Test
        @DataSet("datasets/setup/training.yml")
        void トレーニング名称がベンチプレスの検索が正しく行える場合() {
            // execute
            List<TrainingRecordEntity> actual = sut.findByTrainingName("ベンチプレス");
            // assert
            List<TrainingRecordEntity> expected =
                    List.of(new TrainingRecordEntity( "胸","ベンチプレス", "140.0", "10", "2024-05-01"));
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DataSet("datasets/setup/training.yml")
        void トレーニング名称がスカルクラッシャーの検索が正しく行える場合() {
            // execute
            List<TrainingRecordEntity> actual = sut.findByTrainingName("スカルクラッシャー");
            // assert
            List<TrainingRecordEntity> expected =
                    List.of(
                            new TrainingRecordEntity( "腕", "スカルクラッシャー", "40.0", "8", "2024-05-01"),
                            new TrainingRecordEntity( "腕","スカルクラッシャー", "20.0", "10", "2024-04-30")
                    );
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DataSet("datasets/setup/training.yml")
        void トレーニング名称が登録されていない検索の場合() {
            // execute
            List<TrainingRecordEntity> actual = sut.findByTrainingName("シュラッグ");
            // assert
            List<TrainingRecordEntity> expected = List.of();
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class トレーニング記録登録 {
        @Test
        void トレーニング記録一件登録() {
            // execute
            int actual = sut.insertTrainingRecordBulk(List.of(new TrainingRecordEntity("胸", "ベンチプレス", "140.0", "8", "2024-04-01")));
            // assert
            assertThat(actual).isEqualTo(1);
        }

    }


}