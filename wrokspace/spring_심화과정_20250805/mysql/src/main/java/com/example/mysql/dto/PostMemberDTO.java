package com.example.mysql.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostMemberDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private String postReadCount;
    private String memberId;
    private String memberName;
    private String createdDate;
    private String updatedDate;
}
