package com.example.threetier.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Search {
    private String[] categories;
    private String keyword;
    private String month;
}
