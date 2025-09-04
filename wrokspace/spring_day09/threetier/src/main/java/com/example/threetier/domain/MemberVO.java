package com.example.threetier.domain;

import com.example.threetier.audit.Period;
import com.example.threetier.common.enumeration.Provider;
import com.example.threetier.common.enumeration.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(of="id")
public class MemberVO extends Period {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Status memberStatus;
    private String kakaoEmail;
    private String kakaoProfileUrl;
    private Provider provider;
}














