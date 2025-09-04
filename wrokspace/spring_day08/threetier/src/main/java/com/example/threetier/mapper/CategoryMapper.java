package com.example.threetier.mapper;

import com.example.threetier.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    public List<CategoryDTO> selectAll();

    public List<CategoryDTO> selectPostId(Long id);
}
