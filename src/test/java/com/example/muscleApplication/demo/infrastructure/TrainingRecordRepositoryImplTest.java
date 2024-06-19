package com.example.muscleApplication.demo.infrastructure;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.Part;
import com.example.muscleApplication.demo.infrastructure.mapper.MybatisAnnotationTrainingRecordMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TrainingRecordRepositoryImplTest {
    @InjectMocks
    TrainingRecordRepositoryImpl sut;

    @Mock
    MybatisAnnotationTrainingRecordMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class トレーニング名検索 {
        @Test
        void トレーニング名で検索するとTrainingRecordのリストが返る() {
            // setup
            when(mapper.findByTrainingName("ベンチプレス"))
                    .thenReturn(
                            List.of(
                                    new TREntity("胸", "ベンチプレス", "140.0", "10", "2024-04-01"),
                                    new TREntity("胸", "ベンチプレス", "150.0", "10", "2024-04-09")
                            )
                    );
            // execute
            List<TrainingRecord> actual = sut.findByTrainingName("ベンチプレス");

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
            when(mapper.findByTrainingName("ベンチプレス"))
                    .thenReturn(List.of());
            // execute
            List<TrainingRecord> actual = sut.findByTrainingName("シュラック");

            // assert
            List<TrainingRecord> expected = List.of();

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class トレーニング記録登録 {
        @Test
        void トレーニング記録1件登録() {
            // setup
            when(mapper.insertTrainingRecord(new TrainingRecordEntity("胸", "ベンチプレス", "120.0", "7", "2024-04-03")))
                    .thenReturn(1);
            // execute
            Integer actual = sut.insertTrainingRecordList(
                    List.of(
                            new TrainingRecord(
                                    new Part("胸", "ベンチプレス", "120.0", "7"), "2024-04-03"
                            )
                    )
            );

            // assert
            assertThat(actual).isEqualTo(1);
        }

        @Test
        void トレーニング記録2件登録() {
            // setup
            when(mapper.insertTrainingRecord(new TrainingRecordEntity("胸", "ベンチプレス", "120.0", "7", "2024-04-03")))
                    .thenReturn(1);

            when(mapper.insertTrainingRecord(new TrainingRecordEntity("腕", "アームカール", "20.0", "9", "2024-04-04")))
                    .thenReturn(1);
            // execute
            Integer actual = sut.insertTrainingRecordList(
                    List.of(
                            new TrainingRecord(
                                    new Part("胸", "ベンチプレス", "120.0", "7"), "2024-04-03"
                            ),
                            new TrainingRecord(
                                    new Part("腕", "アームカール", "20.0", "9"), "2024-04-04"
                            )
                    )
            );

            // assert
            assertThat(actual).isEqualTo(2);
        }
    }

}