package com.example.threetier.service;

import com.example.threetier.domain.PostFileVO;
import com.example.threetier.domain.PostVO;
import com.example.threetier.dto.PostCriteriaDTO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.dto.PostFileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public interface PostService {
//    추가
    public void write(PostDTO postDTO, List<MultipartFile> files);
//    목록
    public PostCriteriaDTO getList(int page);
//    조회
    public Optional<PostDTO> getPost(Long id);
//    수정
    public void update(PostDTO postDTO, List<MultipartFile> files, Long[] deleteFileIds);
//    삭제
    public void delete(Long id);

    default PostVO toPostVO(PostDTO postDTO) {
        return PostVO.builder()
                .id(postDTO.getId())
                .postTitle(postDTO.getPostTitle())
                .postContent(postDTO.getPostContent())
                .postStatus(postDTO.getPostStatus())
                .createdDatetime(postDTO.getCreatedDatetime())
                .memberId(postDTO.getMemberId())
                .updatedDatetime(postDTO.getUpdatedDatetime())
                .build();
    }

    default PostFileVO toPostFileVO(PostFileDTO postFileDTO){
        return PostFileVO.builder()
                .id(postFileDTO.getId())
                .postId(postFileDTO.getPostId())
                .build();
    }

    default String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
