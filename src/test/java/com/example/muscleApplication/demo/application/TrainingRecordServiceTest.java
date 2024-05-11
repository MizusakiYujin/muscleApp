package com.example.muscleApplication.demo.application;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.parts.Part;
import com.example.muscleApplication.demo.infrastructure.TrainingRecordRepositoryImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TrainingRecordServiceTest {
    @InjectMocks
    TrainingRecordService sut;

    @Mock
    TrainingRecordRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void トレーニング名で検索するとTrainingRecordのリストが返る() {
        // setup
        when(repository.findByTrainingName("ベンチプレス"))
                .thenReturn(
                        List.of(
                        new TrainingRecord(
                                new Part("胸", "ベンチプレス", "140.0", "10"),
                                "2024-04-01"
                        ),
                        new TrainingRecord(
                                new Part("胸", "ベンチプレス", "150.0", "10"),
                                "2024-04-09"
                        ))
                );
        // execute
        List<TrainingRecord> actual = sut.execute("ベンチプレス");

        // assert
        List<TrainingRecord> expected = List.of(
                new TrainingRecord(
                        new Part("胸", "ベンチプレス", "140.0", "10"),
                        "2024-04-01"
                ),
                new TrainingRecord(
                        new Part("胸", "ベンチプレス", "150.0", "10"),
                        "2024-04-09"
                )
        );

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 存在しないトレーニング名で検索する空のリストが返る() {
        // setup
        when(repository.findByTrainingName("ベンチプレス"))
                .thenReturn(List.of());
        // execute
        List<TrainingRecord> actual = sut.execute("シュラック");

        // assert
        List<TrainingRecord> expected = List.of();

        assertThat(actual).isEqualTo(expected);
    }
}