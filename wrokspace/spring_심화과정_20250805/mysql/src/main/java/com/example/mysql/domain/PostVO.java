package com.example.mysql.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(of="id")
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postReadCount;
    private String memberId;
    private String createdDate;
    private String updatedDate;
}
