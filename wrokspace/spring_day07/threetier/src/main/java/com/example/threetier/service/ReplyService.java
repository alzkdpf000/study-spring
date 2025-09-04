package com.example.threetier.service;

import com.example.threetier.domain.ReplyVO;
import com.example.threetier.dto.ReplyCriteriaDTO;
import com.example.threetier.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
//    추가
    public void write(ReplyDTO replyDTO);
//    전체 조회
    public ReplyCriteriaDTO getReplies(Long postId, int page);
//    수정
    public void update(ReplyDTO replyDTO);
//    삭제
    public void delete(Long id);

    default ReplyVO toReplyVO(ReplyDTO replyDTO){
        return ReplyVO.builder()
                .id(replyDTO.getId())
                .replyContent(replyDTO.getReplyContent())
                .memberId(replyDTO.getMemberId())
                .postId(replyDTO.getPostId())
                .createdDatetime(replyDTO.getCreatedDatetime())
                .updatedDatetime(replyDTO.getUpdatedDatetime())
                .build();
    }
}
