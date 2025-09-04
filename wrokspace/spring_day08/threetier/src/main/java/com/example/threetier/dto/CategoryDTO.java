package com.example.threetier.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(of="id")
public class CategoryDTO {
    private Long id;
    private Long postId;
    private String categoryName;
    private String createdDatetime;
    private String updatedDatetime;
}















