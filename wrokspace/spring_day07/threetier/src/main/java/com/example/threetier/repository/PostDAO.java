package com.example.threetier.repository;

import com.example.threetier.domain.PostVO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.mapper.PostMapper;
import com.example.threetier.util.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;
//    추가
    public void save(PostDTO postDTO) {
        postMapper.insertPost(postDTO);
    }

//    목록
    public List<PostDTO> findAll(Criteria criteria){
        return postMapper.selectAll(criteria);
    }

//    전체 개수 조회
    public int findCountAll(){
        return postMapper.selectCountAll();
    }

//    조회
    public Optional<PostDTO> findById(Long id) {
        return postMapper.selectPost(id);
    }

//    조회수 증가
    public void updatePostReadCount(Long id){
        postMapper.updatePostReadCount(id);
    }

//    수정
    public void setPost(PostVO postVO){
        postMapper.updatePost(postVO);
    }

//    삭제
    public void delete(Long id){
        postMapper.deletePost(id);
    }
}

















