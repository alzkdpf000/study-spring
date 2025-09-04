package com.example.controller.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Setter @Getter @ToString
public class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;

    public int getTotal(){
        return kor + eng + math;
    }

    public double getAverage() {
        return Double.parseDouble(String.format("%.2f", getTotal() / 3.0));
    }
}
