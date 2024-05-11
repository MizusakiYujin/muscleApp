package com.example.muscleApplication.demo.presentation;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import com.example.muscleApplication.demo.application.TrainingRecordService;
import com.example.muscleApplication.demo.domain.TrainingRecord;
import com.example.muscleApplication.demo.domain.parts.Part;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class TrainingRecordControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TrainingRecordService service;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void トレーニング名検索が正しく行える() {
        // setup
        when(service.execute("ベンチプレス"))
                .thenReturn(
                        List.of(
                                new TrainingRecord(
                                        new Part("胸", "ベンチプレス", "140.0", "10"),
                                        "2024-04-01"
                                ),
                                new TrainingRecord(
                                        new Part("胸", "ベンチプレス", "150.0", "10"),
                                        "2024-04-09"
                                )
                        )
                );

        // execute & assert
        given()
                .when()
                .get("/api/ベンチプレス")
                .then()
                .statusCode(200)
                .assertThat()
                .body("trainingRecords.size()", is(2))
                .body("trainingRecords[0].trainingName", is("ベンチプレス"))
                .body("trainingRecords[0].weight", is("140.0"))
                .body("trainingRecords[0].rep", is("10"))
                .body("trainingRecords[1].trainingName", is("ベンチプレス"))
                .body("trainingRecords[1].weight", is("150.0"))
                .body("trainingRecords[1].rep", is("10"));
    }
}