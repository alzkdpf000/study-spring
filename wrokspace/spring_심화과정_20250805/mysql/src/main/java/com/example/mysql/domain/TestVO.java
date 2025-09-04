package com.example.mysql.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TestVO {
    private String name;
    private int age;
}













