package com.example.threetier.dto;

import com.example.threetier.audit.Period;
import com.example.threetier.common.enumeration.Status;
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
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private Status postStatus;
    private Long memberId;
    private String memberName;
    private String createdDatetime;
    private String relativeDate;
    private String updatedDatetime;
}











