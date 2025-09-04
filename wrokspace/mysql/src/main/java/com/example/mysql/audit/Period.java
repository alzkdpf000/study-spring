package com.example.mysql.audit;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @ToString
public class Period {
    private String createdDate;
    private String updatedDate;
}
