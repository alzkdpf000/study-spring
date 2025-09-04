package com.example.threetier.domain;

import com.example.threetier.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of="id")
public class CategoryVO extends Period {
    private Long id;
    private String categoryName;
}
