package com.example.mysql.mapper;

import com.example.mysql.domain.PostVO;
import com.example.mysql.dto.PostMemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
//    게시글 추가
//    게시글 조회
    public PostMemberDTO selectById(Long id);

//    게시글 수정
//    게시글 삭제
//    게시글 목록
}
