package com.example.threetier.dto;

import com.example.threetier.audit.Period;
import com.example.threetier.util.Criteria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
public class ReplyDTO {
    private Long id;
    private String replyContent;
    private Long memberId;
    private String memberName;
    private Long postId;
    private String createdDatetime;
    private String updatedDatetime;
    private String relativeDate;
}
