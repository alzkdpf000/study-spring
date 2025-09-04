package com.example.mysql.dto;

import com.example.mysql.audit.Period;
import com.example.mysql.enumeration.Status;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Status memberStatus;
    private String createdDate;
    private String updatedDate;
}
