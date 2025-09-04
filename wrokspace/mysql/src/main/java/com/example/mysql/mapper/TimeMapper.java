package com.example.mysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
//    @Select("select current_timestamp from dual")
    public String getTime();
}
