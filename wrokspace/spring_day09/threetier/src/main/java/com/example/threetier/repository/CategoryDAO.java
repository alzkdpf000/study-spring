package com.example.threetier.repository;

import com.example.threetier.dto.CategoryDTO;
import com.example.threetier.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryDAO {
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll(){
        return categoryMapper.selectAll();
    }

    public List<CategoryDTO> findPostId(Long id){
        return categoryMapper.selectPostId(id);
    }
}
