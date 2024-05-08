package com.example.muscleapplication.demo.infrastructure.mapper;

import com.example.muscleapplication.demo.infrastructure.TrainingRecordEntity;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.DriverManager;
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

    @Test
    @DataSet("datasets/setup/training.yml")
    void トレーニング名称がベンチプレスの検索が正しく行える場合() {
        // execute
        List<TrainingRecordEntity> actual = sut.findByTrainingName("ベンチプレス");
        // assert
        List<TrainingRecordEntity> expected =
                List.of(new TrainingRecordEntity(1, "ベンチプレス", "140.0", "10", "2024-05-01"));
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
                        new TrainingRecordEntity(2, "スカルクラッシャー", "40.0", "8", "2024-05-01"),
                        new TrainingRecordEntity(4,"スカルクラッシャー", "20.0", "10", "2024-04-30")
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