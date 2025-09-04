package com.example.threetier.domain;

import com.example.threetier.audit.Period;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @ToString
@EqualsAndHashCode(of="id")
public class PostFileVO {
    private Long id;
    private Long postId;
}
