package com.example.threetier.mapper;

import com.example.threetier.dto.PostDTO;
import com.example.threetier.util.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
//    추가
//    조회
//    목록
    public List<PostDTO> selectAll(Criteria criteria);
//    전체 개수
    public int selectCountAll();
//    삭제
//    수정
}













