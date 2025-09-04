package com.example.mysql.mapper;

import com.example.mysql.domain.MemberVO;
import com.example.mysql.dto.MemberDTO;
import com.example.mysql.enumeration.Status;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    public MemberVO toVO(MemberDTO memberDTO) {
        return MemberVO.builder()
                .id(memberDTO.getId())
                .memberEmail(memberDTO.getMemberEmail())
                .memberPassword(memberDTO.getMemberPassword())
                .memberName(memberDTO.getMemberName())
                .memberStatus(memberDTO.getMemberStatus())
                .createdDate(memberDTO.getCreatedDate())
                .updatedDate(memberDTO.getUpdatedDate())
                .build();
    }

    @Test
    public void testJoin(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("test77@gmail.com");
        memberDTO.setMemberPassword("1234");
        memberDTO.setMemberName("테스트");

        MemberVO memberVO = toVO(memberDTO);

        memberMapper.join(memberVO);

        log.info("id: {}", memberVO.getId());
    }

    @Test
    public void testLogin(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("test@gmail.com");
        memberDTO.setMemberPassword("1234");
        log.info("status: {}", memberMapper.login(memberDTO).getMemberStatus());
        assertThat(memberMapper.login(memberDTO)).isNotNull();
    }

    @Test
    public void testSelectMemberByStatus(){
//        NPE를 방지하기 위해서
//        List는 Optional로 감싸지 않는다(List는 항상 null이 아니기 때문에)
//        Optional<MemberDTO> foundMember = memberMapper.selectMemberByStatus(Status.ACTIVE);
//        MemberDTO memberDTO = foundMember.orElseThrow(RuntimeException::new);
//        log.info("{}", memberDTO);
        List<MemberDTO> foundMembers = memberMapper.selectMemberByStatus(Status.ACTIVE);
        foundMembers.stream().map(MemberDTO::toString).forEach(log::info);
    }
}
