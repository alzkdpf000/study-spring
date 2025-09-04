package com.example.threetier.mapper;

import com.example.threetier.domain.MemberVO;
import com.example.threetier.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsertMember(){
        MemberVO member = MemberVO.builder()
                .memberEmail("test@gmail.com")
                .memberPassword("1234")
                .memberName("test")
                .build();

        memberMapper.insertMember(member);
    }

    @Test
    public void testExistMemberEmail(){
        boolean isExist = memberMapper.existMemberEmail("test2@gmail.com");
        log.info("isExist: {}", isExist);
    }

    @Test
    public void testSelectMemberForLogin(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("test@gmail.com");
        memberDTO.setMemberPassword("1234");

        Optional<MemberDTO> foundMember = memberMapper.selectMemberForLogin(memberDTO);
        foundMember.ifPresent((member) -> {
            log.info("member: {}", member);
        });
    }
}



















