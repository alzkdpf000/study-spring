package com.example.threetier.domain;

import com.example.threetier.audit.Period;
import com.example.threetier.common.enumeration.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(of="id")
public class PostVO extends Period {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private Status postStatus;
    private Long memberId;
}











