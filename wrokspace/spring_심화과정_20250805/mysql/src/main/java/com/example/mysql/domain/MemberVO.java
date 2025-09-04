package com.example.mysql.domain;

import com.example.mysql.audit.Period;
import com.example.mysql.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Getter @ToString
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//@Builder
@SuperBuilder
@EqualsAndHashCode(of="id")
public class MemberVO extends Period {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Status memberStatus;
}
