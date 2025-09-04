package com.example.threetier.mapper;

import com.example.threetier.domain.MemberVO;
import com.example.threetier.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    추가
    public void insertMember(MemberVO memberVO);
//    이메일 검사
    @Select("select count(*) > 0 from tbl_member where member_email = #{memberEmail}")
    public boolean existMemberEmail(String memberEmail);
//    조회
    public Optional<MemberDTO> selectMemberForLogin(MemberDTO memberDTO);
//    삭제
//    수정
}













