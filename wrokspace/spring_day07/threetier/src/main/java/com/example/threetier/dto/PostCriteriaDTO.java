package com.example.threetier.dto;

import com.example.threetier.common.enumeration.Status;
import com.example.threetier.util.Criteria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class PostCriteriaDTO {
    private List<PostDTO> posts;
    private Criteria criteria;
}
