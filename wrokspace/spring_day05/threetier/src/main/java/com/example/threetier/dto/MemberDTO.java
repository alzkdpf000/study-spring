package com.example.threetier.dto;

import com.example.threetier.common.enumeration.Provider;
import com.example.threetier.common.enumeration.Status;
import com.example.threetier.domain.MemberVO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(of="id")
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Status memberStatus;
    private String kakaoEmail;
    private String kakaoProfileUrl;
    private Provider provider;
    private String createdDatetime;
    private String updatedDatetime;
    private boolean remember;
}



