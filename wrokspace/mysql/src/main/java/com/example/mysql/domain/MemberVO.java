package com.example.mysql.domain;

import com.example.mysql.audit.Period;
import com.example.mysql.enumeration.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@SuperBuilder
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberVO extends Period {
//    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Status memberStatus;

}
