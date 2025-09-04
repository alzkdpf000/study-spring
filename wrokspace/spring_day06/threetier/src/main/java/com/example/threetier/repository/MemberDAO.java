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

//    카카오
//    기존 카카오 회원 정보 조회
    public Optional<MemberDTO> findMemberByKakaoEmail(String kakaoEmail){
        return memberMapper.selectMemberByKakaoEmail(kakaoEmail);
    }

//    카카오 회원가입
    public void saveKakaoMember(MemberVO memberVO){
        memberMapper.insertKakaoMember(memberVO);
    }
}
