package com.example.threetier.service;

import com.example.threetier.dto.PostCriteriaDTO;
import com.example.threetier.dto.PostDTO;

import java.util.List;

public interface PostService {
//    목록
    public PostCriteriaDTO getList(int page);
}
