package com.example.threetier.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    public List<String> selectName(Map<String, String> columnMap);
}
