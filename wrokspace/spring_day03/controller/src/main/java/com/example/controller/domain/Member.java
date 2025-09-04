package com.example.controller.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Setter @Getter @ToString
public class Member {
    private String name;
    private int age;
}
