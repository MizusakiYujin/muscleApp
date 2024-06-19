package com.example.muscleApplication.demo.infrastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "training_recode")
public class TREntity {
    @Id
    @Column(name = "part_name")
    public String partName;
    @Column(name = "training_name")
    public String trainingName;
    @Id
    @Column(name = "weight")
    public String weight;
    @Id
    @Column(name = "rep")
    public String rep;
    @Id
    @Column(name = "createDate")
    public String createDate;

}
