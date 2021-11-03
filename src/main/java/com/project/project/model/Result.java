package com.project.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int target_age;
    private int target_age_plus;
    private String target_sex;
    private String dev;
    private String inside;
    private String name;
    private String link;
    private String price;
    private String ship_fee;
    public Result orElse(Object o) {
        return null;
    }
}
