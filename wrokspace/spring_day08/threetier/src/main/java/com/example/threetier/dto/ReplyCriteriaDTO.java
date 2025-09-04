package com.example.threetier.dto;

import com.example.threetier.util.Criteria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
public class ReplyCriteriaDTO {
    private List<ReplyDTO> replies;
    private Criteria criteria;
}
