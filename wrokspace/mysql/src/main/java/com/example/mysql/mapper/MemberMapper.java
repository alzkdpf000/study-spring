package com.example.mysql.mapper;

import com.example.mysql.domain.MemberVO;
import com.example.mysql.dto.MemberDTO;
import com.example.mysql.enumeration.Status;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
//    회원 가입
    public void join(MemberVO memberVO);

//    로그인
    public MemberDTO login(MemberDTO memberDTO);
    
//    Status로 회원 조회
//    public Optional<MemberDTO> selectMemberByStatus(Status status);
    public List<MemberDTO> selectMemberByStatus(Status status);
}
