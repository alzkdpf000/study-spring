package com.example.threetier.mapper;

import com.example.threetier.domain.PostVO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.util.Criteria;
import com.example.threetier.util.Search;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    추가
    public void insertPost(PostDTO postDTO);
//    조회
    public Optional<PostDTO> selectPost(Long id);
//    조회수 증가
    public void updatePostReadCount(Long id);
//    목록
    public List<PostDTO> selectAll(@Param("criteria") Criteria criteria, @Param("search")Search search);
//    전체 개수
    public int selectCountAll(@Param("search") Search search);
//    삭제
    public void deletePost(Long id);
//    수정
    public void updatePost(PostVO postVO);
}













