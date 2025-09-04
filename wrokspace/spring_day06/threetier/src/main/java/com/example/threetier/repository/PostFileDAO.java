package com.example.threetier.repository;

import com.example.threetier.domain.PostFileVO;
import com.example.threetier.dto.FileDTO;
import com.example.threetier.mapper.PostFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostFileDAO {
    private final PostFileMapper postFileMapper;

//    추가
    public void save(PostFileVO postFileVO){
        postFileMapper.insertPostFile(postFileVO);
    }
//    조회
    public List<FileDTO> findPostFilesByPostId(Long postId){
        return postFileMapper.selectPostFilesByPostId(postId);
    }

//    삭제
    public void delete(Long postId){
        postFileMapper.deletePostFile(postId);
    }
}
