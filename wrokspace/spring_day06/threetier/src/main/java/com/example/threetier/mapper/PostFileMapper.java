package com.example.threetier.mapper;

import com.example.threetier.domain.PostFileVO;
import com.example.threetier.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PostFileMapper {
//    추가
    public void insertPostFile(PostFileVO postFileVO);
//    조회
    public List<FileDTO> selectPostFilesByPostId(Long postId);
    //    삭제
    public void deletePostFile(Long postId);

}
