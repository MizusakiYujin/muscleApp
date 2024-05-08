package com.example.muscleapplication.demo.presentation;

import com.example.muscleapplication.demo.application.TrainingRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainingRecode")
public class DemoController {
    private final TrainingRecordService trainingRecodeApplication;
    public DemoController(TrainingRecordService trainingRecodeApplication) {
        this.trainingRecodeApplication = trainingRecodeApplication;
    }

//    @GetMapping("/{trainingName:[a-zA-Zあ-ん]{1,50}}")
//    public List<TrainingRecodeEntity> getByTrainingName(
//            @PathVariable("trainingName")
//            String trainingName){
//        return trainingRecodeApplication.findByTrainingName(trainingName);
//    }
//
    @GetMapping("/aa")
    public String getByTrainingName(){
        return "aaa";
    }
}
