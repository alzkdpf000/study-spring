package com.example.threetier.service;

import com.example.threetier.domain.MemberVO;
import com.example.threetier.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {
//    회원가입
    public void join(MemberDTO memberDTO);

//    이메일 검사
    public boolean isExistMemberEmail(String memberEmail);

//    로그인
    public Optional<MemberDTO> login(MemberDTO memberDTO);

//    카카오
//    기존 회원 정보 조회
    public Optional<MemberDTO> getKakaoMember(String kakaoEmail);

//    카카오 회원가입
    public void joinKakaoMember(MemberDTO memberDTO);

    default MemberVO toVO(MemberDTO memberDTO){
        return MemberVO.builder()
                .memberEmail(memberDTO.getMemberEmail())
                .memberPassword(memberDTO.getMemberPassword())
                .memberName(memberDTO.getMemberName())
                .memberStatus(memberDTO.getMemberStatus())
                .kakaoEmail(memberDTO.getKakaoEmail())
                .kakaoProfileUrl(memberDTO.getKakaoProfileUrl())
                .provider(memberDTO.getProvider())
                .createdDatetime(memberDTO.getCreatedDatetime())
                .updatedDatetime(memberDTO.getUpdatedDatetime())
                .build();
    }
}
