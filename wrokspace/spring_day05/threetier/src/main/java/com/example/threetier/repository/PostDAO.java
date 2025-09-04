package com.example.threetier.repository;

import com.example.threetier.dto.PostDTO;
import com.example.threetier.mapper.PostMapper;
import com.example.threetier.util.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    목록
    public List<PostDTO> findAll(Criteria criteria){
        return postMapper.selectAll(criteria);
    }

//    전체 개수 조회
    public int findCountAll(){
        return postMapper.selectCountAll();
    }
}

















