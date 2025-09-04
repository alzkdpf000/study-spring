package com.example.mysql.mapper;

import com.example.mysql.domain.MemberVO;
import com.example.mysql.dto.MemberDTO;
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

    @Test
    public void testJoin(){
//        for (int i = 0; i < 10; i++) {
//            MemberVO member = new MemberVO();
//            member.setMemberEmail("test" + (i + 1) + "@gmail.com");
//            member.setMemberPassword("1234");
//            member.setMemberName("test" + (i + 1));
//
//            memberMapper.join(member);
//        }
//        MemberVO memberVO = new MemberVO();
//        memberVO.setMemberEmail("test2@gmail.com");
//        memberVO.setMemberPassword("2222");
//        memberVO.setMemberName("test2");
        MemberVO memberVO = MemberVO.builder()
                .memberPassword("1234")
                .memberName("test")
                .build();

        memberMapper.join(memberVO);

        log.info("inserted id: {}", memberVO.getId());
    }

    @Test
    public void testLogin(){
        String memberEmail = "test@gmail.com";
        String memberPassword = "1234";

//        Ctrl + 클릭: 선언부로 이동
        MemberDTO memberDTO = memberMapper.login(memberEmail, memberPassword);
        if(memberDTO != null){ // 로그인 성공
            System.out.println(memberDTO);
        }else{ // 로그인 실패
            System.out.println("로그인 실패!");
        }
    }

    @Test
    public void testFindInformationByEmail(){
       String memberEmail = "test2@gmail.com";
//       Ctrl + Alt + v: 값에 알맞은 자료형, 변수가 설정된다.
        MemberDTO member = memberMapper.findInformationByEmail(memberEmail);

        if(member != null){
            System.out.println(member);
        }else{
            System.out.println("존재하지 않는 이메일입니다.");
        }
    }

    @Test
    public void testSelectCountByMemberEmail(){
        int count = memberMapper.selectCountByMemberEmail("test2@gmail.com");
        if(count > 0){
            System.out.println("중복 있다.");
        }else{
            System.out.println("중복 없다.");
        }
    }

    @Test
    public void testSelectAllMember(){
        List<MemberDTO> members = memberMapper.selectAllMember();
        for(int i=0; i<members.size(); i++){
            System.out.println(members.get(i));
        }
    }
}












