package com.example.threetier.mapper;

import com.example.threetier.domain.FileVO;
import com.example.threetier.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
//    추가
    public void insertFile(FileDTO fileDTO);

//    삭제
    public void deleteFile(Long id);
}
