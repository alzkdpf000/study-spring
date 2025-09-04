package com.example.threetier.repository;

import com.example.threetier.domain.FileVO;
import com.example.threetier.dto.FileDTO;
import com.example.threetier.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

//    추가
    public void save(FileDTO fileDTO){
        fileMapper.insertFile(fileDTO);
    }

//    삭제
    public void delete(Long id){
        fileMapper.deleteFile(id);
    }

//    조회
    public Optional<FileDTO> findById(Long id){
        return fileMapper.selectFileById(id);
    }
}
