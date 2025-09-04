package com.example.threetier.dto;

import com.example.threetier.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
public class PostFileDTO {
    private Long id;
    private Long postId;
}
