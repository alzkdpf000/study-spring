package com.example.threetier.repository;

import com.example.threetier.domain.MemberVO;
import com.example.threetier.dto.MemberDTO;
import com.example.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    추가
    public void save(MemberVO memberVO){
        memberMapper.insertMember(memberVO);
    }

//    이메일 검사
    public boolean isExistMemberEmail(String memberEmail){
        return memberMapper.existMemberEmail(memberEmail);
    }

//    로그인
    public Optional<MemberDTO> findMemberByMemberEmailAndMemberPassword(MemberDTO memberDTO){
        return memberMapper.selectMemberForLogin(memberDTO);
    }
}
